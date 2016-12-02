package com.artlite.adapteredrecyclerview.ui.views;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Artli_000 on 24.07.2016.
 */
public abstract class BaseRecyclerView extends FrameLayout implements View.OnClickListener {

    private static final String TAG = BaseRecyclerView.class.getSimpleName();

    /**
     * Interface which provide the doing some action inside the Handler thread
     */
    protected interface OnActionPerformer {
        void onActionPerform();
    }

    protected static int K_DEFAULT_ID = Integer.MIN_VALUE;

    private final Handler MAIN_THREAD_HANDLER = new Handler();

    protected View baseView;

    /**
     * Default constructor
     *
     * @param context context to set
     */
    public BaseRecyclerView(@NonNull final Context context) {
        super(context);
        onInitializeView(context, null);
    }

    /**
     * Method which provide the attribute initialize
     *
     * @param context current context
     * @param attrs   current attribute
     */
    private void onInitializeView(@NonNull final Context context,
                                  @Nullable final AttributeSet attrs) {

        if (isInEditMode() == true) {
            return;
        }

        inflateView(context, getLayoutId());
        if (baseView != null) {
            onLinkInterface();
            if (attrs != null) {
                onAttributeInitialize(attrs);
            }
        }
        //TODO: If user use ButterKnife
        onCallbacksInitialize();
        onCreateView();
    }

    /**
     * Method which provide the attribute initializing
     *
     * @param attrs attributes
     */
    protected void onAttributeInitialize(@NonNull final AttributeSet attrs) {

    }

    /**
     * Method which provide the UI customizing with accordance to the custom attributes
     */
    protected void onApplyAttributes() {
    }

    /**
     * Method which provide the inflating of the view
     *
     * @param context  current context
     * @param layoutID layout id
     */
    private void inflateView(@NonNull Context context, int layoutID) {
        LayoutInflater inflater = LayoutInflater.from(context);
        baseView = inflater.inflate(layoutID, this);
    }

    /**
     * Method which provide the listener initializing
     */
    protected abstract void onCallbacksInitialize();


    /**
     * Method which provide to getting of the layout ID
     *
     * @return layout ID
     */
    protected abstract int getLayoutId();

    /**
     * Method which provide the interface linking
     */
    protected abstract void onLinkInterface();

    /**
     * Method which provide the getting of the clicked view ID
     *
     * @return clicked view ID
     */
    protected int getClickedID() {
        return 0;
    }

    /**
     * Method which provide the action when view will create
     */
    protected abstract void onCreateView();

    /**
     * Method which provide starting the Activity
     *
     * @param activtyClass activity which should be starting
     */
    public void startActivity(@NonNull final Class activtyClass) {
        final Context context = getContext();
        if (context != null) {
            context.startActivity(new Intent(context, activtyClass));
        }
    }

    /**
     * Method which provide the start activity with top clearing
     *
     * @param activtyClass activity class
     */
    protected void startActivityWithClearTop(@NonNull final Class activtyClass) {
        final Context context = getContext();
        if (context != null) {
            Intent intent = new Intent(context, activtyClass);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |
                    Intent.FLAG_ACTIVITY_NEW_TASK |
                    Intent.FLAG_ACTIVITY_SINGLE_TOP);
            context.startActivity(intent);
        }
    }

    /**
     * Method which provide starting the Activity for results
     *
     * @param activtyClass activity which should be starting
     * @param resultCode   result code
     */
    protected void startActivityForResults(@NonNull final Class activtyClass, final int resultCode) {
        final Activity activity = getActivity();
        final Context context = getContext();
        if ((activity != null) && (context != null)) {
            activity.startActivityForResult(new Intent(context, activtyClass), resultCode);
        }
    }

    /**
     * Method which provide starting the Activity for results
     *
     * @param intent     intent which should be starting
     * @param resultCode result code
     */
    protected void startActivityForResults(@NonNull final Intent intent, final int resultCode) {
        final Activity activity = getActivity();
        final Context context = getContext();
        if ((activity != null) && (context != null)) {
            activity.startActivityForResult(intent, resultCode);
        }
    }

    /**
     * Method which provide the setting of the OnClickListener
     *
     * @param views current list of Views
     */
    protected void setOnClickListeners(@NonNull final View... views) {
        for (View view : views) {
            view.setOnClickListener(this);
        }
    }

    /**
     * Method which provide the action for onClickListener
     *
     * @param v
     */
    @Override
    public void onClick(View v) {

    }

    /**
     * Method which provide the doing action on UI thread after the delaying time
     *
     * @param performer current action
     */
    protected void runOnMainThread(@Nullable final OnActionPerformer performer) {
        runOnMainThread(0, performer);
    }

    /**
     * Method which provide the doing action on UI thread after the delaying time
     *
     * @param delay     delaying time (in seconds)
     * @param performer current action
     */
    protected void runOnMainThread(int delay, @Nullable final OnActionPerformer performer) {
        MAIN_THREAD_HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (performer != null) {
                    performer.onActionPerform();
                }
            }
        }, delay);
    }

    /**
     * Method which provide the running action on the background thread
     *
     * @param performer action performer
     */
    protected void runOnBackground(@Nullable final OnActionPerformer performer) {
        runOnBackground(0, performer);
    }

    /**
     * Method which provide the running action on the background thread
     *
     * @param delay     delaying time (in seconds)
     * @param performer action performer
     */
    protected void runOnBackground(int delay, @Nullable final OnActionPerformer performer) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (performer != null) {
                    performer.onActionPerform();
                }
            }
        }, delay * 1000);
    }

    /**
     * Method which provide the keyboard hiding
     */
    protected void hideKeyboard() {
        final Activity activity = getActivity();
        if (activity != null) {
            try {
                InputMethodManager inputMethod = (InputMethodManager) activity
                        .getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethod.hideSoftInputFromWindow(activity.getWindow()
                        .getDecorView().getRootView().getWindowToken(), 0);
            } catch (Exception ex) {
                Log.e(TAG, ex.toString());
            }
        }
    }

    /**
     * Method which provide the getting of the current activity from view
     *
     * @return getting activity
     */
    @Nullable
    protected Activity getActivity() {
        Context context = getContext();
        if (context != null) {
            while (context instanceof ContextWrapper) {
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        return null;
    }
}
