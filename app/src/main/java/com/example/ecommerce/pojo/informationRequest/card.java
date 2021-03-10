package com.example.ecommerce.pojo.informationRequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class card {

    @SerializedName("number")
    @Expose
    String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
