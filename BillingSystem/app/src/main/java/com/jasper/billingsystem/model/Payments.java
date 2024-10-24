package com.jasper.billingsystem.model;

import com.google.gson.annotations.SerializedName;

public class Payments {

    @SerializedName("payment_id")
    private String payment_id;
    @SerializedName("p_amount")
    private String p_amount;
    @SerializedName("p_month")
    private String p_month;
    @SerializedName("p_date")
    private String p_date;

    public Payments() {
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getP_amount() {
        return p_amount;
    }

    public void setP_amount(String p_amount) {
        this.p_amount = p_amount;
    }

    public String getP_month() {
        return p_month;
    }

    public void setP_month(String p_month) {
        this.p_month = p_month;
    }

    public String getP_date() {
        return p_date;
    }

    public void setP_date(String p_date) {
        this.p_date = p_date;
    }
}
