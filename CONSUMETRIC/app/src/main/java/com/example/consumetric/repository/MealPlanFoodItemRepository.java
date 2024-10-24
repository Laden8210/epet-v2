package com.example.consumetric.repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.consumetric.model.MealPlanFoodItem;
import com.example.consumetric.response.RepositoryResponse;
import com.example.consumetric.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class MealPlanFoodItemRepository implements Repository<MealPlanFoodItem> {

    private DatabaseHelper databaseHelper;
    private Context context;
    private static MealPlanFoodItemRepository instance;
    private  MealPlanFoodItemRepository(Context context) {
        this.context = context;
        this.databaseHelper = DatabaseHelper.getInstance(context);
    }

    public static MealPlanFoodItemRepository getInstance(Context context) {
        if (instance == null) {
            instance = new MealPlanFoodItemRepository(context);
        }
        return instance;
    }

    @Override
    public void selectAll(RepositoryResponse<MealPlanFoodItem> repositoryResponse) {
        List<MealPlanFoodItem> mealPlanFoodItems = new ArrayList<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.query(MealPlanFoodItem.TABLE_NAME, null, null, null, null, null, null);

        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    MealPlanFoodItem mealPlanFoodItem = new MealPlanFoodItem();

                    // Safely get column indices
                    int idIndex = cursor.getColumnIndex(MealPlanFoodItem.COLUMN_ID);
                    int mealPlanIdIndex = cursor.getColumnIndex(MealPlanFoodItem.COLUMN_MEAL_PLAN_ID);
                    int foodItemIdIndex = cursor.getColumnIndex(MealPlanFoodItem.COLUMN_FOOD_ITEM_ID);

                    // Check if indices are valid
                    if (idIndex != -1 && mealPlanIdIndex != -1 && foodItemIdIndex != -1) {
                        mealPlanFoodItem.setId(cursor.getInt(idIndex));
                        mealPlanFoodItem.setMealPlanId(cursor.getInt(mealPlanIdIndex));
                        mealPlanFoodItem.setFoodItemId(cursor.getInt(foodItemIdIndex));
                        mealPlanFoodItems.add(mealPlanFoodItem);
                    } else {
                        // Handle case where one or more columns are not found
                        repositoryResponse.onFailure("One or more columns not found.");
                        return; // Exit if columns are not valid
                    }
                } while (cursor.moveToNext());
            }
            repositoryResponse.onSuccessList(mealPlanFoodItems);
        } catch (SQLiteException e) {
            repositoryResponse.onFailure(e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override
    public void selectById(int id, RepositoryResponse<MealPlanFoodItem> repositoryResponse) {
        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        Cursor cursor = database.query(MealPlanFoodItem.TABLE_NAME, null,
                MealPlanFoodItem.COLUMN_ID + " = ?", new String[]{String.valueOf(id)},
                null, null, null);

        try {
            if (cursor != null && cursor.moveToFirst()) {
                MealPlanFoodItem item = new MealPlanFoodItem();

                // Safely get column indices
                int idIndex = cursor.getColumnIndex(MealPlanFoodItem.COLUMN_ID);
                int mealPlanIdIndex = cursor.getColumnIndex(MealPlanFoodItem.COLUMN_MEAL_PLAN_ID);
                int foodItemIdIndex = cursor.getColumnIndex(MealPlanFoodItem.COLUMN_FOOD_ITEM_ID);

                // Check if indices are valid
                if (idIndex != -1 && mealPlanIdIndex != -1 && foodItemIdIndex != -1) {
                    item.setId(cursor.getInt(idIndex));
                    item.setMealPlanId(cursor.getInt(mealPlanIdIndex));
                    item.setFoodItemId(cursor.getInt(foodItemIdIndex));

                    repositoryResponse.onSuccess(item);
                } else {
                    // Handle case where one or more columns are not found
                    repositoryResponse.onFailure("One or more columns not found.");
                }
            } else {
                repositoryResponse.onFailure("Item not found");
            }
        } catch (SQLiteException e) {
            repositoryResponse.onFailure(e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override
    public void search(String keyword, RepositoryResponse<MealPlanFoodItem> repositoryResponse) {
        List<MealPlanFoodItem> mealPlanFoodItems = new ArrayList<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.query(MealPlanFoodItem.TABLE_NAME, null,
                MealPlanFoodItem.COLUMN_FOOD_ITEM_ID + " LIKE ?",
                new String[]{"%" + keyword + "%"}, null, null, null);

        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    MealPlanFoodItem mealPlanFoodItem = new MealPlanFoodItem();

                    // Safely get column indices
                    int idIndex = cursor.getColumnIndex(MealPlanFoodItem.COLUMN_ID);
                    int mealPlanIdIndex = cursor.getColumnIndex(MealPlanFoodItem.COLUMN_MEAL_PLAN_ID);
                    int foodItemIdIndex = cursor.getColumnIndex(MealPlanFoodItem.COLUMN_FOOD_ITEM_ID);

                    // Check if indices are valid
                    if (idIndex != -1 && mealPlanIdIndex != -1 && foodItemIdIndex != -1) {
                        mealPlanFoodItem.setId(cursor.getInt(idIndex));
                        mealPlanFoodItem.setMealPlanId(cursor.getInt(mealPlanIdIndex));
                        mealPlanFoodItem.setFoodItemId(cursor.getInt(foodItemIdIndex));
                        mealPlanFoodItems.add(mealPlanFoodItem);
                    } else {
                        // Handle the case where one of the columns is not found
                        repositoryResponse.onFailure("One or more columns not found.");
                        return; // Exit if columns are not valid
                    }
                } while (cursor.moveToNext());
            }

            repositoryResponse.onSuccessList(mealPlanFoodItems);
        } catch (SQLiteException e) {
            repositoryResponse.onFailure(e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }


    @Override
    public void insert(MealPlanFoodItem mealPlanFoodItem, RepositoryResponse<MealPlanFoodItem> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        try {
            long id = db.insert(MealPlanFoodItem.TABLE_NAME, null, mealPlanFoodItem.toContentValues());
            if (id != -1) {
                mealPlanFoodItem.setId((int) id);
                repositoryResponse.onSuccess(mealPlanFoodItem);
            } else {
                repositoryResponse.onFailure("Failed to insert Meal Plan Food Item");
            }
        } catch (SQLiteException e) {
            repositoryResponse.onFailure(e.getMessage());
        }
    }

    @Override
    public void update(MealPlanFoodItem mealPlanFoodItem, RepositoryResponse<MealPlanFoodItem> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        try {
            int rowsAffected = db.update(MealPlanFoodItem.TABLE_NAME, mealPlanFoodItem.toContentValues(),
                    MealPlanFoodItem.COLUMN_ID + "=?", new String[]{String.valueOf(mealPlanFoodItem.getId())});

            if (rowsAffected > 0) {
                repositoryResponse.onSuccess(mealPlanFoodItem);
            } else {
                repositoryResponse.onFailure("Failed to update Meal Plan Food Item");
            }
        } catch (SQLiteException e) {
            repositoryResponse.onFailure(e.getMessage());
        }
    }

    @Override
    public void delete(MealPlanFoodItem mealPlanFoodItem, RepositoryResponse<MealPlanFoodItem> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        try {
            int rowsAffected = db.delete(MealPlanFoodItem.TABLE_NAME,
                    MealPlanFoodItem.COLUMN_ID + "=?", new String[]{String.valueOf(mealPlanFoodItem.getId())});

            if (rowsAffected > 0) {
                repositoryResponse.onSuccess(mealPlanFoodItem);
            } else {
                repositoryResponse.onFailure("Failed to delete Meal Plan Food Item");
            }
        } catch (SQLiteException e) {
            repositoryResponse.onFailure(e.getMessage());
        }
    }

    @Override
    public void deleteAll(RepositoryResponse<MealPlanFoodItem> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        try {
            db.delete(MealPlanFoodItem.TABLE_NAME, null, null);
            repositoryResponse.onSuccess(null); // or indicate success with a message
        } catch (SQLiteException e) {
            repositoryResponse.onFailure(e.getMessage());
        }
    }
}
