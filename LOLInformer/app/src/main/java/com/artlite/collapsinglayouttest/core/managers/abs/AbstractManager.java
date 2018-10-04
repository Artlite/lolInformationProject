package com.artlite.collapsinglayouttest.core.managers.abs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.artlite.bslibrary.managers.BSContextManager;
import com.artlite.collapsinglayouttest.core.application.CurrentApplication;
import com.artlite.collapsinglayouttest.core.managers.abs.BaseManager;

/**
 * Created by Artli on 13.11.2016.
 */

public abstract class AbstractManager implements BaseManager {

    /**
     * Method which provide the getting of the manager name
     *
     * @return manager name
     */
    @NonNull
    @Override
    public String getManagerName() {
        return getClass().getSimpleName();
    }

    /**
     * Method which provide the getting context
     *
     * @return context
     */
    @Nullable
    @Override
    public Context getContext() {
        return BSContextManager.getApplicationContext();
    }
}
