package com.artlite.collapsinglayouttest.core.application;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import com.artlite.collapsinglayouttest.core.managers.impl.TypeFaceManager;
import com.artlite.collapsinglayouttest.model.Champion;
import com.artlite.collapsinglayouttest.utils.AppLogger;

/**
 * Created by dlernatovich on 7/23/15.
 */
public final class CurrentApplication extends Application {

    private static CurrentApplication instance;

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
        instance = this;
    }

    /**
     * Method which provide the getting of the current instance of the Application
     *
     * @return current Application
     */
    private static CurrentApplication getInstance() {
        return instance;
    }

    /**
     * Method which provide the getting of the {@link Context}
     *
     * @return application {@link Context}
     */
    public static Context getContext() {
        return getInstance();
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
            return getInstance().getResources().getString(stringId);
        } catch (Exception ex) {
            AppLogger.error(getInstance(), ex.toString(), "CurrentApplication -> getStringValue");
        }
        return "";
    }

}
