package com.jasper.billingsystem.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.jasper.billingsystem.model.Subscriber;

public class SessionManager {

    private static final String PREF_NAME = "UserSession";
    private static final String KEY_USER_MODEL = "user_model";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";

    private static SessionManager instance;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Gson gson;

    private SessionManager(Context context) {
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
        gson = new Gson();
    }

    public static synchronized SessionManager getInstance(Context context) {
        if (instance == null) {
            instance = new SessionManager(context.getApplicationContext());
        }
        return instance;
    }

    public void createLoginSession(Subscriber subscriber) {

        editor.putBoolean(KEY_IS_LOGGED_IN, true);


        String subscriberJson = gson.toJson(subscriber);
        editor.putString(KEY_USER_MODEL, subscriberJson);

        editor.apply();
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGED_IN, false);
    }


    public Subscriber getUserDetails() {
        String subscriberJson = pref.getString(KEY_USER_MODEL, null);
        if (subscriberJson != null) {
            // Deserialize the JSON string to a Subscriber object
            return gson.fromJson(subscriberJson, Subscriber.class);
        }
        return null;
    }

    public void logoutUser() {

        editor.clear();
        editor.apply();
    }
}
