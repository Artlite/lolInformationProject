package com.artlite.adapteredrecyclerview.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.artlite.adapteredrecyclerview.anotations.ARFindColorBy;
import com.artlite.adapteredrecyclerview.anotations.ARFindDrawableBy;
import com.artlite.adapteredrecyclerview.anotations.ARFindLibraryViewBy;
import com.artlite.adapteredrecyclerview.anotations.ARFindStringBy;
import com.artlite.adapteredrecyclerview.anotations.ARFindViewBy;
import com.artlite.adapteredrecyclerview.callbacks.OnAnnotationCallback;
import com.artlite.adapteredrecyclerview.containers.ARResourceContainer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Class which provide the annotation performing
 * Created by dlernatovich on 12/14/2016.
 */

public final class ARAnnotationHelper extends ARBaseHelper {
    /**
     * TAG field
     */
    public static final String TAG = ARAnnotationHelper.class.getSimpleName();

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
            if (annotation instanceof ARFindViewBy) {
                id = ((ARFindViewBy) annotation).id();
            } else if (annotation instanceof ARFindLibraryViewBy) {
                final String name = ((ARFindLibraryViewBy) annotation).name();
                id = ARResourceContainer.getInstance().get(name);
            }
            if (id != null) {
                try {
                    final View foundedView = view.findViewById(id);
                    field.set(object, foundedView);
                } catch (Exception ex) {
                    log(TAG, methodName, ex, null);
                }
            }
        }
    }

    /**
     * Method which provide the setting of the {@link Field} from
     * {@link ARFindStringBy}
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
            if (annotation instanceof ARFindStringBy) {
                final int id = ((ARFindStringBy) annotation).id();
                try {
                    final String text = context.getString(id);
                    field.set(object, text);
                } catch (Exception ex) {
                    log(TAG, methodName, ex, null);
                }
            }
        }
    }

    /**
     * Method which provide the setting of the {@link Field} from
     * {@link ARFindDrawableBy}
     *
     * @param object     instance of owner
     * @param context    instance of {@link Context}
     * @param field      instance of {@link Field}
     * @param annotation instance of {@link Annotation}
     */
    public static void annotateDrawable(@Nullable final Object object,
                                        @Nullable final Context context,
                                        @Nullable final Field field,
                                        @Nullable final Annotation annotation) {
        final String methodName = "void annotateString(object, context, field, annotation)";
        if (validate(context, field, annotation)) {
            if (annotation instanceof ARFindDrawableBy) {
                final int id = ((ARFindDrawableBy) annotation).id();
                try {
                    final Drawable drawable = context.getResources().getDrawable(id);
                    field.set(object, drawable);
                } catch (Exception ex) {
                    log(TAG, methodName, ex, null);
                }
            }
        }
    }

    /**
     * Method which provide the setting of the {@link Field} from
     * {@link ARFindColorBy}
     *
     * @param object     instance of owner
     * @param context    instance of {@link Context}
     * @param field      instance of {@link Field}
     * @param annotation instance of {@link Annotation}
     */
    public static void annotateColor(@Nullable final Object object,
                                     @Nullable final Context context,
                                     @Nullable final Field field,
                                     @Nullable final Annotation annotation) {
        final String methodName = "void annotateString(object, context, field, annotation)";
        if (validate(context, field, annotation)) {
            if (annotation instanceof ARFindColorBy) {
                final int id = ((ARFindColorBy) annotation).id();
                try {
                    final ColorStateList drawable = context.getResources().getColorStateList(id);
                    field.set(object, drawable);
                } catch (Exception ex) {
                    log(TAG, methodName, ex, null);
                }
            }
        }
    }

    /**
     * Method which provide the annotate of activity
     *
     * @param activity   activity instance
     * @param field      field
     * @param annotation annotation
     */
    public static void annotateActivity(@Nullable final Activity activity,
                                        @Nullable final Field field,
                                        @Nullable final Annotation annotation) {
        final String methodName = "void annotateView(object, view, field, annotation)";
        if (validate(activity, field, annotation)) {
            Integer id = null;
            if (annotation instanceof ARFindViewBy) {
                id = ((ARFindViewBy) annotation).id();
            } else if (annotation instanceof ARFindLibraryViewBy) {
                final String name = ((ARFindLibraryViewBy) annotation).name();
                id = ARResourceContainer.getInstance().get(name);
            }
            if (id != null) {
                try {
                    final View foundedView = activity.findViewById(id);
                    field.set(activity, foundedView);
                } catch (Exception ex) {
                    log(TAG, methodName, ex, null);
                }
            }
        }
    }

    /**
     * Method which provide the annotate of activity
     *
     * @param fragment   activity instance
     * @param field      field
     * @param annotation annotation
     */
    public static void annotateFragment(@Nullable final Fragment fragment,
                                        @Nullable final View fragmentView,
                                        @Nullable final Field field,
                                        @Nullable final Annotation annotation) {
        final String methodName = "void annotateView(object, view, field, annotation)";
        if (validate(fragment, field, annotation)) {
            Integer id = null;
            if (annotation instanceof ARFindViewBy) {
                id = ((ARFindViewBy) annotation).id();
            } else if (annotation instanceof ARFindLibraryViewBy) {
                final String name = ((ARFindLibraryViewBy) annotation).name();
                id = ARResourceContainer.getInstance().get(name);
            }
            if (id != null) {
                try {
                    final View foundedView = fragmentView.findViewById(id);
                    field.set(fragment, foundedView);
                } catch (Exception ex) {
                    log(TAG, methodName, ex, null);
                }
            }
        }
    }
}
