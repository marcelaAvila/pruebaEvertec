package com.example.ecommerce.pojo.processTransaction.payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class amount {

    @SerializedName("taxes")
    @Expose
    taxes taxes;

    @SerializedName("details")
    @Expose
    details details;

    @SerializedName("currency")
    @Expose
    String currency;

    @SerializedName("total")
    @Expose
    Double total;

    public taxes getTaxes() {
        return taxes;
    }

    public void setTaxes(taxes taxes) {
        this.taxes = taxes;
    }

    public details getDetails() {
        return details;
    }

    public void setDetails(details details) {
        this.details = details;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
