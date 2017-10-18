package georgiopoulos.fixer.utils;

import java.util.LinkedList;

import georgiopoulos.fixer.ui.main.MainActivity;

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

public class MathParser{

    private char[]operators ={'+','-','*','/'};

    private boolean isOperator(char c){
        return String.copyValueOf(operators).contains("" + c);
    }

    private boolean isBracket(char c){
        return c == '(' || c == ')';
    }

    private int priority(char oper){
        if (oper == '*' || oper == '/') return 2;
        else if (oper == '+' || oper == '-') return 1;
        else if (oper == '|' || oper == '&' || oper == '^') return 0;
        else return -1;
    }

    private void letGo(LinkedList<Double> st,char oper){
        Double someOne = st.removeLast();
        Double someTwo = st.removeLast();
        switch (oper){
            case '+':st.add(someTwo + someOne);break;
            case '-':st.add(someTwo - someOne);break;
            case '*':st.add(someTwo * someOne);break;
            case '/':st.add(someTwo / someOne);break;
        }
    }

    public Double eval(String s){
        LinkedList<Double> someNumbers = new LinkedList<>();
        LinkedList<Character> someOpers = new LinkedList<>();
        boolean isNegativeNumber = false;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '-') {
                if (i == 0 || s.charAt(i - 1) == '(' || MainActivity.MATH_OPERATORS.contains("" + s.charAt(i - 1))){
                    isNegativeNumber = true;
                    i++;
                }
            }
            char c = s.charAt(i);
            if (c == '('){
                someOpers.add('(');
            }else if (c == ')'){
                while(someOpers.getLast() != '('){
                    letGo(someNumbers, someOpers.removeLast());
                }
                someOpers.removeLast();
            }else if (isOperator(c)){
                while (!someOpers.isEmpty() && priority(someOpers.getLast()) >= priority(c)){
                    letGo(someNumbers, someOpers.removeLast());
                }
                someOpers.add(c);
            }else{
                StringBuilder operand = new StringBuilder();
                if (isNegativeNumber){
                    operand.append('-');
                    isNegativeNumber = false;
                }
                while (i < s.length() && !isOperator(s.charAt(i)) && !isBracket(s.charAt(i))) {
                    operand.append(s.charAt(i++));
                }
                --i;
                someNumbers.add(Double.parseDouble(operand.toString()));
            }
        }
        while (!someOpers.isEmpty()){
            letGo(someNumbers, someOpers.removeLast());
        }
        return (someNumbers.get(0));
    }
}