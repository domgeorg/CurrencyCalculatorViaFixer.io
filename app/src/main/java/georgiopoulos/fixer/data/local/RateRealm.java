package georgiopoulos.fixer.data.local;

import java.text.NumberFormat;
import java.util.Locale;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by domg on 14/10/2017.
 */
public class RateRealm extends RealmObject{

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

    /**
     * No args constructor for use in serialization
     *
     */
    public RateRealm() {
    }

    /**
     *
     * @param uSD
     * @param tRY
     * @param cHF
     * @param tHB
     * @param hUF
     * @param dKK
     * @param mYR
     * @param hRK
     * @param cZK
     * @param nZD
     * @param cNY
     * @param gBP
     * @param cAD
     * @param bRL
     * @param aUD
     * @param kRW
     * @param iDR
     * @param bGN
     * @param iNR
     * @param pLN
     * @param rUB
     * @param pHP
     * @param nOK
     * @param zAR
     * @param sGD
     * @param mXN
     * @param iLS
     * @param sEK
     * @param hKD
     * @param jPY
     * @param rON
     */
    public RateRealm(String date,double eUR, double aUD,double bGN,double bRL,double cAD,double cHF,double cNY,double cZK,double dKK,double gBP,double hKD,double hRK,double hUF,double iDR,double iLS,double iNR,double jPY,double kRW,double mXN,double mYR,double nOK,double nZD,double pHP,double pLN,double rON,double rUB,double sEK,double sGD,double tHB,double tRY,double uSD,double zAR) {
        super();
        this.date = date;
        this.eUR = eUR;
        this.aUD = aUD;
        this.bGN = bGN;
        this.bRL = bRL;
        this.cAD = cAD;
        this.cHF = cHF;
        this.cNY = cNY;
        this.cZK = cZK;
        this.dKK = dKK;
        this.gBP = gBP;
        this.hKD = hKD;
        this.hRK = hRK;
        this.hUF = hUF;
        this.iDR = iDR;
        this.iLS = iLS;
        this.iNR = iNR;
        this.jPY = jPY;
        this.kRW = kRW;
        this.mXN = mXN;
        this.mYR = mYR;
        this.nOK = nOK;
        this.nZD = nZD;
        this.pHP = pHP;
        this.pLN = pLN;
        this.rON = rON;
        this.rUB = rUB;
        this.sEK = sEK;
        this.sGD = sGD;
        this.tHB = tHB;
        this.tRY = tRY;
        this.uSD = uSD;
        this.zAR = zAR;
    }

    public String getDate() {
        return date;
    }

    public void setEUR(double eUR){this.eUR=eUR;}

    public double getEUR(){return eUR;}

    public void setDate(String date) {
        this.date = date;
    }

    public double getAUD() {
        return aUD;
    }

    public void setAUD(double aUD) {
        this.aUD = aUD;
    }

    public double getBGN() {
        return bGN;
    }

    public void setBGN(double bGN) {
        this.bGN = bGN;
    }

    public double getBRL() {
        return bRL;
    }

    public void setBRL(double bRL) {
        this.bRL = bRL;
    }

    public double getCAD() {
        return cAD;
    }

    public void setCAD(double cAD) {
        this.cAD = cAD;
    }

    public double getCHF() {
        return cHF;
    }

    public void setCHF(double cHF) {
        this.cHF = cHF;
    }

    public double getCNY() {
        return cNY;
    }

    public void setCNY(double cNY) {
        this.cNY = cNY;
    }

    public double getCZK() {
        return cZK;
    }

    public void setCZK(double cZK) {
        this.cZK = cZK;
    }

    public double getDKK() {
        return dKK;
    }

    public void setDKK(double dKK) {
        this.dKK = dKK;
    }

    public double getGBP() {
        return gBP;
    }

    public void setGBP(double gBP) {
        this.gBP = gBP;
    }

    public double getHKD() {
        return hKD;
    }

    public void setHKD(double hKD) {
        this.hKD = hKD;
    }

    public double getHRK() {
        return hRK;
    }

    public void setHRK(double hRK) {
        this.hRK = hRK;
    }

    public double getHUF() {
        return hUF;
    }

    public void setHUF(double hUF) {
        this.hUF = hUF;
    }

    public double getIDR() {
        return iDR;
    }

    public void setIDR(double iDR) {
        this.iDR = iDR;
    }

    public double getILS() {
        return iLS;
    }

    public void setILS(double iLS) {
        this.iLS = iLS;
    }

    public double getINR() {
        return iNR;
    }

    public void setINR(double iNR) {
        this.iNR = iNR;
    }

    public double getJPY() {
        return jPY;
    }

    public void setJPY(double jPY) {
        this.jPY = jPY;
    }

    public double getKRW() {
        return kRW;
    }

    public void setKRW(double kRW) {
        this.kRW = kRW;
    }

    public double getMXN() {
        return mXN;
    }

    public void setMXN(double mXN) {
        this.mXN = mXN;
    }

    public double getMYR() {
        return mYR;
    }

    public void setMYR(double mYR) {
        this.mYR = mYR;
    }

    public double getNOK() {
        return nOK;
    }

    public void setNOK(double nOK) {
        this.nOK = nOK;
    }

    public double getNZD() {
        return nZD;
    }

    public void setNZD(double nZD) {
        this.nZD = nZD;
    }

    public double getPHP() {
        return pHP;
    }

    public void setPHP(double pHP) {
        this.pHP = pHP;
    }

    public double getPLN() {
        return pLN;
    }

    public void setPLN(double pLN) {
        this.pLN = pLN;
    }

    public double getRON() {
        return rON;
    }

    public void setRON(double rON) {
        this.rON = rON;
    }

    public double getRUB() {
        return rUB;
    }

    public void setRUB(double rUB) {
        this.rUB = rUB;
    }

    public double getSEK() {
        return sEK;
    }

    public void setSEK(double sEK) {
        this.sEK = sEK;
    }

    public double getSGD() {
        return sGD;
    }

    public void setSGD(double sGD) {
        this.sGD = sGD;
    }

    public double getTHB() {
        return tHB;
    }

    public void setTHB(double tHB) {
        this.tHB = tHB;
    }

    public double getTRY() {
        return tRY;
    }

    public void setTRY(double tRY) {
        this.tRY = tRY;
    }

    public double getUSD() {
        return uSD;
    }

    public void setUSD(double uSD) {
        this.uSD = uSD;
    }

    public double getZAR() {
        return zAR;
    }

    public void setZAR(double zAR) {
        this.zAR = zAR;
    }

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