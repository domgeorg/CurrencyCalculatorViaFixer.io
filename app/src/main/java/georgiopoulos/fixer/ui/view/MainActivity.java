package georgiopoulos.fixer.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import georgiopoulos.fixer.App;
import georgiopoulos.fixer.R;
import georgiopoulos.fixer.data.local.RateRealm;
import georgiopoulos.fixer.data.remote.api.FixerService;
import georgiopoulos.fixer.ui.presenter.MainPresenter;
import georgiopoulos.fixer.ui.view.MainMvpView;
import georgiopoulos.fixer.utils.MathParser;
import io.realm.Realm;
import rx.Subscription;

public class MainActivity extends AppCompatActivity implements MainMvpView{

    private static final String TAG = "MainActivity";

    @Inject
    public FixerService service;

    private MainPresenter presenter;

    public static final  String        MATH_OPERATORS = "+-*/";
    private static final String        MATH_NUMBERS   = "0123456789";
    private StringBuilder mathStr        = new StringBuilder();
    private DecimalFormat decimalFormat = new DecimalFormat("#.##",new DecimalFormatSymbols(Locale.US));

    @BindView(R.id.calculator_text_view)
    TextView calculatorTextView;
    @BindView(R.id.spinner_currency_base)
    Spinner currencyBaseSpinner;
    @BindView(R.id.spinner_currency_exchange)
    Spinner currencyExchangeSpinner;

    public FixerService getService(){
        return service;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        presenter = new MainPresenter();
        presenter.attachView(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((App)getApplication()).component.inject(this);
    }

    @OnClick(R.id.exchange)
    public void onExchangeClick(){
        presenter.loadExchangeRates();
    }

    // Input *( (1/A) * B )
    public void displayExchange(RateRealm rateRealm){
        Log.d(TAG,"Date: " + rateRealm.getDate() + ", AUD " +rateRealm.getAUD()+ ", bGN "+rateRealm.getBGN() + "...");
        String s = mathStr.toString();

        if(s.length()==0 || s.contains("+")||s.contains("*")||s.contains("(")||s.contains(")")||s.contains("/")||s.contains("-")){
            new SuperToast(this).setText("Set a valid amount :p").setTextSize(R.dimen.toastTextSize).setTextColor(PaletteUtils.getSolidColor(PaletteUtils.BLACK)).setDuration(Style.DURATION_SHORT).setFrame(Style.FRAME_STANDARD).setColor(getResources().getColor(R.color.colorAccent)).setAnimations(Style.ANIMATIONS_SCALE).show();
        }
        else{
            try{
                int itemPositionBase=currencyBaseSpinner.getSelectedItemPosition();
                int itemPositionExchange=currencyExchangeSpinner.getSelectedItemPosition();
                double A = rateRealm.map(itemPositionBase);
                double B = rateRealm.map(itemPositionExchange);
                if(A!=B){
                    double result = Double.valueOf(s)*((1/A)*B);
                    mathStr.setLength(0);
                    mathStr.append(decimalFormat.format(result));
                    calculatorTextView.setText(mathStr);
                    new SuperToast(this).setText(rateRealm.currencyAmount(itemPositionBase,Double.valueOf(s))+"\n=\n"+rateRealm.currencyAmount(itemPositionExchange, result)).setTextSize(R.dimen.toastTextSize).setTextColor(PaletteUtils.getSolidColor(PaletteUtils.BLACK)).setDuration(Style.DURATION_LONG).setFrame(Style.FRAME_STANDARD).setColor(getResources().getColor(R.color.colorAccent)).setAnimations(Style.ANIMATIONS_FLY).show();
                }
            }catch(Exception e){
                e.printStackTrace();
                Log.e(TAG,e.getLocalizedMessage(),e);
            }
        }
    }

    public void processError(Throwable e){
        Log.e(TAG,e.getLocalizedMessage(),e);
        new SuperToast(this).setText(e.getMessage()).setTextSize(R.dimen.toastTextSize).setTextColor(PaletteUtils.getSolidColor(PaletteUtils.BLACK)).setDuration(Style.DURATION_SHORT).setFrame(Style.FRAME_STANDARD).setColor(getResources().getColor(R.color.colorAccent)).setAnimations(Style.ANIMATIONS_SCALE).show();
    }

    @OnClick({R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,R.id.plus,R.id.minus,R.id.multiply,R.id.divide,R.id.open_bracket,R.id.close_brackets})
    public void onClick(Button clickedButton){
        if (clickedButton.getId() == R.id.open_bracket){
            if(mathStr.length()>0){
                char preChar = mathStr.charAt(mathStr.length()-1);
                if (MATH_NUMBERS.contains(""+preChar) || preChar == ')') mathStr.append('*');
            }
        }
        mathStr.append(clickedButton.getText());
        calculatorTextView.setText(mathStr);
    }

    @OnClick(R.id.backspase)
    public void onBackspaceClick(){
        if (mathStr.length() != 0){
            mathStr.deleteCharAt(mathStr.length() - 1);
            calculatorTextView.setText(mathStr);
        }
    }

    @OnClick(R.id.clear)
    public void onClearClick(){
        if (mathStr.length() != 0){
            mathStr.delete(0,mathStr.length());
            calculatorTextView.setText(mathStr);
        }
    }

    @OnClick(R.id.point)
    public void onDotClick(){
        if (!isLastNumberHasDot(mathStr)){
            mathStr.append('.');
            calculatorTextView.setText(mathStr);
        }
    }

    @OnClick(R.id.equal)
    public void onEqualClick(){
        if (mathStr.length() != 0){
            try{
                MathParser mathParser = new MathParser();
                Double result = mathParser.eval(mathStr.toString());
                mathStr.setLength(0);
                mathStr.append(decimalFormat.format(result));
                calculatorTextView.setText(mathStr);
            }catch (Exception e){
                Log.e(TAG,e.getLocalizedMessage(),e);
                new SuperToast(this).setText("Incorrect Input").setTextSize(R.dimen.toastTextSize).setTextColor(PaletteUtils.getSolidColor(PaletteUtils.BLACK)).setDuration(Style.DURATION_SHORT).setFrame(Style.FRAME_STANDARD).setColor(getResources().getColor(R.color.colorAccent)).setAnimations(Style.ANIMATIONS_SCALE).show();
            }
        }
    }

    public boolean isLastNumberHasDot(StringBuilder str){
        StringBuilder builder = new StringBuilder();
        int length = str.length() - 1;
        for (int i = length; i >= 0 && !(MATH_OPERATORS.contains("" + str.charAt(i))); i--){
            builder.append(str.charAt(i));
        }
        return builder.toString().contains(".");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        //if (subscription!=null)subscription.unsubscribe();
       //realmUI.close();
    }

}
