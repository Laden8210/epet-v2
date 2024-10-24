package com.jasper.billingsystem.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Employee implements Parcelable {

    @SerializedName("employee_id")
    private int employeeId;

    @SerializedName("em_fname")
    private String firstName;

    @SerializedName("em_lname")
    private String lastName;

    @SerializedName("em_minitial")
    private String middleInitial;

    @SerializedName("em_suffix")
    private String suffix;

    @SerializedName("em_contactnum")
    private String contactNumber;

    @SerializedName("em_role")
    private String role;

    @SerializedName("em_status")
    private String status;

    public Employee() {
    }

    protected Employee(Parcel in) {
        employeeId = in.readInt();
        firstName = in.readString();
        lastName = in.readString();
        middleInitial = in.readString();
        suffix = in.readString();
        contactNumber = in.readString();
        role = in.readString();
        status = in.readString();
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(employeeId);
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(middleInitial);
        parcel.writeString(suffix);
        parcel.writeString(contactNumber);
        parcel.writeString(role);
        parcel.writeString(status);
    }
}
