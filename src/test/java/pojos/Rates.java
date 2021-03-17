package pojos;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CAD",
        "HKD",
        "ISK",
        "PHP",
        "DKK",
        "HUF",
        "CZK",
        "AUD",
        "RON",
        "SEK",
        "IDR",
        "INR",
        "BRL",
        "RUB",
        "HRK",
        "JPY",
        "THB",
        "CHF",
        "SGD",
        "PLN",
        "BGN",
        "TRY",
        "CNY",
        "NOK",
        "NZD",
        "ZAR",
        "USD",
        "MXN",
        "ILS",
        "GBP",
        "KRW",
        "MYR",
        "EUR"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rates {

    @JsonProperty("CAD")
    private Double cAD;
    @JsonProperty("HKD")
    private Double hKD;
    @JsonProperty("ISK")
    private Double iSK;
    @JsonProperty("PHP")
    private Double pHP;
    @JsonProperty("DKK")
    private Double dKK;
    @JsonProperty("HUF")
    private Double hUF;
    @JsonProperty("CZK")
    private Double cZK;
    @JsonProperty("AUD")
    private Double aUD;
    @JsonProperty("RON")
    private Double rON;
    @JsonProperty("SEK")
    private Double sEK;
    @JsonProperty("IDR")
    private Double iDR;
    @JsonProperty("INR")
    private Double iNR;
    @JsonProperty("BRL")
    private Double bRL;
    @JsonProperty("RUB")
    private Double rUB;
    @JsonProperty("HRK")
    private Double hRK;
    @JsonProperty("JPY")
    private Double jPY;
    @JsonProperty("THB")
    private Double tHB;
    @JsonProperty("CHF")
    private Double cHF;
    @JsonProperty("SGD")
    private Double sGD;
    @JsonProperty("PLN")
    private Double pLN;
    @JsonProperty("BGN")
    private Double bGN;
    @JsonProperty("TRY")
    private Double tRY;
    @JsonProperty("CNY")
    private Double cNY;
    @JsonProperty("NOK")
    private Double nOK;
    @JsonProperty("NZD")
    private Double nZD;
    @JsonProperty("ZAR")
    private Double zAR;
    @JsonProperty("USD")
    private Double uSD;
    @JsonProperty("MXN")
    private Double mXN;
    @JsonProperty("ILS")
    private Double iLS;
    @JsonProperty("GBP")
    private Double gBP;
    @JsonProperty("KRW")
    private Double kRW;
    @JsonProperty("MYR")
    private Double mYR;
    @JsonProperty("EUR")
    private Double eUR;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Rates() {
    }

    /**
     * @param hKD
     * @param iSK
     * @param dKK
     * @param cAD
     * @param uSD
     * @param mYR
     * @param bGN
     * @param nOK
     * @param rON
     * @param sGD
     * @param cZK
     * @param sEK
     * @param nZD
     * @param bRL
     * @param hRK
     * @param cHF
     * @param mXN
     * @param zAR
     * @param iNR
     * @param tHB
     * @param cNY
     * @param aUD
     * @param iLS
     * @param kRW
     * @param jPY
     * @param pLN
     * @param gBP
     * @param iDR
     * @param hUF
     * @param pHP
     * @param tRY
     * @param rUB
     */
    public Rates(Double cAD, Double hKD, Double iSK, Double pHP, Double dKK, Double hUF, Double cZK, Double aUD, Double rON, Double sEK, Double iDR, Double iNR, Double bRL, Double rUB, Double hRK, Double jPY, Double tHB, Double cHF, Double sGD, Double pLN, Double bGN, Double tRY, Double cNY, Double nOK, Double nZD, Double zAR, Double uSD, Double mXN, Double iLS, Double gBP, Double kRW, Double mYR, Double eUR) {
        this.cAD = cAD;
        this.hKD = hKD;
        this.iSK = iSK;
        this.pHP = pHP;
        this.dKK = dKK;
        this.hUF = hUF;
        this.cZK = cZK;
        this.aUD = aUD;
        this.rON = rON;
        this.sEK = sEK;
        this.iDR = iDR;
        this.iNR = iNR;
        this.bRL = bRL;
        this.rUB = rUB;
        this.hRK = hRK;
        this.jPY = jPY;
        this.tHB = tHB;
        this.cHF = cHF;
        this.sGD = sGD;
        this.pLN = pLN;
        this.bGN = bGN;
        this.tRY = tRY;
        this.cNY = cNY;
        this.nOK = nOK;
        this.nZD = nZD;
        this.zAR = zAR;
        this.uSD = uSD;
        this.mXN = mXN;
        this.iLS = iLS;
        this.gBP = gBP;
        this.kRW = kRW;
        this.mYR = mYR;
        this.eUR = eUR;
    }

    @JsonProperty("CAD")
    public Double getCAD() {
        return cAD;
    }

    @JsonProperty("CAD")
    public void setCAD(Double cAD) {
        this.cAD = cAD;
    }

    @JsonProperty("HKD")
    public Double getHKD() {
        return hKD;
    }

    @JsonProperty("HKD")
    public void setHKD(Double hKD) {
        this.hKD = hKD;
    }

    @JsonProperty("ISK")
    public Double getISK() {
        return iSK;
    }

    @JsonProperty("ISK")
    public void setISK(Double iSK) {
        this.iSK = iSK;
    }

    @JsonProperty("PHP")
    public Double getPHP() {
        return pHP;
    }

    @JsonProperty("PHP")
    public void setPHP(Double pHP) {
        this.pHP = pHP;
    }

    @JsonProperty("DKK")
    public Double getDKK() {
        return dKK;
    }

    @JsonProperty("DKK")
    public void setDKK(Double dKK) {
        this.dKK = dKK;
    }

    @JsonProperty("HUF")
    public Double getHUF() {
        return hUF;
    }

    @JsonProperty("HUF")
    public void setHUF(Double hUF) {
        this.hUF = hUF;
    }

    @JsonProperty("CZK")
    public Double getCZK() {
        return cZK;
    }

    @JsonProperty("CZK")
    public void setCZK(Double cZK) {
        this.cZK = cZK;
    }

    @JsonProperty("AUD")
    public Double getAUD() {
        return aUD;
    }

    @JsonProperty("AUD")
    public void setAUD(Double aUD) {
        this.aUD = aUD;
    }

    @JsonProperty("RON")
    public Double getRON() {
        return rON;
    }

    @JsonProperty("RON")
    public void setRON(Double rON) {
        this.rON = rON;
    }

    @JsonProperty("SEK")
    public Double getSEK() {
        return sEK;
    }

    @JsonProperty("SEK")
    public void setSEK(Double sEK) {
        this.sEK = sEK;
    }

    @JsonProperty("IDR")
    public Double getIDR() {
        return iDR;
    }

    @JsonProperty("IDR")
    public void setIDR(Double iDR) {
        this.iDR = iDR;
    }

    @JsonProperty("INR")
    public Double getINR() {
        return iNR;
    }

    @JsonProperty("INR")
    public void setINR(Double iNR) {
        this.iNR = iNR;
    }

    @JsonProperty("BRL")
    public Double getBRL() {
        return bRL;
    }

    @JsonProperty("BRL")
    public void setBRL(Double bRL) {
        this.bRL = bRL;
    }

    @JsonProperty("RUB")
    public Double getRUB() {
        return rUB;
    }

    @JsonProperty("RUB")
    public void setRUB(Double rUB) {
        this.rUB = rUB;
    }

    @JsonProperty("HRK")
    public Double getHRK() {
        return hRK;
    }

    @JsonProperty("HRK")
    public void setHRK(Double hRK) {
        this.hRK = hRK;
    }

    @JsonProperty("JPY")
    public Double getJPY() {
        return jPY;
    }

    @JsonProperty("JPY")
    public void setJPY(Double jPY) {
        this.jPY = jPY;
    }

    @JsonProperty("THB")
    public Double getTHB() {
        return tHB;
    }

    @JsonProperty("THB")
    public void setTHB(Double tHB) {
        this.tHB = tHB;
    }

    @JsonProperty("CHF")
    public Double getCHF() {
        return cHF;
    }

    @JsonProperty("CHF")
    public void setCHF(Double cHF) {
        this.cHF = cHF;
    }

    @JsonProperty("SGD")
    public Double getSGD() {
        return sGD;
    }

    @JsonProperty("SGD")
    public void setSGD(Double sGD) {
        this.sGD = sGD;
    }

    @JsonProperty("PLN")
    public Double getPLN() {
        return pLN;
    }

    @JsonProperty("PLN")
    public void setPLN(Double pLN) {
        this.pLN = pLN;
    }

    @JsonProperty("BGN")
    public Double getBGN() {
        return bGN;
    }

    @JsonProperty("BGN")
    public void setBGN(Double bGN) {
        this.bGN = bGN;
    }

    @JsonProperty("TRY")
    public Double getTRY() {
        return tRY;
    }

    @JsonProperty("TRY")
    public void setTRY(Double tRY) {
        this.tRY = tRY;
    }

    @JsonProperty("CNY")
    public Double getCNY() {
        return cNY;
    }

    @JsonProperty("CNY")
    public void setCNY(Double cNY) {
        this.cNY = cNY;
    }

    @JsonProperty("NOK")
    public Double getNOK() {
        return nOK;
    }

    @JsonProperty("NOK")
    public void setNOK(Double nOK) {
        this.nOK = nOK;
    }

    @JsonProperty("NZD")
    public Double getNZD() {
        return nZD;
    }

    @JsonProperty("NZD")
    public void setNZD(Double nZD) {
        this.nZD = nZD;
    }

    @JsonProperty("ZAR")
    public Double getZAR() {
        return zAR;
    }

    @JsonProperty("ZAR")
    public void setZAR(Double zAR) {
        this.zAR = zAR;
    }

    @JsonProperty("USD")
    public Double getUSD() {
        return uSD;
    }

    @JsonProperty("USD")
    public void setUSD(Double uSD) {
        this.uSD = uSD;
    }

    @JsonProperty("MXN")
    public Double getMXN() {
        return mXN;
    }

    @JsonProperty("MXN")
    public void setMXN(Double mXN) {
        this.mXN = mXN;
    }

    @JsonProperty("ILS")
    public Double getILS() {
        return iLS;
    }

    @JsonProperty("ILS")
    public void setILS(Double iLS) {
        this.iLS = iLS;
    }

    @JsonProperty("GBP")
    public Double getGBP() {
        return gBP;
    }

    @JsonProperty("GBP")
    public void setGBP(Double gBP) {
        this.gBP = gBP;
    }

    @JsonProperty("KRW")
    public Double getKRW() {
        return kRW;
    }

    @JsonProperty("KRW")
    public void setKRW(Double kRW) {
        this.kRW = kRW;
    }

    @JsonProperty("MYR")
    public Double getMYR() {
        return mYR;
    }

    @JsonProperty("MYR")
    public void setMYR(Double mYR) {
        this.mYR = mYR;
    }

    @JsonProperty("EUR")
    public Double getEUR() {
        return eUR;
    }

    @JsonProperty("EUR")
    public void setEUR(Double eUR) {
        this.eUR = eUR;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("cAD", cAD).append("hKD", hKD).append("iSK", iSK).append("pHP", pHP).append("dKK", dKK).append("hUF", hUF).append("cZK", cZK).append("aUD", aUD).append("rON", rON).append("sEK", sEK).append("iDR", iDR).append("iNR", iNR).append("bRL", bRL).append("rUB", rUB).append("hRK", hRK).append("jPY", jPY).append("tHB", tHB).append("cHF", cHF).append("sGD", sGD).append("pLN", pLN).append("bGN", bGN).append("tRY", tRY).append("cNY", cNY).append("nOK", nOK).append("nZD", nZD).append("zAR", zAR).append("uSD", uSD).append("mXN", mXN).append("iLS", iLS).append("gBP", gBP).append("kRW", kRW).append("mYR", mYR).append("additionalProperties", additionalProperties).toString();
    }

}