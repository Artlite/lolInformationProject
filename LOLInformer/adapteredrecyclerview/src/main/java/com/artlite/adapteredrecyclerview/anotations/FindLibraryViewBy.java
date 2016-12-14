package com.artlite.adapteredrecyclerview.anotations;

import android.support.annotation.NonNull;

/**
 * {@link java.lang.annotation.Annotation} which provide the getting of the library view by name
 *
 * @example if id is R.id.textview_main in this case you should
 * use @FindLibraryViewBy(name = "textview_main")
 * Created by dlernatovich on 12/14/2016.
 */

public @interface FindLibraryViewBy {
    @NonNull String name();
}
