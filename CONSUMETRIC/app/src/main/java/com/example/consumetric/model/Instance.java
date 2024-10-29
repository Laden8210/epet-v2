package com.example.consumetric.model;

public class Instance {

    public static final String CREATE_TABLE_MEAL_PLAN = "CREATE TABLE " + MealPlan.TABLE_NAME + "("
            + MealPlan.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MealPlan.COLUMN_DAY + " TEXT,"
            + MealPlan.COLUMN_MEAL_TYPE + " TEXT,"
            + MealPlan.COLUMN_TOTAL_KCAL + " REAL,"
            + MealPlan.COLUMN_IS_DELETED + " INTEGER,"
            + MealPlan.COLUMN_IS_COMPLETED + " INTEGER"
            + ")";


    public static final String CREATE_TABLE_FOOD_ITEM = "CREATE TABLE " + FoodItem.TABLE_NAME + "("
            + FoodItem.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FoodItem.COLUMN_NAME + " TEXT,"
            + FoodItem.COLUMN_PORTION_SIZE + " TEXT,"
            + FoodItem.COLUMN_KCAL + " REAL, "
            + FoodItem.COLUMN_DESCRIPTION + " TEXT"
            + ")";

    public static final String CREATE_TABLE_MEAL_PLAN_FOOD_ITEM = "CREATE TABLE " + MealPlanFoodItem.TABLE_NAME + "("
            + MealPlanFoodItem.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + MealPlanFoodItem.COLUMN_MEAL_PLAN_ID + " INTEGER,"
            + MealPlanFoodItem.COLUMN_FOOD_ITEM_ID + " INTEGER,"
            + "FOREIGN KEY(" + MealPlanFoodItem.COLUMN_MEAL_PLAN_ID + ") REFERENCES " + MealPlan.TABLE_NAME + "(" + MealPlan.COLUMN_ID + "),"
            + "FOREIGN KEY(" + MealPlanFoodItem.COLUMN_FOOD_ITEM_ID + ") REFERENCES " + FoodItem.TABLE_NAME + "(" + FoodItem.COLUMN_ID + ")"
            + ")";


    public static final String CREATE_TABLE_USER = "CREATE TABLE " + User.TABLE_NAME + "("
            + User.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + User.COLUMN_FIRST_NAME + " TEXT,"
            + User.COLUMN_LAST_NAME + " TEXT,"
            + User.COLUMN_BIRTH_DATE + " TEXT,"
            + User.COLUMN_HEIGHT + " REAL,"
            + User.COLUMN_WEIGHT + " REAL,"
            + User.COLUMN_GENDER + " TEXT,"
            + User.COLUMN_CALORIES + " REAL"
            + ")";


    public static final String DROP_TABLE_MEAL_PLAN = "DROP TABLE IF EXISTS " + MealPlan.TABLE_NAME;
    public static final String DROP_TABLE_FOOD_ITEM = "DROP TABLE IF EXISTS " + FoodItem.TABLE_NAME;
    public static final String DROP_TABLE_MEAL_PLAN_FOOD_ITEM = "DROP TABLE IF EXISTS " + MealPlanFoodItem.TABLE_NAME;
    public static final String DROP_TABLE_USER = "DROP TABLE IF EXISTS " + User.TABLE_NAME;

}
