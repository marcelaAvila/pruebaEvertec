package com.example.ecommerce.pojo.informationRequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class amount {

    @SerializedName("total")
    @Expose
    Double total;

    @SerializedName("currency")
    @Expose
    String currency;

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
