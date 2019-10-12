package com.artlite.collapsinglayouttest.constants;


import androidx.annotation.NonNull;

/**
 * Created by Artli on 13.11.2016.
 */

public enum Exceptions {
    NULL_CONTEXT(new Exception("Context shouldn\'t be null"));

    private final Exception error;

    /**
     * Default constructor
     *
     * @param error current error
     */
    Exceptions(@NonNull Exception error) {
        this.error = error;
    }

    /**
     * Method which provide the getting of the error
     *
     * @return current error
     */
    @NonNull
    public Exception getError() {
        return error;
    }
}
