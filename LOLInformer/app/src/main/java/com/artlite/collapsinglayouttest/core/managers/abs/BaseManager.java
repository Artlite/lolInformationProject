package com.artlite.collapsinglayouttest.core.managers.abs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Artli on 13.11.2016.
 */

public interface BaseManager {

    /**
     * Method which provide the getting of the manager name
     *
     * @return manager name
     */
    @NonNull
    String getManagerName();

    /**
     * Method which provide the getting context
     *
     * @return context
     */
    @Nullable
    Context getContext();

}
