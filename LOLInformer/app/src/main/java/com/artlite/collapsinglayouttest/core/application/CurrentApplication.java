package com.artlite.collapsinglayouttest.core.application;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.artlite.bslibrary.constants.BSTypeface;
import com.artlite.bslibrary.core.BSInstance;
import com.artlite.bslibrary.managers.BSContextManager;
import com.artlite.collapsinglayouttest.utils.AppLogger;

/**
 * Created by dlernatovich on 7/23/15.
 */
public final class CurrentApplication extends Application {

    /**
     * Called when the application is starting, before any activity, service,
     * or receiver objects (excluding content providers) have been created.
     * Implementations should be as quick as possible (for example using
     * lazy initialization of state) since the time spent in this function
     * directly impacts the performance of starting the first activity,
     * service, or receiver in a process.
     * If you override this method, be sure to call super.onCreate().
     */
    @Override
    public void onCreate() {
        super.onCreate();
        BSInstance.init(this, BSTypeface.SFC);
    }

    /**
     * Method which provide the getting of the String value from the xml
     *
     * @param stringId current String ID
     * @return returned String
     */
    @NonNull
    public static final String getStringValue(@StringRes int stringId) {
        try {
            return BSContextManager.getApplicationContext().getResources().getString(stringId);
        } catch (Exception ex) {
            AppLogger.error(BSContextManager.getApplicationContext(),
                    ex.toString(), "CurrentApplication -> getStringValue");
        }
        return "";
    }

}
