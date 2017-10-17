package georgiopoulos.fixer.data.remote.dto;

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

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

public @Data class Rates{

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
}