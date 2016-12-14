package com.artlite.adapteredrecyclerview.callbacks;

import android.support.annotation.NonNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Annotation callback
 */

public interface OnAnnotationCallback<T extends Object> {
    /**
     * Method which provide the action when one of the annotation class found
     *
     * @param object     owner object
     * @param annotation annotation
     * @param field      field with annotation
     */
    void onFoundAnnotation(@NonNull final T object,
                           @NonNull final Annotation annotation,
                           @NonNull final Field field)
            throws IllegalAccessException;
}
