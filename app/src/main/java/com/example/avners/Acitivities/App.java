package com.example.avners.Acitivities;

import android.app.Application;

import com.example.avners.utils.mySPV;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        mySPV.init(this);
    }
}
