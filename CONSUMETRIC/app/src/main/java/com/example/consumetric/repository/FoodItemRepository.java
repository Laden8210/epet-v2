package com.example.consumetric.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.consumetric.database.DatabaseHelper;
import com.example.consumetric.model.FoodItem;
import com.example.consumetric.response.RepositoryResponse;

import java.util.ArrayList;
import java.util.List;

public class FoodItemRepository implements Repository<FoodItem> {

    private DatabaseHelper databaseHelper;
    private static FoodItemRepository foodItemRepository;
    private Context context;

    private FoodItemRepository(Context context) {
        this.context = context;
        databaseHelper = DatabaseHelper.getInstance(context);
    }

    public static synchronized FoodItemRepository getInstance(Context context) {
        if (foodItemRepository == null) {
            foodItemRepository = new FoodItemRepository(context);
        }
        return foodItemRepository;
    }

    @Override
    public void selectAll(RepositoryResponse<FoodItem> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        List<FoodItem> foodItemList = new ArrayList<>();

        Cursor cursor = null;
        try {
            String query = "SELECT * FROM " + FoodItem.TABLE_NAME;
            cursor = db.rawQuery(query, null);
            if (cursor.moveToFirst()) {
                do {
                    FoodItem foodItem = new FoodItem(
                            cursor.getInt(cursor.getColumnIndexOrThrow(FoodItem.COLUMN_ID)),
                            cursor.getString(cursor.getColumnIndexOrThrow(FoodItem.COLUMN_NAME)),
                            cursor.getString(cursor.getColumnIndexOrThrow(FoodItem.COLUMN_PORTION_SIZE)),
                            cursor.getDouble(cursor.getColumnIndexOrThrow(FoodItem.COLUMN_KCAL)),

                            cursor.getString(cursor.getColumnIndexOrThrow(FoodItem.COLUMN_DESCRIPTION))

                    );
                    foodItemList.add(foodItem);
                } while (cursor.moveToNext());
            }
            repositoryResponse.onSuccessList(foodItemList);
        } catch (SQLException e) {
            repositoryResponse.onFailure(e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
    }

    @Override
    public void selectById(int id, RepositoryResponse<FoodItem> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        FoodItem foodItem = null;
        Cursor cursor = null;

        try {
            String query = "SELECT * FROM " + FoodItem.TABLE_NAME + " WHERE " + FoodItem.COLUMN_ID + "=?";
            cursor = db.rawQuery(query, new String[]{String.valueOf(id)});
            if (cursor.moveToFirst()) {
                foodItem = new FoodItem(
                        cursor.getInt(cursor.getColumnIndexOrThrow(FoodItem.COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(FoodItem.COLUMN_NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(FoodItem.COLUMN_PORTION_SIZE)),
                        cursor.getDouble(cursor.getColumnIndexOrThrow(FoodItem.COLUMN_KCAL)),

                        cursor.getString(cursor.getColumnIndexOrThrow(FoodItem.COLUMN_DESCRIPTION))
                );
                repositoryResponse.onSuccess(foodItem);
            } else {
                repositoryResponse.onFailure("Food item not found");
            }
        } catch (SQLException e) {
            repositoryResponse.onFailure(e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
    }

    @Override
    public void search(String keyword, RepositoryResponse<FoodItem> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        List<FoodItem> foodItemList = new ArrayList<>();
        Cursor cursor = null;

        try {
            String query = "SELECT * FROM " + FoodItem.TABLE_NAME + " WHERE " + FoodItem.COLUMN_NAME + " LIKE ?";
            cursor = db.rawQuery(query, new String[]{"%" + keyword + "%"});
            if (cursor.moveToFirst()) {
                do {
                    FoodItem foodItem = new FoodItem(
                            cursor.getInt(cursor.getColumnIndexOrThrow(FoodItem.COLUMN_ID)),
                            cursor.getString(cursor.getColumnIndexOrThrow(FoodItem.COLUMN_NAME)),
                            cursor.getString(cursor.getColumnIndexOrThrow(FoodItem.COLUMN_PORTION_SIZE)),
                            cursor.getDouble(cursor.getColumnIndexOrThrow(FoodItem.COLUMN_KCAL)),

                            cursor.getString(cursor.getColumnIndexOrThrow(FoodItem.COLUMN_DESCRIPTION))
                    );
                    foodItemList.add(foodItem);
                } while (cursor.moveToNext());
            }
            repositoryResponse.onSuccessList(foodItemList);
        } catch (SQLException e) {
            repositoryResponse.onFailure(e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
    }

    @Override
    public void insert(FoodItem foodItem, RepositoryResponse<FoodItem> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FoodItem.COLUMN_NAME, foodItem.getName());
        values.put(FoodItem.COLUMN_PORTION_SIZE, foodItem.getPortionSize());
        values.put(FoodItem.COLUMN_KCAL, foodItem.getKcal());

        values.put(FoodItem.COLUMN_DESCRIPTION, foodItem.getDescription());

        try {
            long id = db.insert(FoodItem.TABLE_NAME, null, values);
            if (id != -1) {
                foodItem.setFoodItemId((int) id);
                repositoryResponse.onSuccess(foodItem);
            } else {
                repositoryResponse.onFailure("Failed to insert food item");
            }
        } catch (SQLException e) {
            repositoryResponse.onFailure(e.getMessage());
        } finally {
            db.close();
        }
    }

    @Override
    public void update(FoodItem foodItem, RepositoryResponse<FoodItem> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FoodItem.COLUMN_NAME, foodItem.getName());
        values.put(FoodItem.COLUMN_PORTION_SIZE, foodItem.getPortionSize());
        values.put(FoodItem.COLUMN_KCAL, foodItem.getKcal());

        try {
            int rows = db.update(FoodItem.TABLE_NAME, values, FoodItem.COLUMN_ID + "=?", new String[]{String.valueOf(foodItem.getFoodItemId())});
            if (rows > 0) {
                repositoryResponse.onSuccess(foodItem);
            } else {
                repositoryResponse.onFailure("Failed to update food item");
            }
        } catch (SQLException e) {
            repositoryResponse.onFailure(e.getMessage());
        } finally {
            db.close();
        }
    }

    @Override
    public void delete(FoodItem foodItem, RepositoryResponse<FoodItem> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        try {
            int rows = db.delete(FoodItem.TABLE_NAME, FoodItem.COLUMN_ID + "=?", new String[]{String.valueOf(foodItem.getFoodItemId())});
            if (rows > 0) {
                repositoryResponse.onSuccess(foodItem);
            } else {
                repositoryResponse.onFailure("Failed to delete food item");
            }
        } catch (SQLException e) {
            repositoryResponse.onFailure(e.getMessage());
        } finally {
            db.close();
        }
    }

    @Override
    public void deleteAll(RepositoryResponse<FoodItem> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        try {
            int rows = db.delete(FoodItem.TABLE_NAME, null, null);
            if (rows > 0) {
                repositoryResponse.onSuccess(null);
            } else {
                repositoryResponse.onFailure("Failed to delete all food items");
            }
        } catch (SQLException e) {
            repositoryResponse.onFailure(e.getMessage());
        } finally {
            db.close();
        }
    }

    public boolean hasFoodItems() {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM food_items", null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        cursor.close();
        return count > 0;
    }

}
