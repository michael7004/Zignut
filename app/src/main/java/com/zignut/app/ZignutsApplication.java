package com.zignut.app;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Lenovo on 18-03-2018.
 */

public class ZignutsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);

    }
}
