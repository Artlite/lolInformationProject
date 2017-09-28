package com.artlite.adapteredrecyclerview.helpers;

import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by dlernatovich on 12/14/2016.
 */

abstract class ARBaseHelper {
    /**
     * TAG variable
     */
    public static final String TAG = ARBaseHelper.class.getSimpleName();

    //==============================================================================================
    //                                      VALIDATIONS
    //==============================================================================================

    /**
     * Method which provide the validation
     *
     * @param objects objects
     * @return validation
     */
    protected static boolean validate(@Nullable final Object... objects) {
        return ARValidationHelper.emptyValidate(objects);
    }

    //==============================================================================================
    //                                      LOGGER
    //==============================================================================================

    /**
     * Method which provide the logger functional
     *
     * @param tag        class tag
     * @param methodName method name
     * @param error      error
     * @param object     object
     */
    protected static void log(@Nullable final String tag,
                              @Nullable final String methodName,
                              @Nullable final Exception error,
                              @Nullable final Object object) {
        final StringBuilder builder = new StringBuilder();
        if (validate(tag)) {
            builder.append("Class:\t").append(tag);
        }
        if (validate(methodName)) {
            builder.append("Method:\t").append(methodName);
        }
        if (validate(error)) {
            builder.append("Error:\t").append(error.toString());
        }
        if (validate(object)) {
            builder.append("Object:\t").append(object.toString());
        }
        if (error == null) {
            Log.e(TAG, builder.toString());
        } else {
            Log.i(TAG, builder.toString());
        }
    }
}
