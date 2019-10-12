package com.artlite.adapteredrecyclerview.helpers;


import android.app.Activity;
import android.content.Context;
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

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Class which provide the {@link java.lang.annotation.Annotation} injecting
 * Created by Artli on 18.12.2016.
 */

public final class ARInjector extends ARBaseHelper {

    /**
     * Method which provide the injecting from the activity
     *
     * @param activity instance of the {@link Activity}
     */
    public static void inject(@Nullable final Activity activity) {
        if (validate(activity)) {
            inject(activity, null, activity.getApplicationContext());
        }
    }

    /**
     * Method which provide the injection from {@link Fragment}
     *
     * @param fragment instance of {@link Fragment}
     * @param view     view for injection
     */
    public static void inject(@Nullable final Fragment fragment,
                              @Nullable final View view) {
        if (validate(fragment, view)) {
            final Activity activity = fragment.getActivity();
            if (validate(activity)) {
                final Context context = activity.getApplicationContext();
                if (validate(context)) {
                    inject(fragment, view, context);
                }
            }
        }
    }

    /**
     * Method which provide the injection from {@link Fragment}
     *
     * @param view instance of {@link View}
     */
    public static void inject(@Nullable final View view) {
        if (validate(view)) {
            final Context context = view.getContext();
            if (validate(context)) {
                inject(view, null, context);
            }
        }
    }

    /**
     * Method which provide the inject annotation from {@link Object}
     *
     * @param object  instance of {@link Object}
     * @param context instance of {@link Context}
     */
    public static void inject(@Nullable final Object object,
                              @Nullable final Context context) {
        if (validate(context, object)) {
            inject(object, null, context);
        }
    }

    /**
     * Method which provide the {@link Annotation} injection to object
     *
     * @param object  object
     * @param context context
     * @param <T>     class of owner
     */
    protected static <T extends Object> void inject(@Nullable final T object,
                                                    @Nullable final View fragmentView,
                                                    @Nullable final Context context) {
        if (validate(object, context)) {
            final OnAnnotationCallback<T> callback =
                    new OnAnnotationCallback<T>() {
                        @Override
                        public void onFoundAnnotation(@NonNull T object,
                                                      @NonNull Annotation annotation,
                                                      @NonNull Field field) throws IllegalAccessException {
                            //======================================================================
                            //                             ARFindStringBy
                            //======================================================================
                            if (annotation instanceof ARFindStringBy) {
                                ARAnnotationHelper.annotateString(object, context, field, annotation);
                                //==================================================================
                                //             ARFindDrawableBy
                                //==================================================================
                            } else if (annotation instanceof ARFindDrawableBy) {
                                ARAnnotationHelper.annotateDrawable(object, context, field, annotation);
                                //==================================================================
                                //              ARFindColorBy
                                //==================================================================
                            } else if (annotation instanceof ARFindColorBy) {
                                ARAnnotationHelper.annotateColor(object, context, field, annotation);
                                //==================================================================
                                //             ARFindLibraryViewBy and ARFindViewBy
                                //==================================================================
                            } else if ((annotation instanceof ARFindLibraryViewBy) ||
                                    (annotation instanceof ARFindViewBy)) {
                                if (object instanceof View) {
                                    ARAnnotationHelper.annotateView((View) object, field, annotation);
                                } else if (object instanceof Activity) {
                                    ARAnnotationHelper.annotateActivity((Activity) object, field, annotation);
                                } else if (object instanceof Fragment) {
                                    ARAnnotationHelper.annotateFragment((Fragment) object,
                                            fragmentView, field, annotation);
                                }
                            }
                        }
                    };
            ARAnnotationHelper.annotate(object, callback, ARFindViewBy.class, ARFindStringBy.class,
                    ARFindLibraryViewBy.class, ARFindDrawableBy.class, ARFindColorBy.class);
        }
    }
}
