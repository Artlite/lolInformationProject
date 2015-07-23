package com.artlite.collapsinglayouttest.core;

import android.app.Application;

import com.artlite.collapsinglayouttest.utils.AppLogger;

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

    public String getStringValue(int stringId) {
        try {
            return getResources().getString(stringId);
        } catch (Exception ex) {
            AppLogger.error(this, ex.toString(), "getStringValue method");
        }
        return "";
    }
}
