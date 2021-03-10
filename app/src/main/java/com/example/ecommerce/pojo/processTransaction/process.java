package com.example.ecommerce.pojo.processTransaction;

import com.example.ecommerce.pojo.processTransaction.instrument.instrument;
import com.example.ecommerce.pojo.processTransaction.payment.payment;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class process {

    @SerializedName("auth")
    @Expose
    auth auth;

    @SerializedName("payment")
    @Expose
    payment payment;

    @SerializedName("ipAddress")
    @Expose
    String ipAddress;

    @SerializedName("locale")
    @Expose
    String locale;

    @SerializedName("userAgent")
    @Expose
    String userAgent;

    @SerializedName("instrument")
    @Expose
    instrument instrument;

    @SerializedName("payer")
    @Expose
    payer payer;

    @SerializedName("buyer")
    @Expose
    buyer buyer;

    public auth getAuth() {
        return auth;
    }

    public void setAuth(auth auth) {
        this.auth = auth;
    }

    public payment getPayment() {
        return payment;
    }

    public void setPayment(payment payment) {
        this.payment = payment;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(instrument instrument) {
        this.instrument = instrument;
    }

    public payer getPayer() {
        return payer;
    }

    public void setPayer(payer payer) {
        this.payer = payer;
    }

    public buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(buyer buyer) {
        this.buyer = buyer;
    }
}
