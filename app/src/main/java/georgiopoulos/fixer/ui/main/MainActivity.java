package georgiopoulos.fixer.ui.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import butterknife.OnItemSelected;
import georgiopoulos.fixer.R;
import georgiopoulos.fixer.data.local.RateRealm;
import georgiopoulos.fixer.ui.base.BaseActivity;
import georgiopoulos.fixer.utils.MathParser;
import icepick.State;
import nucleus.factory.RequiresPresenter;

/**
 *  Copyright 2017 georgiopoulos kyriakos
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@RequiresPresenter(MainPresenter.class)
public class MainActivity extends BaseActivity<MainPresenter>{

    public static final String MATH_OPERATORS="+-*/";
    private static final String MATH_NUMBERS="0123456789";
    @State StringBuilder algebraic_expression = new StringBuilder();
    private SuperToast superToast;
    private DecimalFormat decimalFormat;
    private int itemPositionBase;
    private int itemPositionExchange;

    @BindView(R.id.calculator_text_view) TextView calculatorTextView;

    @Override public void onCreate (Bundle savedState){
        super.onCreate(savedState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        superToast = new SuperToast(this).setTextSize(R.dimen.toastTextSize).setTextColor(PaletteUtils.getSolidColor(PaletteUtils.BLACK)).setDuration(Style.DURATION_SHORT).setFrame(Style.FRAME_STANDARD).setColor(getResources().getColor(R.color.colorToast)).setAnimations(Style.ANIMATIONS_SCALE);
        decimalFormat = new DecimalFormat("#.##",new DecimalFormatSymbols(Locale.US));
        calculatorTextView.setText(algebraic_expression);
    }

    @OnClick(R.id.exchange)
    public void onExchangeClick(){
        String s = algebraic_expression.toString();
        if((s.length() == 0) || s.contains("+") || s.contains("*") || s.contains("(") || s.contains(")") || s.contains("/") || s.contains("-"))
            superToast.setText("Invalid amount").show();
        else if(itemPositionBase == itemPositionExchange) superToast.setText("Same currency").show();
        else getPresenter().loadExchangeRates();
    }

    public void displayExchange(RateRealm rateRealm){
        String s = algebraic_expression.toString();
            double A = rateRealm.map(itemPositionBase);
            double B = rateRealm.map(itemPositionExchange);
            if(A != B){
                double result = Double.valueOf(s) * ((1 / A) * B);
                algebraic_expression.setLength(0);
                algebraic_expression.append(decimalFormat.format(result));
                calculatorTextView.setText(algebraic_expression);
                toaster(rateRealm.currencyAmount(itemPositionBase,Double.valueOf(s)) + "\n=\n" +
                        rateRealm.currencyAmount(itemPositionExchange,result));
            }
    }

    @OnItemSelected({R.id.spinner_currency_base,R.id.spinner_currency_exchange})
    public void spinnerItemSelected(Spinner spinner, int position){
        if(spinner.getId()==R.id.spinner_currency_base)itemPositionBase=position;
        else itemPositionExchange=position;
    }

    @OnClick({R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,R.id.plus,R.id.minus,R.id.multiply,R.id.divide,R.id.open_bracket,R.id.close_brackets})
    public void onClick(Button clickedButton){
        if(clickedButton.getId() == R.id.open_bracket && algebraic_expression.length() > 0){
            char preChar = algebraic_expression.charAt(algebraic_expression.length() - 1);
            if(MATH_NUMBERS.contains("" + preChar) || preChar == ')') algebraic_expression.append('*');
        }
        algebraic_expression.append(clickedButton.getText());
        calculatorTextView.setText(algebraic_expression);
    }

    @OnClick(R.id.backspase)
    public void onBackspaceClick(){
        if(algebraic_expression.length() == 0){return;}
        algebraic_expression.deleteCharAt(algebraic_expression.length()-1);
        calculatorTextView.setText(algebraic_expression);
    }

    @OnClick(R.id.clear)
    public void onClearClick(){
        if(algebraic_expression.length() == 0){return;}
        algebraic_expression.delete(0,algebraic_expression.length());
        calculatorTextView.setText(algebraic_expression);
    }

    @OnClick(R.id.point)
    public void onDotClick(){
        if(lastNumberHasDot(algebraic_expression)){return;}
        algebraic_expression.append('.');
        calculatorTextView.setText(algebraic_expression);
    }

    @OnClick(R.id.equal)
    public void onEqualClick(){
        if (algebraic_expression.length() != 0) try{
            MathParser mathParser = new MathParser();
            Double result = mathParser.eval(algebraic_expression.toString());
            algebraic_expression.setLength(0);
            algebraic_expression.append(decimalFormat.format(result));
            calculatorTextView.setText(algebraic_expression);
        }catch(Exception e){
            toaster("Incorrect Input");
        }
    }

    private boolean lastNumberHasDot(StringBuilder stringBuilder){
        StringBuilder builder = new StringBuilder();
        int length=stringBuilder.length() - 1;
        for (int i=length; i>=0 && !(MATH_OPERATORS.contains("" +stringBuilder.charAt(i))); i--)
            builder.append(stringBuilder.charAt(i));
        return builder.toString().contains(".");
    }

    public void toaster(String toastText){
        superToast.setText(toastText).show();
    }
}
