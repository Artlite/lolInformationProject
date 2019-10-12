package com.artlite.adapteredrecyclerview.helpers;

import android.content.Context;
import android.content.res.ColorStateList;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;

/**
 * Created by dlernatovich on 10/24/2016.
 */

public final class ARColorHelper {

    /**
     * Method which provide the getting of the {@link ColorStateList} list from
     * color resources
     *
     * @param colorResource color resource
     * @return color state list
     */
    @NonNull
    public static ColorStateList getColorStateList(@ColorInt int colorResource) {
        return new ColorStateList(new int[][]{
                new int[]{android.R.attr.state_enabled}, // enabled
                new int[]{-android.R.attr.state_enabled}, // disabled
                new int[]{-android.R.attr.state_checked}, // unchecked
                new int[]{android.R.attr.state_pressed}  // pressed
        }, new int[]{
                colorResource,
                colorResource,
                colorResource,
                colorResource
        });
    }

    /**
     * Method which provide the getting of the {@link ColorStateList} list from
     * color resources
     *
     * @param colorResource color resource
     * @return color state list
     */
    @NonNull
    public static ColorStateList getColorStateList(@ColorRes int colorResource,
                                                   @NonNull final Context context) {
        return context.getResources().getColorStateList(colorResource);
    }
}
