package com.example.ecommerce.pojo.processTransaction.payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class details {

    @SerializedName("kind")
    @Expose
    String kind;
    @SerializedName("amount")
    @Expose
    int amount;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
