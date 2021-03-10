package com.example.ecommerce.pojo.informationRequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class instrument {

    @SerializedName("card")
    @Expose
    ArrayList<card> card;

}
