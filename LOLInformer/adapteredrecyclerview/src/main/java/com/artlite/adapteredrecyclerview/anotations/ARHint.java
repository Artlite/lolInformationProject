package com.artlite.adapteredrecyclerview.anotations;


import androidx.annotation.NonNull;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Artli on 15.12.2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ARHint {
    @NonNull String message();
}
