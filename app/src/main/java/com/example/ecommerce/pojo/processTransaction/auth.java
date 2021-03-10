package com.example.ecommerce.pojo.processTransaction;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class auth {

    @SerializedName("login")
    @Expose
    String login;

    @SerializedName("tranKey")
    @Expose
    String tranKey;

    @SerializedName("nonce")
    @Expose
    String nonce;

    @SerializedName("seed")
    @Expose
    String seed;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTranKey() {
        return tranKey;
    }

    public void setTranKey(String tranKey) {
        this.tranKey = tranKey;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }
}
