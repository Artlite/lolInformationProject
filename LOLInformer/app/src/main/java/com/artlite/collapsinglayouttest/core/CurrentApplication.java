package com.artlite.collapsinglayouttest.core;

import android.app.Application;

/**
 * Created by dlernatovich on 7/23/15.
 */
public class CurrentApplication extends Application {
    private static CurrentApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static CurrentApplication getInstance() {
        return instance;
    }
}
