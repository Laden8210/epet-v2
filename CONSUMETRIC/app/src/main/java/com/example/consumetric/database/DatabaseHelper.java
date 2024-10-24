package com.example.consumetric.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.consumetric.model.Instance;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "consumetric.db";
    private static final int DATABASE_VERSION = 8;

    private DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    private static DatabaseHelper instance;

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Instance.CREATE_TABLE_FOOD_ITEM);
        sqLiteDatabase.execSQL(Instance.CREATE_TABLE_MEAL_PLAN);
        sqLiteDatabase.execSQL(Instance.CREATE_TABLE_MEAL_PLAN_FOOD_ITEM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Instance.DROP_TABLE_MEAL_PLAN);
        sqLiteDatabase.execSQL(Instance.DROP_TABLE_FOOD_ITEM);
        sqLiteDatabase.execSQL(Instance.DROP_TABLE_MEAL_PLAN_FOOD_ITEM);
        onCreate(sqLiteDatabase);

    }

}
