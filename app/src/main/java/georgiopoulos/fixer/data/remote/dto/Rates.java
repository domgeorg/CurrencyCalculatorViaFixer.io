package georgiopoulos.fixer.data.remote.dto;

/**
 * Created by domg on 14/10/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rates {

    @SerializedName("AUD")
    @Expose
    private double aUD;
    @SerializedName("BGN")
    @Expose
    private double bGN;
    @SerializedName("BRL")
    @Expose
    private double bRL;
    @SerializedName("CAD")
    @Expose
    private double cAD;
    @SerializedName("CHF")
    @Expose
    private double cHF;
    @SerializedName("CNY")
    @Expose
    private double cNY;
    @SerializedName("CZK")
    @Expose
    private double cZK;
    @SerializedName("DKK")
    @Expose
    private double dKK;
    @SerializedName("GBP")
    @Expose
    private double gBP;
    @SerializedName("HKD")
    @Expose
    private double hKD;
    @SerializedName("HRK")
    @Expose
    private double hRK;
    @SerializedName("HUF")
    @Expose
    private double hUF;
    @SerializedName("IDR")
    @Expose
    private double iDR;
    @SerializedName("ILS")
    @Expose
    private double iLS;
    @SerializedName("INR")
    @Expose
    private double iNR;
    @SerializedName("JPY")
    @Expose
    private double jPY;
    @SerializedName("KRW")
    @Expose
    private double kRW;
    @SerializedName("MXN")
    @Expose
    private double mXN;
    @SerializedName("MYR")
    @Expose
    private double mYR;
    @SerializedName("NOK")
    @Expose
    private double nOK;
    @SerializedName("NZD")
    @Expose
    private double nZD;
    @SerializedName("PHP")
    @Expose
    private double pHP;
    @SerializedName("PLN")
    @Expose
    private double pLN;
    @SerializedName("RON")
    @Expose
    private double rON;
    @SerializedName("RUB")
    @Expose
    private double rUB;
    @SerializedName("SEK")
    @Expose
    private double sEK;
    @SerializedName("SGD")
    @Expose
    private double sGD;
    @SerializedName("THB")
    @Expose
    private double tHB;
    @SerializedName("TRY")
    @Expose
    private double tRY;
    @SerializedName("USD")
    @Expose
    private double uSD;
    @SerializedName("ZAR")
    @Expose
    private double zAR;

    /**
     * No args constructor for use in serialization
     *
     */
    public Rates() {
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
    public Rates(double aUD, double bGN, double bRL, double cAD, double cHF, double cNY, double cZK, double dKK, double gBP, double hKD, double hRK, double hUF, double iDR, double iLS, double iNR, double jPY, double kRW, double mXN, double mYR, double nOK, double nZD, double pHP, double pLN, double rON, double rUB, double sEK, double sGD, double tHB, double tRY, double uSD, double zAR) {
        super();
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

}
