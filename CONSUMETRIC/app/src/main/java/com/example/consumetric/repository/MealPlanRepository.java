package com.example.consumetric.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.consumetric.database.DatabaseHelper;
import com.example.consumetric.model.FoodItem;
import com.example.consumetric.model.MealPlan;
import com.example.consumetric.model.MealPlanFoodItem;
import com.example.consumetric.response.RepositoryResponse;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MealPlanRepository implements Repository<MealPlan> {

    private static MealPlanRepository mealPlanRepository;
    private Context context;
    private DatabaseHelper databaseHelper;

    private MealPlanRepository(Context context) {
        this.context = context;
        databaseHelper = DatabaseHelper.getInstance(context);
    }

    public static synchronized MealPlanRepository getInstance(Context context) {
        if (mealPlanRepository == null) {
            mealPlanRepository = new MealPlanRepository(context);
        }
        return mealPlanRepository;
    }

    @Override
    public void selectAll(RepositoryResponse<MealPlan> repositoryResponse) {
        List<MealPlan> mealPlans = new ArrayList<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.query(MealPlan.TABLE_NAME, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                MealPlan mealPlan = new MealPlan();

                int idIndex = cursor.getColumnIndex(MealPlan.COLUMN_ID);
                int dayIndex = cursor.getColumnIndex(MealPlan.COLUMN_DAY);

                int mealTypeIndex = cursor.getColumnIndex(MealPlan.COLUMN_MEAL_TYPE);
                int totalKcalIndex = cursor.getColumnIndex(MealPlan.COLUMN_TOTAL_KCAL);
                int isDeletedIndex = cursor.getColumnIndex(MealPlan.COLUMN_IS_DELETED);
                int isCompletedIndex = cursor.getColumnIndex(MealPlan.COLUMN_IS_COMPLETED);

                if (idIndex != -1) mealPlan.setMealPlanId(cursor.getInt(idIndex));
                if (dayIndex != -1) mealPlan.setDay(cursor.getString(dayIndex));
                if (mealTypeIndex != -1) mealPlan.setMealType(cursor.getString(mealTypeIndex));
                if (totalKcalIndex != -1) mealPlan.setTotalKcal(cursor.getDouble(totalKcalIndex));
                if (isDeletedIndex != -1) mealPlan.setDeleted(cursor.getInt(isDeletedIndex) > 0);
                if (isCompletedIndex != -1) mealPlan.setCompleted(cursor.getInt(isCompletedIndex) > 0);

                mealPlans.add(mealPlan);
            } while (cursor.moveToNext());
        }
        cursor.close();
        repositoryResponse.onSuccessList(mealPlans);
    }

    @Override
    public void selectById(int id, RepositoryResponse<MealPlan> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.query(MealPlan.TABLE_NAME, null, MealPlan.COLUMN_ID + "=?", new String[]{String.valueOf(id)}, null, null, null);

        if (cursor.moveToFirst()) {
            MealPlan mealPlan = new MealPlan();

            int idIndex = cursor.getColumnIndex(MealPlan.COLUMN_ID);
            int dayIndex = cursor.getColumnIndex(MealPlan.COLUMN_DAY);
            int timeIndex = cursor.getColumnIndex(MealPlan.COLUMN_TIME);
            int mealTypeIndex = cursor.getColumnIndex(MealPlan.COLUMN_MEAL_TYPE);
            int totalKcalIndex = cursor.getColumnIndex(MealPlan.COLUMN_TOTAL_KCAL);
            int isDeletedIndex = cursor.getColumnIndex(MealPlan.COLUMN_IS_DELETED);
            int isCompletedIndex = cursor.getColumnIndex(MealPlan.COLUMN_IS_COMPLETED);

            if (idIndex != -1) mealPlan.setMealPlanId(cursor.getInt(idIndex));
            if (dayIndex != -1) mealPlan.setDay(cursor.getString(dayIndex));
            if (mealTypeIndex != -1) mealPlan.setMealType(cursor.getString(mealTypeIndex));
            if (totalKcalIndex != -1) mealPlan.setTotalKcal(cursor.getDouble(totalKcalIndex));
            if (isDeletedIndex != -1) mealPlan.setDeleted(cursor.getInt(isDeletedIndex) > 0);
            if (isCompletedIndex != -1) mealPlan.setCompleted(cursor.getInt(isCompletedIndex) > 0);

            repositoryResponse.onSuccess(mealPlan);
        } else {
            repositoryResponse.onFailure("Meal Plan not found");
        }
        cursor.close();
    }


    @Override
    public void search(String keyword, RepositoryResponse<MealPlan> repositoryResponse) {
        List<MealPlan> mealPlans = new ArrayList<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.query(MealPlan.TABLE_NAME, null, MealPlan.COLUMN_MEAL_TYPE + " LIKE ?", new String[]{"%" + keyword + "%"}, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                MealPlan mealPlan = new MealPlan();

                int idIndex = cursor.getColumnIndex(MealPlan.COLUMN_ID);
                int dayIndex = cursor.getColumnIndex(MealPlan.COLUMN_DAY);
                int timeIndex = cursor.getColumnIndex(MealPlan.COLUMN_TIME);
                int mealTypeIndex = cursor.getColumnIndex(MealPlan.COLUMN_MEAL_TYPE);
                int totalKcalIndex = cursor.getColumnIndex(MealPlan.COLUMN_TOTAL_KCAL);
                int isDeletedIndex = cursor.getColumnIndex(MealPlan.COLUMN_IS_DELETED);
                int isCompletedIndex = cursor.getColumnIndex(MealPlan.COLUMN_IS_COMPLETED);

                if (idIndex != -1) mealPlan.setMealPlanId(cursor.getInt(idIndex));
                if (dayIndex != -1) mealPlan.setDay(cursor.getString(dayIndex));

                if (mealTypeIndex != -1) mealPlan.setMealType(cursor.getString(mealTypeIndex));
                if (totalKcalIndex != -1) mealPlan.setTotalKcal(cursor.getDouble(totalKcalIndex));
                if (isDeletedIndex != -1) mealPlan.setDeleted(cursor.getInt(isDeletedIndex) > 0);
                if (isCompletedIndex != -1) mealPlan.setCompleted(cursor.getInt(isCompletedIndex) > 0);

                mealPlans.add(mealPlan);
            } while (cursor.moveToNext());
        }
        cursor.close();
        repositoryResponse.onSuccessList(mealPlans);
    }

    @Override
    public void insert(MealPlan mealPlan, RepositoryResponse<MealPlan> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MealPlan.COLUMN_DAY, mealPlan.getDay());

        values.put(MealPlan.COLUMN_MEAL_TYPE, mealPlan.getMealType());
        values.put(MealPlan.COLUMN_TOTAL_KCAL, mealPlan.getTotalKcal());
        values.put(MealPlan.COLUMN_IS_DELETED, mealPlan.isDeleted() ? 1 : 0);
        values.put(MealPlan.COLUMN_IS_COMPLETED, mealPlan.isCompleted() ? 1 : 0);

        long id = db.insert(MealPlan.TABLE_NAME, null, values);
        if (id != -1) {
            mealPlan.setMealPlanId((int) id);
            repositoryResponse.onSuccess(mealPlan);
        } else {
            repositoryResponse.onFailure("Insert failed");
        }
    }

    @Override
    public void update(MealPlan mealPlan, RepositoryResponse<MealPlan> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MealPlan.COLUMN_DAY, mealPlan.getDay());
        values.put(MealPlan.COLUMN_MEAL_TYPE, mealPlan.getMealType());
        values.put(MealPlan.COLUMN_TOTAL_KCAL, mealPlan.getTotalKcal());
        values.put(MealPlan.COLUMN_IS_DELETED, mealPlan.isDeleted() ? 1 : 0);
        values.put(MealPlan.COLUMN_IS_COMPLETED, mealPlan.isCompleted() ? 1 : 0);

        int rowsAffected = db.update(MealPlan.TABLE_NAME, values, MealPlan.COLUMN_ID + "=?", new String[]{String.valueOf(mealPlan.getMealPlanId())});
        if (rowsAffected > 0) {
            repositoryResponse.onSuccess(mealPlan);
        } else {
            repositoryResponse.onFailure("Update failed");
        }
    }

    @Override
    public void delete(MealPlan mealPlan, RepositoryResponse<MealPlan> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        int rowsAffected = db.delete(MealPlan.TABLE_NAME, MealPlan.COLUMN_ID + "=?", new String[]{String.valueOf(mealPlan.getMealPlanId())});
        if (rowsAffected > 0) {
            repositoryResponse.onSuccess(mealPlan);
        } else {
            repositoryResponse.onFailure("Delete failed");
        }
    }

    @Override
    public void deleteAll(RepositoryResponse<MealPlan> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        int rowsDeleted = db.delete(MealPlan.TABLE_NAME, null, null);
        if (rowsDeleted > 0) {
            repositoryResponse.onSuccess(null);
        } else {
            repositoryResponse.onFailure("Delete all failed");
        }
    }

    public void getMealPlanByDateAndMealType(String date, String mealType, RepositoryResponse<MealPlan> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();


        // SQL query with JOIN to get meal plan and associated food items
        String query = "SELECT mp.*, fi.* FROM " + MealPlan.TABLE_NAME + " AS mp " +
                "LEFT JOIN " + MealPlanFoodItem.TABLE_NAME + " AS mpfi ON mp." + MealPlan.COLUMN_ID + " = mpfi." + MealPlanFoodItem.COLUMN_MEAL_PLAN_ID + " " +
                "LEFT JOIN " + FoodItem.TABLE_NAME + " AS fi ON mpfi." + MealPlanFoodItem.COLUMN_FOOD_ITEM_ID + " = fi." + FoodItem.COLUMN_ID + " " +
                "WHERE mp." + MealPlan.COLUMN_DAY + "=? AND mp." + MealPlan.COLUMN_MEAL_TYPE + "=?";


        Log.d("MealPlanRepository", "getMealPlanByDateAndMealType: " + query);

        Log.d("MealPlanRepository", "getMealPlanByDateAndMealType: date=" + date + ", mealType=" + mealType);
        Cursor cursor = db.rawQuery(query, new String[]{date, mealType});

        if (cursor != null && cursor.moveToFirst()) {
            MealPlan mealPlan = new MealPlan();

            // Get column indices for MealPlan
            int idIndex = cursor.getColumnIndex(MealPlan.COLUMN_ID);
            int dayIndex = cursor.getColumnIndex(MealPlan.COLUMN_DAY);
            int mealTypeIndex = cursor.getColumnIndex(MealPlan.COLUMN_MEAL_TYPE);
            int totalKcalIndex = cursor.getColumnIndex(MealPlan.COLUMN_TOTAL_KCAL);
            int isDeletedIndex = cursor.getColumnIndex(MealPlan.COLUMN_IS_DELETED);
            int isCompletedIndex = cursor.getColumnIndex(MealPlan.COLUMN_IS_COMPLETED);

            // Set MealPlan fields
            if (idIndex != -1) {
                mealPlan.setMealPlanId(cursor.getInt(idIndex));
            }

            if (dayIndex != -1) {
                mealPlan.setDay(cursor.getString(dayIndex));
            }

            if (mealTypeIndex != -1) {
                mealPlan.setMealType(cursor.getString(mealTypeIndex));
            }

            if (totalKcalIndex != -1) {
                mealPlan.setTotalKcal(cursor.getDouble(totalKcalIndex));
            }

            if (isDeletedIndex != -1) {
                mealPlan.setDeleted(cursor.getInt(isDeletedIndex) > 0);
            }

            if (isCompletedIndex != -1) {
                mealPlan.setCompleted(cursor.getInt(isCompletedIndex) > 0);
            }

            // Initialize a list to hold food items
            List<FoodItem> foodItems = new ArrayList<>();

            // Loop through the cursor to get food items
            do {
                // Get column indices for FoodItem
                int foodIdIndex = cursor.getColumnIndex(FoodItem.COLUMN_ID);
                int foodNameIndex = cursor.getColumnIndex(FoodItem.COLUMN_NAME);
                int portionSizeIndex = cursor.getColumnIndex(FoodItem.COLUMN_PORTION_SIZE);
                int kcalIndex = cursor.getColumnIndex(FoodItem.COLUMN_KCAL);
                int mealTypeIndexFood = cursor.getColumnIndex(FoodItem.COLUMN_MEAL_TYPE);
                int descriptionIndex = cursor.getColumnIndex(FoodItem.COLUMN_DESCRIPTION);

                // Create a FoodItem object and set its fields
                FoodItem foodItem = new FoodItem();
                if (foodIdIndex != -1) {
                    foodItem.setFoodItemId(cursor.getInt(foodIdIndex));
                }
                if (foodNameIndex != -1) {
                    foodItem.setName(cursor.getString(foodNameIndex));
                }
                if (portionSizeIndex != -1) {
                    foodItem.setPortionSize(cursor.getString(portionSizeIndex));
                }
                if (kcalIndex != -1) {
                    foodItem.setKcal(cursor.getDouble(kcalIndex));
                }
                if (mealTypeIndexFood != -1) {
                    foodItem.setMealType(cursor.getString(mealTypeIndexFood));
                }
                if (descriptionIndex != -1) {
                    foodItem.setDescription(cursor.getString(descriptionIndex));
                }

                // Add food item to the list
                foodItems.add(foodItem);
            } while (cursor.moveToNext());

            // Set the list of food items in the MealPlan
            mealPlan.setFoodItems(foodItems);

            // Return the meal plan with food items
            repositoryResponse.onSuccess(mealPlan);
        } else {
            repositoryResponse.onFailure("Meal Plan not found");
        }

        if (cursor != null) {
            cursor.close();
        }
    }

}
