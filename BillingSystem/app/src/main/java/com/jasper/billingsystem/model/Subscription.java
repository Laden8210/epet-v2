package com.jasper.billingsystem.model;

import com.google.gson.annotations.SerializedName;

public class Subscription {

    @SerializedName("subscription_id")
    private String subscriptionId;

    @SerializedName("subscriber_id")
    private String subscriberId;

    @SerializedName("subscriptionarea_id")
    private String subscriptionAreaId;

    @SerializedName("subscriptionplan_id")
    private String subscriptionPlanId;

    @SerializedName("sn_num")
    private String serialNumber;

    @SerializedName("sn_startdate")
    private String startDate;

    @SerializedName("sn_status")
    private String status;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("snarea_name")
    private String areaName;

    @SerializedName("snplan_bandwidth")
    private String planBandwidth;

    @SerializedName("snplan_fee")
    private String planFee;

    public Subscription() {
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getSubscriptionAreaId() {
        return subscriptionAreaId;
    }

    public void setSubscriptionAreaId(String subscriptionAreaId) {
        this.subscriptionAreaId = subscriptionAreaId;
    }

    public String getSubscriptionPlanId() {
        return subscriptionPlanId;
    }

    public void setSubscriptionPlanId(String subscriptionPlanId) {
        this.subscriptionPlanId = subscriptionPlanId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getPlanBandwidth() {
        return planBandwidth;
    }

    public void setPlanBandwidth(String planBandwidth) {
        this.planBandwidth = planBandwidth;
    }

    public String getPlanFee() {
        return planFee;
    }

    public void setPlanFee(String planFee) {
        this.planFee = planFee;
    }
}
