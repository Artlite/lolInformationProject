package com.artlite.adapteredrecyclerview.helpers;

import android.support.annotation.Nullable;

import java.util.Collection;
import java.util.Map;

/**
 * Method which provide the validating
 * Created by dlernatovich on 12/14/2016.
 */

public final class ValidationHelper {
    /**
     * Method which provide the validation for null elements
     *
     * @param objects objects for validate
     * @return validation result
     */
    public static boolean nullValidate(@Nullable final Object... objects) {
        if (objects == null) {
            return false;
        }
        for (Object object : objects) {
            if (object == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method which provide the empty validations
     *
     * @param objects objects for validate
     * @return validation results
     */
    public static boolean emptyValidate(@Nullable final Object... objects) {
        if (objects == null) {
            return false;
        }
        if (objects.length == 0) {
            return false;
        }
        for (Object object : objects) {
            if (object == null) {
                return false;
            } else if (object instanceof Collection) {
                //List checking
                if (((Collection) object).isEmpty() == true) {
                    return false;
                }
            } else if (object instanceof Object[]) {
                //Array validate
                if (((Object[]) object).length == 0) {
                    return false;
                }
            } else if (object instanceof String) {
                //String validate
                if (((String) object).isEmpty() == true) {
                    return false;
                }
            } else if (object instanceof Map) {
                //Map validate
                if (((Map) object).isEmpty() == true) {
                    return false;
                }
            }
        }
        return true;
    }
}
