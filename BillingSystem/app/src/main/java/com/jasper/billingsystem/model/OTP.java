package com.jasper.billingsystem.model;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class OTP implements Parcelable {

    private String otp;

    private int subscriberId;

    public OTP() {
    }


    protected OTP(Parcel in) {
        otp = in.readString();
        subscriberId = in.readInt();
    }

    public static final Creator<OTP> CREATOR = new Creator<OTP>() {
        @Override
        public OTP createFromParcel(Parcel in) {
            return new OTP(in);
        }

        @Override
        public OTP[] newArray(int size) {
            return new OTP[size];
        }
    };

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public int getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(int subscriberId) {
        this.subscriberId = subscriberId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(otp);
        parcel.writeInt(subscriberId);
    }
}
