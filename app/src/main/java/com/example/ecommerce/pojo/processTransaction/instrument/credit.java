package com.example.ecommerce.pojo.processTransaction.instrument;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class credit {

    @SerializedName("code")
    @Expose
    String code;
    @SerializedName("type")
    @Expose
    String type;
    @SerializedName("groupCode")
    @Expose
    String groupCode;
    @SerializedName("installment")
    @Expose
    String installment;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getInstallment() {
        return installment;
    }

    public void setInstallment(String installment) {
        this.installment = installment;
    }
}
