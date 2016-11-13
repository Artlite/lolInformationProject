package com.artlite.collapsinglayouttest.core.managers;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import com.artlite.collapsinglayouttest.core.application.CurrentApplication;
import com.artlite.collapsinglayouttest.core.managers.abs.AbstractManager;
import com.artlite.collapsinglayouttest.core.managers.abs.BaseManager;
import com.artlite.collapsinglayouttest.core.managers.impl.TypeFaceManager;
import com.artlite.collapsinglayouttest.utils.AppLogger;

/**
 * Created by Artli on 13.11.2016.
 */

public enum Managers {
    TYPE_FACE(new TypeFaceManager());

    private final BaseManager manager;

    /**
     * Default constructor
     *
     * @param manager
     */
    Managers(@NonNull BaseManager manager) {
        this.manager = manager;
    }

    /**
     * Method which provide the getting manager
     *
     * @param <T> manager type
     * @return
     */
    @Nullable
    public <T extends BaseManager> T getManager() {
        T result = null;
        try {
            result = (T) manager;
        } catch (Exception e) {
            AppLogger.error(this, e.toString());
        } finally {
            return result;
        }
    }
}
