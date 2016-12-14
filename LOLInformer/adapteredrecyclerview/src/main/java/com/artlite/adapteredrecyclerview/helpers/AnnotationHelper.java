package com.artlite.adapteredrecyclerview.helpers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.artlite.adapteredrecyclerview.anotations.FindLibraryViewBy;
import com.artlite.adapteredrecyclerview.anotations.FindStringBy;
import com.artlite.adapteredrecyclerview.anotations.FindViewBy;
import com.artlite.adapteredrecyclerview.callbacks.OnAnnotationCallback;
import com.artlite.adapteredrecyclerview.containers.AdapteredResourceContainer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Class which provide the annotation performing
 * Created by dlernatovich on 12/14/2016.
 */

public final class AnnotationHelper extends BaseHelper {
    /**
     * TAG field
     */
    public static final String TAG = AnnotationHelper.class.getSimpleName();

    //==============================================================================================
    //                              BASIC ANNOTATION METHODS
    //==============================================================================================

    /**
     * Method which provide the annotation performing
     *
     * @param object  owner object
     * @param classes list of {@link Annotation} classes
     */
    public static <T extends Object> void annotate(@Nullable final T object,
                                                   @Nullable final OnAnnotationCallback<T> callback,
                                                   @Nullable final Class... classes) {
        //Check inner objects
        if (!validate(object, callback, classes)) {
            return;
        }
        //Get class
        final Class oCLass = object.getClass();
        //Get fields
        final Field[] fields = oCLass.getDeclaredFields();
        if (validate(fields)) {
            for (final Field field : fields) {
                for (final Class aClass : classes) {
                    if (validate(aClass)) {
                        final Annotation annotation = field.getAnnotation(aClass);
                        if (validate(annotation)) {
                            execute(object, callback, annotation, field);
                        }
                    }
                }
            }
        }
    }

    /**
     * Method which provide the performing of callback
     *
     * @param object     object
     * @param callback   callback
     * @param annotation annotation
     */
    private static <T extends Object> void execute(@NonNull final T object,
                                                   @NonNull final OnAnnotationCallback<T> callback,
                                                   @NonNull final Annotation annotation,
                                                   @NonNull final Field field) {
        final String methodName = "void execute(object, callback, annotation, field)";
        try {
            field.setAccessible(true);
            callback.onFoundAnnotation(object, annotation, field);
        } catch (Exception ex) {
            log(TAG, methodName, ex, null);
        }
    }

    //==============================================================================================
    //                              TYPED ANNOTATION METHODS
    //==============================================================================================

    /**
     * Method which provide the view annotating
     *
     * @param field      field instance
     * @param view       view
     * @param annotation instance of {@link Annotation}
     */
    public static void annotateView(@Nullable final View view,
                                    @Nullable final Field field,
                                    @Nullable final Annotation annotation) {
        annotateView(view, view, field, annotation);
    }

    /**
     * Method which provide the view annotating
     *
     * @param field      field instance
     * @param object     instance of owner
     * @param view       view
     * @param annotation instance of {@link Annotation}
     */
    public static void annotateView(@Nullable final Object object,
                                    @Nullable final View view,
                                    @Nullable final Field field,
                                    @Nullable final Annotation annotation) {
        final String methodName = "void annotateView(object, view, field, annotation)";
        if (validate(object, view, field, annotation)) {
            Integer id = null;
            if (annotation instanceof FindViewBy) {
                id = ((FindViewBy) annotation).id();
            } else if (annotation instanceof FindLibraryViewBy) {
                final String name = ((FindLibraryViewBy) annotation).name();
                id = AdapteredResourceContainer.getInstance().get(name);
            }
            if (id != null) {
                final View foundedView = view.findViewById(id);
                if (view != null) {
                    try {
                        field.set(object, foundedView);
                    } catch (Exception ex) {
                        log(TAG, methodName, ex, null);
                    }
                }
            }
        }
    }

    /**
     * Method which provide the setting of the {@link Field} from
     * {@link com.artlite.adapteredrecyclerview.anotations.FindStringBy}
     *
     * @param object     instance of owner
     * @param context    instance of {@link Context}
     * @param field      instance of {@link Field}
     * @param annotation instance of {@link Annotation}
     */
    public static void annotateString(@Nullable final Object object,
                                      @Nullable final Context context,
                                      @Nullable final Field field,
                                      @Nullable final Annotation annotation) {
        final String methodName = "void annotateString(object, context, field, annotation)";
        if (validate(context, field, annotation)) {
            if (annotation instanceof FindStringBy) {
                final int id = ((FindStringBy) annotation).id();
                try {
                    final String text = context.getString(id);
                    field.setAccessible(true);
                    field.set(object, text);
                } catch (Exception ex) {
                    log(TAG, methodName, ex, null);
                }
            }
        }
    }
}
