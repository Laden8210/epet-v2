package com.example.consumetric.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.consumetric.database.DatabaseHelper;
import com.example.consumetric.model.User;
import com.example.consumetric.response.RepositoryResponse;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements Repository<User> {

    private DatabaseHelper databaseHelper;
    private static UserRepository userRepository;
    private Context context;

    private UserRepository(Context context) {
        this.context = context;
        databaseHelper = DatabaseHelper.getInstance(context);
    }

    public static synchronized UserRepository getInstance(Context context) {
        if (userRepository == null) {
            userRepository = new UserRepository(context);
        }
        return userRepository;
    }

    @Override
    public void selectAll(RepositoryResponse<User> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        List<User> users = new ArrayList<>();
        Cursor cursor = db.query(User.TABLE_NAME, null, null, null, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                User user = new User();
                int idIndex = cursor.getColumnIndex(User.COLUMN_ID);
                int firstNameIndex = cursor.getColumnIndex(User.COLUMN_FIRST_NAME);
                int lastNameIndex = cursor.getColumnIndex(User.COLUMN_LAST_NAME);
                int birthDateIndex = cursor.getColumnIndex(User.COLUMN_BIRTH_DATE);
                int heightIndex = cursor.getColumnIndex(User.COLUMN_HEIGHT);
                int weightIndex = cursor.getColumnIndex(User.COLUMN_WEIGHT);
                int genderIndex = cursor.getColumnIndex(User.COLUMN_GENDER);
                int caloriesIndex = cursor.getColumnIndex(User.COLUMN_CALORIES);

                if (idIndex != -1) user.setId(cursor.getInt(idIndex));
                if (firstNameIndex != -1) user.setFirstName(cursor.getString(firstNameIndex));
                if (lastNameIndex != -1) user.setLastName(cursor.getString(lastNameIndex));
                if (birthDateIndex != -1) user.setBirthDate(cursor.getString(birthDateIndex));
                if (heightIndex != -1) user.setHeight(cursor.getDouble(heightIndex));
                if (weightIndex != -1) user.setWeight(cursor.getDouble(weightIndex));
                if (genderIndex != -1) user.setGender(cursor.getString(genderIndex));
                if (caloriesIndex != -1) user.setCalories(cursor.getDouble(caloriesIndex));

                users.add(user);
            }
            cursor.close();
            repositoryResponse.onSuccessList(users);
        } else {
            repositoryResponse.onFailure("No users found");
        }
    }

    @Override
    public void selectById(int id, RepositoryResponse<User> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String selection = User.COLUMN_ID + "=?";
        String[] selectionArgs = { String.valueOf(id) };
        Cursor cursor = db.query(User.TABLE_NAME, null, selection, selectionArgs, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            User user = new User();
            int firstNameIndex = cursor.getColumnIndex(User.COLUMN_FIRST_NAME);
            int lastNameIndex = cursor.getColumnIndex(User.COLUMN_LAST_NAME);
            int birthDateIndex = cursor.getColumnIndex(User.COLUMN_BIRTH_DATE);
            int heightIndex = cursor.getColumnIndex(User.COLUMN_HEIGHT);
            int weightIndex = cursor.getColumnIndex(User.COLUMN_WEIGHT);
            int genderIndex = cursor.getColumnIndex(User.COLUMN_GENDER);
            int caloriesIndex = cursor.getColumnIndex(User.COLUMN_CALORIES);

            if (firstNameIndex != -1) user.setFirstName(cursor.getString(firstNameIndex));
            if (lastNameIndex != -1) user.setLastName(cursor.getString(lastNameIndex));
            if (birthDateIndex != -1) user.setBirthDate(cursor.getString(birthDateIndex));
            if (heightIndex != -1) user.setHeight(cursor.getDouble(heightIndex));
            if (weightIndex != -1) user.setWeight(cursor.getDouble(weightIndex));
            if (genderIndex != -1) user.setGender(cursor.getString(genderIndex));
            if (caloriesIndex != -1) user.setCalories(cursor.getDouble(caloriesIndex));
            cursor.close();
            repositoryResponse.onSuccess(user);
        } else {
            repositoryResponse.onFailure("User not found");
        }
    }

    @Override
    public void search(String keyword, RepositoryResponse<User> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        List<User> users = new ArrayList<>();
        String selection = User.COLUMN_FIRST_NAME + " LIKE ? OR " + User.COLUMN_LAST_NAME + " LIKE ?";
        String[] selectionArgs = { "%" + keyword + "%", "%" + keyword + "%" };
        Cursor cursor = db.query(User.TABLE_NAME, null, selection, selectionArgs, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                User user = new User();
                int firstNameIndex = cursor.getColumnIndex(User.COLUMN_FIRST_NAME);
                int lastNameIndex = cursor.getColumnIndex(User.COLUMN_LAST_NAME);
                int birthDateIndex = cursor.getColumnIndex(User.COLUMN_BIRTH_DATE);
                int heightIndex = cursor.getColumnIndex(User.COLUMN_HEIGHT);
                int weightIndex = cursor.getColumnIndex(User.COLUMN_WEIGHT);
                int genderIndex = cursor.getColumnIndex(User.COLUMN_GENDER);
                int caloriesIndex = cursor.getColumnIndex(User.COLUMN_CALORIES);

                if (firstNameIndex != -1) user.setFirstName(cursor.getString(firstNameIndex));
                if (lastNameIndex != -1) user.setLastName(cursor.getString(lastNameIndex));
                if (birthDateIndex != -1) user.setBirthDate(cursor.getString(birthDateIndex));
                if (heightIndex != -1) user.setHeight(cursor.getDouble(heightIndex));
                if (weightIndex != -1) user.setWeight(cursor.getDouble(weightIndex));
                if (genderIndex != -1) user.setGender(cursor.getString(genderIndex));
                if (caloriesIndex != -1) user.setCalories(cursor.getDouble(caloriesIndex));

                users.add(user);
            }
            cursor.close();
            if (!users.isEmpty()) {
                repositoryResponse.onSuccessList(users);
            } else {
                repositoryResponse.onFailure("No users found matching the keyword");
            }
        } else {
            repositoryResponse.onFailure("Error searching users");
        }
    }

    @Override
    public void insert(User user, RepositoryResponse<User> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User.COLUMN_FIRST_NAME, user.getFirstName());
        values.put(User.COLUMN_LAST_NAME, user.getLastName());
        values.put(User.COLUMN_BIRTH_DATE, user.getBirthDate());
        values.put(User.COLUMN_HEIGHT, user.getHeight());
        values.put(User.COLUMN_WEIGHT, user.getWeight());
        values.put(User.COLUMN_GENDER, user.getGender());
        values.put(User.COLUMN_CALORIES, user.getCalories());

        long newRowId = db.insert(User.TABLE_NAME, null, values);
        if (newRowId != -1) {
            user.setId((int) newRowId); // Assuming setId method exists in User model
            repositoryResponse.onSuccess(user);
        } else {
            repositoryResponse.onFailure("Error inserting user");
        }
    }

    @Override
    public void update(User user, RepositoryResponse<User> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User.COLUMN_HEIGHT, user.getHeight());
        values.put(User.COLUMN_WEIGHT, user.getWeight());
        values.put(User.COLUMN_GENDER, user.getGender());
        values.put(User.COLUMN_CALORIES, user.getCalories());

        String selection = User.COLUMN_ID + "=?";
        String[] selectionArgs = { String.valueOf(user.getId()) };

        int count = db.update(User.TABLE_NAME, values, selection, selectionArgs);
        if (count > 0) {
            repositoryResponse.onSuccess(user);
        } else {
            repositoryResponse.onFailure("Error updating user" + user.getId());
        }
    }

    @Override
    public void delete(User user, RepositoryResponse<User> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        String selection = User.COLUMN_ID + "=?";
        String[] selectionArgs = { String.valueOf(user.getId()) };

        int deletedRows = db.delete(User.TABLE_NAME, selection, selectionArgs);
        if (deletedRows > 0) {
            repositoryResponse.onSuccessMessage("User deleted successfully");
        } else {
            repositoryResponse.onFailure("Error deleting user");
        }
    }

    @Override
    public void deleteAll(RepositoryResponse<User> repositoryResponse) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        int deletedRows = db.delete(User.TABLE_NAME, null, null);
        if (deletedRows > 0) {
            repositoryResponse.onSuccessMessage("All users deleted successfully");
        } else {
            repositoryResponse.onFailure("Error deleting users");
        }
    }
}
