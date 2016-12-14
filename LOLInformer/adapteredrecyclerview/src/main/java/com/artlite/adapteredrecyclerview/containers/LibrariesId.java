package com.artlite.adapteredrecyclerview.containers;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dlernatovich on 12/14/2016.
 */

public final class LibrariesId {

    /**
     * Instance
     */
    private static LibrariesId instance;

    /**
     * Identificators container
     */
    private final Map<String, Integer> ids;

    /**
     * Constructor which provide the
     */
    private LibrariesId() {
        this.ids = new HashMap<>();
    }

    /**
     * Method which provide the getting instance of the {@link LibrariesId}
     *
     * @return instance of the {@link LibrariesId}
     */
    public static LibrariesId getInstance() {
        if (instance == null) {
            instance = new LibrariesId();
        }
        return instance;
    }

    /**
     * Method which provide the creating data from the Android R class. Using for library,
     * and should be calling from {@link android.app.Application} instance in onCreate method
     *
     * @param rCLass R.id.class for library
     */
    public static void create(@Nullable final Class rCLass) {
        if (rCLass != null) {
            getInstance().add(rCLass);
        }
    }


    /**
     * Method which provide the adding IDs from R.id.class
     *
     * @param rClass instance of the R.id.class
     */
    public final void add(@NonNull final Class rClass) {
        final Field[] declaredFields = rClass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            final Field declaredField = declaredFields[i];
            if (Modifier.isStatic(declaredField.getModifiers())) {
                try {
                    ids.put(declaredField.getName(),
                            declaredField.getInt(null));
                } catch (Exception ex) {
                    /** Should be ignored, because this is other way for libraries projects*/
                }
            }
        }
    }

    /**
     * Method which provide the getting of the index by name
     *
     * @param name name representation of the ID
     * @return id value
     */
    @Nullable
    public final Integer get(@Nullable final String name) {
        if (TextUtils.isEmpty(name) || (!ids.containsKey(name))) {
            return null;
        }
        return ids.get(name);
    }
}
