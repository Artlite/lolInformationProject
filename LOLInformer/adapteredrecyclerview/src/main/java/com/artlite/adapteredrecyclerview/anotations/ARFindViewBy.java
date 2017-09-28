package com.artlite.adapteredrecyclerview.anotations;

import android.support.annotation.IdRes;

import com.artlite.adapteredrecyclerview.ui.views.ARBaseCell;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation which provide to inject view by {@link java.lang.annotation.Annotation}
 * (SIMILAR TO BUTTERKNIFE)
 *
 * @see ARBaseCell#onLinkFromAnnotations()
 * Created by dlernatovich on 12/14/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ARFindViewBy {
    @IdRes int id();
}
