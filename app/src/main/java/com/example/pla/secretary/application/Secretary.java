package com.example.pla.secretary.application;

import android.app.Application;
import android.content.res.Configuration;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class Secretary extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Toast.makeText(this, "ConfigurationChanged", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Toast.makeText(this, "LowMemory", Toast.LENGTH_SHORT).show();
    }
}
