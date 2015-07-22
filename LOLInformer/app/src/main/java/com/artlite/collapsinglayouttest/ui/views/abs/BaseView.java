package com.artlite.collapsinglayouttest.ui.views.abs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.ButterKnife;

/**
 * Created by dlernatovich on 7/22/15.
 */
public abstract class BaseView extends LinearLayout {

    protected View baseView;

    public BaseView(Context context) {
        super(context);
        onInitializeView(context);
    }

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        onInitializeView(context);
    }

    public BaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onInitializeView(context);
    }

    private void onInitializeView(Context context) {
        inflateView(context, getLayoutId());
        if (baseView != null) {
            ButterKnife.inject(this, baseView);
        }

        onCreateView();
    }

    /**
     * Method which provide the inflating of the view
     *
     * @param context  current context
     * @param layoutID layout id
     */
    private void inflateView(Context context, int layoutID) {
        LayoutInflater inflater = LayoutInflater.from(context);
        baseView = inflater.inflate(layoutID, this);
    }

    protected abstract int getLayoutId();

    protected abstract void onCreateView();

}
