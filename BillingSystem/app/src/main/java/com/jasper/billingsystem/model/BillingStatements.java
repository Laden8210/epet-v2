package com.jasper.billingsystem.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BillingStatements {

    @SerializedName("billing_id")
    private String billing_id;
    @SerializedName("billing_date")
    private String billing_date;
    @SerializedName("bs_status")
    private String bs_status;
    @SerializedName("amount")
    private String amount;
    @SerializedName("bs_duedate")
    private String bs_duedate;

    @SerializedName("payments")
    private List<Payments> payments;

    public BillingStatements() {
    }

    public String getBilling_id() {
        return billing_id;
    }

    public void setBilling_id(String billing_id) {
        this.billing_id = billing_id;
    }

    public String getBilling_date() {
        return billing_date;
    }

    public void setBilling_date(String billing_date) {
        this.billing_date = billing_date;
    }

    public String getBs_status() {
        return bs_status;
    }

    public void setBs_status(String bs_status) {
        this.bs_status = bs_status;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBs_duedate() {
        return bs_duedate;
    }

    public void setBs_duedate(String bs_duedate) {
        this.bs_duedate = bs_duedate;
    }

    public List<Payments> getPayments() {
        return payments;
    }

    public void setPayments(List<Payments> payments) {
        this.payments = payments;
    }
}
