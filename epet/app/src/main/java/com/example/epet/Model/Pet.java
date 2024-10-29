package com.example.epet.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Pet implements Parcelable {

    @SerializedName("pet_id")
    private int petId; // Updated key

    @SerializedName("owner_id")
    private int ownerId; // Updated key

    @SerializedName("name")
    private String petName; // Updated key

    @SerializedName("petage")
    private int petAge; // Updated key

    @SerializedName("age_type")
    private String ageType; // Updated key

    @SerializedName("gender")
    private String gender;

    @SerializedName("breed")
    private String breed;

    @SerializedName("desc_breed")
    private String breedDescription; // Updated key

    @SerializedName("color")
    private String color; // Updated key

    @SerializedName("type")
    private String type; // New key

    @SerializedName("status_pet")
    private String status; // Updated key

    @SerializedName("image_id")
    private String imageId; // Updated key

    @SerializedName("Image")
    private String image; // Updated key

    // Constructor
    public Pet(int petId, int ownerId, String petName, int petAge, String ageType,
               String gender, String breed, String breedDescription, String color,
               String type, String status, String imageId, String image) {
        this.petId = petId;
        this.ownerId = ownerId;
        this.petName = petName;
        this.petAge = petAge;
        this.ageType = ageType;
        this.gender = gender;
        this.breed = breed;
        this.breedDescription = breedDescription;
        this.color = color;
        this.type = type;
        this.status = status;
        this.imageId = imageId;
        this.image = image;
    }

    protected Pet(Parcel in) {
        petId = in.readInt();
        ownerId = in.readInt();
        petName = in.readString();
        petAge = in.readInt();
        ageType = in.readString();
        gender = in.readString();
        breed = in.readString();
        breedDescription = in.readString();
        color = in.readString();
        type = in.readString();
        status = in.readString();
        imageId = in.readString();
        image = in.readString();
    }

    public static final Creator<Pet> CREATOR = new Creator<Pet>() {
        @Override
        public Pet createFromParcel(Parcel in) {
            return new Pet(in);
        }

        @Override
        public Pet[] newArray(int size) {
            return new Pet[size];
        }
    };

    // Getters and Setters
    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    public String getAgeType() {
        return ageType;
    }

    public void setAgeType(String ageType) {
        this.ageType = ageType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreedDescription() {
        return breedDescription;
    }

    public void setBreedDescription(String breedDescription) {
        this.breedDescription = breedDescription;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(petId);
        dest.writeInt(ownerId);
        dest.writeString(petName);
        dest.writeInt(petAge);
        dest.writeString(ageType);
        dest.writeString(gender);
        dest.writeString(breed);
        dest.writeString(breedDescription);
        dest.writeString(color);
        dest.writeString(type);
        dest.writeString(status);
        dest.writeString(imageId);
        dest.writeString(image);
    }
}
