package com.example.ecommerce.pojo.processTransaction.payment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class payment {

    @SerializedName("reference")
    @Expose
    String reference;
    @SerializedName("description")
    @Expose
    String description;
    @SerializedName("amount")
    @Expose
    amount amount;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public amount getAmount() {
        return amount;
    }

    public void setAmount(amount amount) {
        this.amount = amount;
    }
}
