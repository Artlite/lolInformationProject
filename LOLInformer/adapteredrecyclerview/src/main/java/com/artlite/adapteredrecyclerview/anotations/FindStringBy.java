package com.artlite.adapteredrecyclerview.anotations;

import android.support.annotation.StringRes;

import com.artlite.adapteredrecyclerview.ui.views.BaseRecyclerView;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation that allow to get string from Resource folder of Android
 * (USING FOR LOCALIZATION OF THE USER INTERFACE)
 *
 * @see BaseRecyclerView#onLinkFromAnnotations()
 * Created by dlernatovich on 12/14/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FindStringBy {
    @StringRes int id();
}
