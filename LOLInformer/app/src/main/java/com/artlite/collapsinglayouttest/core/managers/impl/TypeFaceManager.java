package com.artlite.collapsinglayouttest.core.managers.impl;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.artlite.collapsinglayouttest.constants.Exceptions;
import com.artlite.collapsinglayouttest.core.managers.abs.AbstractManager;

import java.lang.ref.WeakReference;

/**
 * manager which provide to adding of the custom font inside the application
 * Created by dlernatovich on 12/1/15.
 */
public class TypeFaceManager extends AbstractManager {

    private static TypeFaceManager instance;

    private Typeface FONT_BARRIOL;
    private Typeface FONT_BARRIOL_BOLD;

    /**
     * private constructor
     */
    public TypeFaceManager() {
        createFont(getContext());
        createBoldFont(getContext());
    }

    /**
     * Method which provide the getting of the FONT_BARRIOL font normal
     *
     * @return
     */
    @NonNull
    public Typeface getBarriolFont() {
        if (FONT_BARRIOL == null) {
            createFont(getContext());
        }
        return FONT_BARRIOL;
    }

    /**
     * Method which provide to getting of the FONT_BARRIOL_BOLD
     *
     * @return
     */
    @NonNull
    public Typeface getBarriolBoldFont() {
        if (FONT_BARRIOL_BOLD == null) {
            createBoldFont(getContext());
        }
        return FONT_BARRIOL_BOLD;
    }

    /**
     * Method which provide the create font from context
     *
     * @param context context
     * @return creation result
     */
    protected boolean createFont(@Nullable Context context) {
        boolean result = false;
        if (context != null) {
            FONT_BARRIOL = Typeface.createFromAsset(context.getAssets(), "fonts/Bariol.ttf");
            result = true;
        }
        return result;
    }

    /**
     * Method which provide the create font from context
     *
     * @param context context
     * @return creation result
     */
    protected boolean createBoldFont(@Nullable Context context) {
        boolean result = false;
        if (context != null) {
            FONT_BARRIOL_BOLD = Typeface.createFromAsset(context.getAssets(), "fonts/Bariol_Bold.otf");
            result = true;
        }
        return result;
    }
}
