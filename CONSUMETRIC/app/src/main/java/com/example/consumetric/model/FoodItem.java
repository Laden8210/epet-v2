package com.example.consumetric.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class FoodItem implements Parcelable {



    public static final String TABLE_NAME = "food_items";
    public static final String COLUMN_ID = "foodItemId";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PORTION_SIZE = "portion_size";
    public static final String COLUMN_KCAL = "kcal";
    public static final String COLUMN_MEAL_TYPE = "mealType";
    public static final String COLUMN_DESCRIPTION = "description";


    private int foodItemId;
    private String name;
    private String portionSize;
    private double kcal;
    private String mealType;
    private String description;

    public FoodItem() {
    }

    public FoodItem(int foodItemId, String name, String portionSize, double kcal, String mealType, String description) {
        this.foodItemId = foodItemId;
        this.name = name;
        this.portionSize = portionSize;
        this.kcal = kcal;
        this.mealType = mealType;
        this.description = description;
    }

    public FoodItem(String name, String portionSize, double kcal, String mealType, String description) {
        this.name = name;
        this.portionSize = portionSize;
        this.kcal = kcal;
        this.mealType = mealType;
        this.description = description;
    }

    protected FoodItem(Parcel in) {
        foodItemId = in.readInt();
        name = in.readString();
        portionSize = in.readString();
        kcal = in.readDouble();
        mealType = in.readString();
        description = in.readString();
    }

    public static final Creator<FoodItem> CREATOR = new Creator<FoodItem>() {
        @Override
        public FoodItem createFromParcel(Parcel in) {
            return new FoodItem(in);
        }

        @Override
        public FoodItem[] newArray(int size) {
            return new FoodItem[size];
        }
    };

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortionSize() {
        return portionSize;
    }

    public void setPortionSize(String portionSize) {
        this.portionSize = portionSize;
    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(foodItemId);
        parcel.writeString(name);
        parcel.writeString(portionSize);
        parcel.writeDouble(kcal);
        parcel.writeString(mealType);
        parcel.writeString(description);
    }
}
