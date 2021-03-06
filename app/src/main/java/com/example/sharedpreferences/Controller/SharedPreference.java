package com.example.sharedpreferences.Controller;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {

    private static final String USER_ID = "0";

    private static String PREFS_USER_ID = "UserId";


    public static void mSaveUserId(String getUserId,Context context) {

        SharedPreferences settings = context.getSharedPreferences(PREFS_USER_ID, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = settings.edit();

        editor.putString(USER_ID, getUserId);

        editor.apply();
    }

    public static String mGetUserId(Context context)
    {
        SharedPreferences settings = context.getSharedPreferences(PREFS_USER_ID, Context.MODE_PRIVATE);

        return settings.getString(USER_ID, "");
    }
}
