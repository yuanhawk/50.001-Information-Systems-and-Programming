package com.example.norman_lee.myapplication;

import android.app.Application;
import android.content.SharedPreferences;

public class MyApplication extends Application {

    public static SharedPreferences instance;

    private String sharedPrefFile = "com.example.android.sharedprefs";

    @Override
    public void onCreate() {
        super.onCreate();
        if (instance == null)
            instance = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
    }

    public static SharedPreferences getSharedPref() {
        return instance;
    }
}
