package com.artlite.collapsinglayouttest.ui.views.abs;

import android.content.Context;
import android.util.AttributeSet;

import com.artlite.collapsinglayouttest.model.abs.BaseObject;

/**
 * Created by Artli_000 on 14.10.2015.
 */
public abstract class BaseRecyclerItem<T extends BaseObject> extends BaseView {
    public BaseRecyclerItem(Context context) {
        super(context);
    }

    public BaseRecyclerItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseRecyclerItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Method which provide the setting up for the current recycler item
     *
     * @param baseObject current object
     */
    public abstract void setUp(T baseObject);
}
