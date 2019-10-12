package com.artlite.collapsinglayouttest.model.abs;

import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

import com.artlite.adapteredrecyclerview.models.ARObject;
import com.artlite.collapsinglayouttest.core.application.CurrentApplication;

/**
 * Created by Artli on 13.11.2016.
 */

public abstract class AbstractModel extends ARObject {

    /**
     * Default constructor for {@link ARObject}
     */
    public AbstractModel() {
        super();
    }

    /**
     * Constructor which provide the creating of the {@link ARObject} from {@link Parcel}
     *
     * @param parcel instance of {@link Parcel}
     */
    protected AbstractModel(@NonNull final Parcel parcel) {
        super(parcel);
    }

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
