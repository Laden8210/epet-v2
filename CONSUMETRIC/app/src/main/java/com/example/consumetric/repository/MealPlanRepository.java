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
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


        FoodItemRepository foodItemRepository = FoodItemRepository.getInstance(context);
        for (FoodItem foodItem : mealPlan.getFoodItems()) {
            foodItemRepository.insert(foodItem, new RepositoryResponse<FoodItem>() {
                @Override
                public void onSuccess(FoodItem object) {


                    MealPlanFoodItemRepository mealPlanFoodItemRepository = MealPlanFoodItemRepository.getInstance(context);
                    MealPlanFoodItem mealPlanFoodItem = new MealPlanFoodItem();
                    mealPlanFoodItem.setMealPlanId((int) id);
                    mealPlanFoodItem.setFoodItemId(object.getFoodItemId());
                    mealPlanFoodItemRepository.insert(mealPlanFoodItem, new RepositoryResponse<MealPlanFoodItem>() {
                        @Override
                        public void onSuccess(MealPlanFoodItem object) {

                        }

                        @Override
                        public void onSuccessList(List<MealPlanFoodItem> objectList) {

                        }

                        @Override
                        public void onSuccessMessage(String message) {

                        }

                        @Override
                        public void onFailure(String message) {

                        }
                    });
                }

                @Override
                public void onSuccessList(List<FoodItem> objectList) {

                }

                @Override
                public void onSuccessMessage(String message) {

                }

                @Override
                public void onFailure(String message) {

                }
            });
        }


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

    public void getMealPlanByDateAndMealType(String day, RepositoryResponse<MealPlan> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String query = "SELECT mp.*, fi.* FROM " + MealPlan.TABLE_NAME + " AS mp " +
                "LEFT JOIN " + MealPlanFoodItem.TABLE_NAME + " AS mpfi ON mp." + MealPlan.COLUMN_ID + " = mpfi." + MealPlanFoodItem.COLUMN_MEAL_PLAN_ID + " " +
                "LEFT JOIN " + FoodItem.TABLE_NAME + " AS fi ON mpfi." + MealPlanFoodItem.COLUMN_FOOD_ITEM_ID + " = fi." + FoodItem.COLUMN_ID + " " +
                "WHERE mp." + MealPlan.COLUMN_DAY + "=?";

        Log.d("MealPlanRepository", "getMealPlanByDateAndMealType: " + query);
        Log.d("MealPlanRepository", "getMealPlanByDateAndMealType: date=" + day);

        Cursor cursor = db.rawQuery(query, new String[]{day});
        List<MealPlan> mealPlans = new ArrayList<>();

        if (cursor != null) {
            Map<Integer, MealPlan> mealPlanMap = new HashMap<>();

            while (cursor.moveToNext()) {
                // Get column indices for MealPlan
                int idIndex = cursor.getColumnIndex(MealPlan.COLUMN_ID);
                int dayIndex = cursor.getColumnIndex(MealPlan.COLUMN_DAY);
                int mealTypeIndex = cursor.getColumnIndex(MealPlan.COLUMN_MEAL_TYPE);
                int totalKcalIndex = cursor.getColumnIndex(MealPlan.COLUMN_TOTAL_KCAL);
                int isDeletedIndex = cursor.getColumnIndex(MealPlan.COLUMN_IS_DELETED);
                int isCompletedIndex = cursor.getColumnIndex(MealPlan.COLUMN_IS_COMPLETED);

                int mealPlanId = cursor.getInt(idIndex);
                MealPlan mealPlan = mealPlanMap.get(mealPlanId);
                if (mealPlan == null) {
                    mealPlan = new MealPlan();
                    mealPlan.setMealPlanId(mealPlanId);
                    mealPlan.setDay(cursor.getString(dayIndex));
                    mealPlan.setMealType(cursor.getString(mealTypeIndex));
                    mealPlan.setTotalKcal(cursor.getDouble(totalKcalIndex));
                    mealPlan.setDeleted(cursor.getInt(isDeletedIndex) > 0);
                    mealPlan.setCompleted(cursor.getInt(isCompletedIndex) > 0);
                    mealPlan.setFoodItems(new ArrayList<>());
                    mealPlanMap.put(mealPlanId, mealPlan);
                }

                // Extract FoodItem details
                int foodIdIndex = cursor.getColumnIndex(FoodItem.COLUMN_ID);
                int foodNameIndex = cursor.getColumnIndex(FoodItem.COLUMN_NAME);
                int portionSizeIndex = cursor.getColumnIndex(FoodItem.COLUMN_PORTION_SIZE);
                int kcalIndex = cursor.getColumnIndex(FoodItem.COLUMN_KCAL);
                int descriptionIndex = cursor.getColumnIndex(FoodItem.COLUMN_DESCRIPTION);

                FoodItem foodItem = new FoodItem();
                foodItem.setFoodItemId(cursor.getInt(foodIdIndex));
                foodItem.setName(cursor.getString(foodNameIndex));
                foodItem.setPortionSize(cursor.getString(portionSizeIndex));
                foodItem.setKcal(cursor.getDouble(kcalIndex));
                foodItem.setDescription(cursor.getString(descriptionIndex));

                mealPlan.getFoodItems().add(foodItem);
            }

            mealPlans.addAll(mealPlanMap.values());

            if (!mealPlans.isEmpty()) {
                repositoryResponse.onSuccessList(mealPlans);
            } else {
                repositoryResponse.onFailure("No Meal Plans found for the specified day");
            }

            cursor.close();
        } else {
            repositoryResponse.onFailure("Cursor is null");
        }
    }



}
