package com.example.ecommerce.pojo.processTransaction.payment;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class taxes {

    @SerializedName("kind")
    @Expose
    String kind;
    @SerializedName("amount")
    @Expose
    Double amount;
    @SerializedName("base")
    @Expose
    int base;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }
}
