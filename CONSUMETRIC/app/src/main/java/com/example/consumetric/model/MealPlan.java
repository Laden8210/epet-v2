package com.example.consumetric.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public class MealPlan implements Serializable {

    public static final String TABLE_NAME = "meal_plans";
    public static final String COLUMN_ID = "mealPlanId";
    public static final String COLUMN_DAY = "day";
    public static final String COLUMN_TIME = "time";
    public static final String COLUMN_MEAL_TYPE = "mealType";
    public static final String COLUMN_TOTAL_KCAL = "totalKcal";
    public static final String COLUMN_IS_DELETED = "isDeleted";
    public static final String COLUMN_IS_COMPLETED = "isCompleted";

    private int mealPlanId;
    private String day;
    private String mealType;
    private double totalKcal;
    private boolean isDeleted;
    private boolean isCompleted;

    private List<MealPlanFoodItem> mealPlanFoodItems;

    private List<FoodItem> foodItems;


    public MealPlan() {
    }


    public MealPlan(List<FoodItem> foodItems, boolean isCompleted, boolean isDeleted, double totalKcal, String mealType, String day) {
        this.foodItems = foodItems;

        this.isCompleted = isCompleted;
        this.isDeleted = isDeleted;
        this.totalKcal = totalKcal;
        this.mealType = mealType;
        this.day = day;
    }

    public int getMealPlanId() {
        return mealPlanId;
    }

    public void setMealPlanId(int mealPlanId) {
        this.mealPlanId = mealPlanId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }


    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public double getTotalKcal() {
        return totalKcal;
    }

    public void setTotalKcal(double totalKcal) {
        this.totalKcal = totalKcal;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public List<MealPlanFoodItem> getMealPlanFoodItems() {
        return mealPlanFoodItems;
    }

    public void setMealPlanFoodItems(List<MealPlanFoodItem> mealPlanFoodItems) {
        this.mealPlanFoodItems = mealPlanFoodItems;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}
