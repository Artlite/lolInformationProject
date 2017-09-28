package com.artlite.adapteredrecyclerview.containers;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dlernatovich on 12/14/2016.
 */

public final class ARResourceContainer {

    /**
     * Instance
     */
    private static ARResourceContainer instance;

    /**
     * Identificators container
     */
    private final Map<String, Integer> ids;

    private final List<String> classNames;

    /**
     * Constructor which provide the
     */
    private ARResourceContainer() {
        this.ids = new HashMap<>();
        this.classNames = new ArrayList<>();
    }

    /**
     * Method which provide the getting instance of the {@link ARResourceContainer}
     *
     * @return instance of the {@link ARResourceContainer}
     */
    public static ARResourceContainer getInstance() {
        if (instance == null) {
            instance = new ARResourceContainer();
        }
        return instance;
    }

    /**
     * Method which provide the creating data from the Android R class. Using for library,
     * and should be calling from {@link android.app.Application} instance in onCreate method
     *
     * @param classes R.id.class for library
     */
    public static void create(@Nullable final Class... classes) {
        if (classes != null) {
            for (final Class rClass : classes) {
                getInstance().add(rClass);
            }
        }
    }


    /**
     * Method which provide the adding IDs from R.id.class
     *
     * @param rClass instance of the R.id.class
     */
    public final void add(@Nullable final Class rClass) {
        if (rClass == null) {
            return;
        }
        //Break if class is already added
        if (isAlreadyAdded(rClass)) {
            return;
        }
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

    /**
     * Method which provide the checking if class is already added
     *
     * @param aClass class
     * @return checking value
     */
    private boolean isAlreadyAdded(@NonNull final Class aClass) {
        final String name = aClass.getName();
        if (classNames.contains(name)) {
            return true;
        }
        classNames.add(name);
        return false;
    }
}
