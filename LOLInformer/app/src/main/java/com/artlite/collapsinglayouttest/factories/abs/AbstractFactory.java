package com.artlite.collapsinglayouttest.factories.abs;


import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

import com.artlite.collapsinglayouttest.core.application.CurrentApplication;

/**
 * Created by Artli on 13.11.2016.
 */

public abstract class AbstractFactory {

    /**
     * Method which provide the getting of the string value
     *
     * @param stringId text id
     * @return text from xml
     */
    @Nullable
    protected static String getText(@StringRes int stringId) {
        return CurrentApplication.getStringValue(stringId);
    }
}
