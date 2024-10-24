package com.jasper.billingsystem.model;

import com.google.gson.annotations.SerializedName;

public class Complaint {

    @SerializedName("complaint_id")
    private int complaintId;

    @SerializedName("subscriber_id")
    private int subscriberId;

    @SerializedName("employee_id")
    private int employeeId;

    @SerializedName("cp_message")
    private String cpMessage;

    @SerializedName("cp_date")
    private String cpDate;

    @SerializedName("cp_reply")
    private String cpReply;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("employee")
    private Employee employee;

    public Complaint() {
    }

    public int getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public int getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(int subscriberId) {
        this.subscriberId = subscriberId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getCpMessage() {
        return cpMessage;
    }

    public void setCpMessage(String cpMessage) {
        this.cpMessage = cpMessage;
    }

    public String getCpDate() {
        return cpDate;
    }

    public void setCpDate(String cpDate) {
        this.cpDate = cpDate;
    }

    public String getCpReply() {
        return cpReply;
    }

    public void setCpReply(String cpReply) {
        this.cpReply = cpReply;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
