package com.example.ecommerce.pojo.processTransaction.instrument;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class card {

    @SerializedName("number")
    @Expose
    String number;
    @SerializedName("expirationMonth")
    @Expose
    String expirationMonth;
    @SerializedName("expirationYear")
    @Expose
    String expirationYear;
    @SerializedName("cvv")
    @Expose
    String cvv;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
