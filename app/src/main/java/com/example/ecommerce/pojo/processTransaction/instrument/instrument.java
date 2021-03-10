package com.example.ecommerce.pojo.processTransaction.instrument;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class instrument {

    @SerializedName("otp")
    @Expose
    String otp;
    @SerializedName("card")
    @Expose
    card card;
    @SerializedName("credit")
    @Expose
    credit credit;

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public card getCard() {
        return card;
    }

    public void setCard(card card) {
        this.card = card;
    }

    public credit getCredit() {
        return credit;
    }

    public void setCredit(credit credit) {
        this.credit = credit;
    }
}
