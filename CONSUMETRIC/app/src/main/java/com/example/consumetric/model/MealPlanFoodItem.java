package com.example.consumetric.model;

import android.content.ContentValues;

public class MealPlanFoodItem {

    public static final String TABLE_NAME = "meal_plan_food_items";
    public static final String COLUMN_ID = "mealPlanFoodId";
    public static final String COLUMN_MEAL_PLAN_ID = "mealPlanId";
    public static final String COLUMN_FOOD_ITEM_ID = "foodItemId";


    private int mealPlanFoodId;
    private int mealPlanId;
    private int foodItemId;


    public MealPlanFoodItem() {
    }

    public int getId() {
        return mealPlanFoodId;
    }

    public void setId(int id) {
        this.mealPlanFoodId = id;
    }

    public int getMealPlanId() {
        return mealPlanId;
    }

    public void setMealPlanId(int mealPlanId) {
        this.mealPlanId = mealPlanId;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(COLUMN_MEAL_PLAN_ID, mealPlanId);
        values.put(COLUMN_FOOD_ITEM_ID, foodItemId);
        return values;
    }

}
