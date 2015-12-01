package com.artlite.collapsinglayouttest.core.application;

import android.app.Application;

import com.artlite.collapsinglayouttest.core.managers.TypeFaceManager;
import com.artlite.collapsinglayouttest.model.Champion;
import com.artlite.collapsinglayouttest.utils.AppLogger;

/**
 * Created by dlernatovich on 7/23/15.
 */
public class CurrentApplication extends Application {

    private static CurrentApplication instance;

    private Champion currentChampion;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        TypeFaceManager.getInstance(this);
    }

    /**
     * Method which provide the getting of the current instance of the Application
     *
     * @return current Application
     */
    public static CurrentApplication getInstance() {
        return instance;
    }

    /**
     * Method which provide the getting of the String value from the xml
     *
     * @param stringId current String ID
     * @return returned String
     */
    public String getStringValue(int stringId) {
        try {
            return getResources().getString(stringId);
        } catch (Exception ex) {
            AppLogger.error(this, ex.toString(), "getStringValue method");
        }
        return "";
    }

    //GETTERS AND SETTERS
    public Champion getCurrentChampion() {
        return currentChampion;
    }

    public void setCurrentChampion(Champion currentChampion) {
        this.currentChampion = currentChampion;
    }
}
