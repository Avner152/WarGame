package com.example.avners.Acitivities;

import android.app.Application;

import com.example.avners.utils.MySPV;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MySPV.init(this);
    }
}