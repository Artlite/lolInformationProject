package com.artlite.collapsinglayouttest.model.abs;

import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import com.artlite.adapteredrecyclerview.models.BaseObject;
import com.artlite.collapsinglayouttest.core.application.CurrentApplication;

/**
 * Created by Artli on 13.11.2016.
 */

public abstract class AbstractModel extends BaseObject {

    /**
     * Method which provide the getting of the string value
     *
     * @param stringId text id
     * @return text from xml
     */
    @Nullable
    protected static String getText(@StringRes int stringId) {
        return CurrentApplication.getInstance().getStringValue(stringId);
    }
}
