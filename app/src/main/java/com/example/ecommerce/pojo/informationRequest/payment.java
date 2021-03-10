package com.example.ecommerce.pojo.informationRequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class payment {

    @SerializedName("reference")
    @Expose
    String reference;

    @SerializedName("amount")
    @Expose
    ArrayList<amount> amount;

}
