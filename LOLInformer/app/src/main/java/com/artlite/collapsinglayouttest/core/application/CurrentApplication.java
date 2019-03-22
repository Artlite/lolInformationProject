package com.artlite.collapsinglayouttest.core.application;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.util.Log;

import com.artlite.bslibrary.constants.BSTypeface;
import com.artlite.bslibrary.core.BSInstance;
import com.artlite.bslibrary.helpers.log.BSLogHelper;
import com.artlite.bslibrary.managers.BSContextManager;
import com.artlite.bslibrary.managers.BSCryptSharedPreferenceManager;
import com.artlite.collapsinglayouttest.utils.AppLogger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
        BSInstance.init(this, BSTypeface.EXO_2);

        final String text = "Lorem Ipsum Dolor Sit Amet Consectetur Adipisicing Elit Sed Do Eiusmod Tempor Inc";
        final Date date = new Date();
        final List<String> strings = new ArrayList<>(Arrays.asList(new String[]{
                "Lorem Ipsum Dolor Sit Amet Co",
                "Lorem Ipsum Dolor Sit Amet Consectetur Adipisicing Elit Sed Do Eiusmo",
                "Lorem Ipsum Dolor Sit Amet Consectetur Adipisicing Elit Sed Do Eiusmod Temp"

        }));

        BSCryptSharedPreferenceManager.save(date, "K_DATE");
        BSCryptSharedPreferenceManager.save(text, "K_TEXT");
        BSCryptSharedPreferenceManager.save(strings, "K_TEXTS");

        final String text1 = BSCryptSharedPreferenceManager.getString("K_TEXT");
        final Date date1 = BSCryptSharedPreferenceManager.getDate("K_DATE");
        final List<String> strings1 = BSCryptSharedPreferenceManager.getList("K_TEXTS");

        BSLogHelper.log(this, "onCreate1", null, text1);
        BSLogHelper.log(this, "onCreate1", null, date1);
        BSLogHelper.log(this, "onCreate1", null, strings1);
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
