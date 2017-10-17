package georgiopoulos.fixer.data.local;

import java.text.NumberFormat;
import java.util.Locale;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Data;

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
public @Data class RateRealm extends RealmObject{

    @PrimaryKey
    private String date;
    private double eUR;
    private double aUD;
    private double bGN;
    private double bRL;
    private double cAD;
    private double cHF;
    private double cNY;
    private double cZK;
    private double dKK;
    private double gBP;
    private double hKD;
    private double hRK;
    private double hUF;
    private double iDR;
    private double iLS;
    private double iNR;
    private double jPY;
    private double kRW;
    private double mXN;
    private double mYR;
    private double nOK;
    private double nZD;
    private double pHP;
    private double pLN;
    private double rON;
    private double rUB;
    private double sEK;
    private double sGD;
    private double tHB;
    private double tRY;
    private double uSD;
    private double zAR;

    public double map(int position){
        switch(position){
            case 1: return aUD;
            case 2: return bGN;
            case 3: return bRL;
            case 4: return cAD;
            case 5: return cHF;
            case 6: return cNY;
            case 7: return cZK;
            case 8: return dKK;
            case 9: return gBP;
            case 10: return hKD;
            case 11: return hRK;
            case 12: return hUF;
            case 13: return iDR;
            case 14: return iLS;
            case 15: return iNR;
            case 16: return jPY;
            case 17: return kRW;
            case 18: return mXN;
            case 19: return mYR;
            case 20: return nOK;
            case 21: return nZD;
            case 22: return pHP;
            case 23: return pLN;
            case 24: return rON;
            case 25: return rUB;
            case 26: return sEK;
            case 27: return sGD;
            case 28: return tHB;
            case 29: return tRY;
            case 30: return uSD;
            case 31: return zAR;
            default: return eUR;
        }
    }

    public String currencyAmount(int position, double amount){
        Locale locale;
        switch(position){
            case 1: {locale = new Locale.Builder().setRegion("AU").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 2: {locale = new Locale.Builder().setRegion("BG").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 3: {locale = new Locale.Builder().setRegion("BR").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 4: {locale = new Locale.Builder().setRegion("CA").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 5: {locale = new Locale.Builder().setRegion("CH").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 6: {locale = new Locale.Builder().setRegion("CN").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 7: {locale = new Locale.Builder().setRegion("CZ").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 8: {locale = new Locale.Builder().setRegion("DK").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 9: {locale = new Locale.Builder().setRegion("GB").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 10: {locale = new Locale.Builder().setRegion("HK").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 11: {locale = new Locale.Builder().setRegion("HR").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 12: {locale = new Locale.Builder().setRegion("HU").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 13: {locale = new Locale.Builder().setRegion("ID").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 14: {locale = new Locale.Builder().setRegion("IL").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 15: {locale = new Locale.Builder().setRegion("IN").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 16: {locale = new Locale.Builder().setRegion("JP").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 17: {locale = new Locale.Builder().setRegion("KR").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 18: {locale = new Locale.Builder().setRegion("MX").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 19: {locale = new Locale.Builder().setRegion("MY").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 20: {locale = new Locale.Builder().setRegion("NO").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 21: {locale = new Locale.Builder().setRegion("NZ").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 22: {locale = new Locale.Builder().setRegion("PH").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 23: {locale = new Locale.Builder().setRegion("PL").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 24: {locale = new Locale.Builder().setRegion("RO").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 25: {locale = new Locale.Builder().setRegion("RU").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 26: {locale = new Locale.Builder().setRegion("SE").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 27: {locale = new Locale.Builder().setRegion("SG").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 28: {locale = new Locale.Builder().setRegion("TH").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 29: {locale = new Locale.Builder().setRegion("TR").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 30: {locale = new Locale.Builder().setRegion("US").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            case 31: {locale = new Locale.Builder().setRegion("ZA").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
            default: {locale = new Locale.Builder().setRegion("EU").build();
                return NumberFormat.getCurrencyInstance(locale).format(amount);}
        }
    }
}