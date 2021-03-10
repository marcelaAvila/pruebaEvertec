package com.example.ecommerce.pojo.informationRequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class information {

    @SerializedName("auth")
    @Expose
    ArrayList<auth> auth;

    @SerializedName("instrument")
    @Expose
    ArrayList<instrument> instrument;

    @SerializedName("payment")
    @Expose
    ArrayList<payment> payment;

    public ArrayList<auth> getAuth() {
        return auth;
    }

    public void setAuth(ArrayList<auth> auth) {
        this.auth = auth;
    }

    public ArrayList<instrument> getInstrument() {
        return instrument;
    }

    public void setInstrument(ArrayList<instrument> instrument) {
        this.instrument = instrument;
    }

    public ArrayList<payment> getPayment() {
        return payment;
    }

    public void setPayment(ArrayList<payment> payment) {
        this.payment = payment;
    }
}
