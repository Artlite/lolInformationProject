package com.artlite.adapteredrecyclerview.anotations;


import androidx.annotation.NonNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@link java.lang.annotation.Annotation} which provide the getting of the library view by name
 *
 * @example if id is R.id.textview_main in this case you should
 * use @ARFindLibraryViewBy(name = "textview_main")
 * Created by dlernatovich on 12/14/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ARFindLibraryViewBy {
    @NonNull String name();
}
