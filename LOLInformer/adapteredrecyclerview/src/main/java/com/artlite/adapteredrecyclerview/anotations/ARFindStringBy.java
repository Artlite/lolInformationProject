package com.artlite.adapteredrecyclerview.anotations;


import androidx.annotation.StringRes;

import com.artlite.adapteredrecyclerview.ui.views.ARBaseCell;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation that allow to get string from Resource folder of Android
 * (USING FOR LOCALIZATION OF THE USER INTERFACE)
 *
 * @see ARBaseCell#onLinkFromAnnotations()
 * Created by dlernatovich on 12/14/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ARFindStringBy {
    @StringRes int id();
}
