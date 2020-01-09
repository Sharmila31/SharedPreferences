package com.example.sharedpreferences;

import android.app.Application;

public class AppController extends Application {

    private static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
    }


    public static synchronized AppController getInstance() {
        return mInstance;
    }
}
