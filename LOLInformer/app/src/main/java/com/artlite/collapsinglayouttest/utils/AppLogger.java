package com.artlite.collapsinglayouttest.utils;

import android.util.Log;

/**
 * Created by dlernatovich on 7/23/15.
 */
public class AppLogger {
    private static final String PREFIX = "===>";
    private static final String ERROR_PREFIX = "ERROR";

    public static void info(Object owner, String message) {
        Log.d(String.format("%s %s", PREFIX, owner.getClass().getSimpleName()), message);
    }

    public static void info(Object owner, String message, String additionalMessage) {
        Log.d(String.format("%s %s", PREFIX, owner.getClass().getSimpleName()), String.format("[%s] %s", additionalMessage.toUpperCase(), message));
    }

    public static void error(Object owner, String message) {
        Log.e(String.format("%s %s", PREFIX, owner.getClass().getSimpleName()), message);
    }

    public static void error(Object owner, String message, String additionalMessage) {
        Log.e(String.format("%s %s", PREFIX, owner.getClass().getSimpleName()), String.format("[%s] %s", additionalMessage.toUpperCase(), message));
    }
}
