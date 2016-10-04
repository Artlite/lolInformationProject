package com.artlite.adapteredrecyclerview.constants;

import android.content.res.ColorStateList;
import android.graphics.Color;

/**
 * Created by dlernatovich on 10/4/16.
 */

public interface ColorStateConstants {
    ColorStateList K_DEFAULT_REFRESH_COLOR = new ColorStateList(new int[][]{
            new int[]{android.R.attr.state_enabled}, // enabled
            new int[]{-android.R.attr.state_enabled}, // disabled
            new int[]{-android.R.attr.state_checked}, // unchecked
            new int[]{android.R.attr.state_pressed}  // pressed
    }, new int[]{
            Color.BLACK,
            Color.BLACK,
            Color.BLACK,
            Color.BLACK
    });

    ColorStateList K_DEFAULT_REFRESH_BACKGROUND_COLOR = new ColorStateList(new int[][]{
            new int[]{android.R.attr.state_enabled}, // enabled
            new int[]{-android.R.attr.state_enabled}, // disabled
            new int[]{-android.R.attr.state_checked}, // unchecked
            new int[]{android.R.attr.state_pressed}  // pressed
    }, new int[]{
            Color.WHITE,
            Color.WHITE,
            Color.WHITE,
            Color.WHITE
    });
}
