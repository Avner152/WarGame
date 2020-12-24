package com.example.avners.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class mySPV {

    private static mySPV instance;
    private SharedPreferences prefs;

    public static mySPV getInstance() {
        return instance;
    }

    private mySPV(Context context) {
        prefs = context.getApplicationContext().getSharedPreferences("myKey", Context.MODE_PRIVATE);
    }

    public static void init(Context context) {
        if (instance == null) {
            instance = new mySPV(context);
        }
    }

    //// ---------------------------------------------------------- ////
    public void putString(String key, String value) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key, String def) {
        return prefs.getString(key, def);
    }

    public void removeKey(String key) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(key).apply();
    }

}