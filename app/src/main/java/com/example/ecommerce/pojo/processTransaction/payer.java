package com.example.ecommerce.pojo.processTransaction;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class payer {

    @SerializedName("document")
    @Expose
    String document;
    @SerializedName("documentType")
    @Expose
    String documentType;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("surname")
    @Expose
    String surname;
    @SerializedName("email")
    @Expose
    String email;
    @SerializedName("mobile")
    @Expose
    String mobile;

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
