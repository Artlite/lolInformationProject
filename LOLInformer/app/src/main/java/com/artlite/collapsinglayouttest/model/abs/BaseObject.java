package com.artlite.collapsinglayouttest.model.abs;

import android.content.Context;

import com.artlite.collapsinglayouttest.ui.views.abs.BaseRecyclerItem;

/**
 * Created by Artli_000 on 14.10.2015.
 */
public abstract class BaseObject {

    /**
     * Method which provide the getting of the current recycler item
     *
     * @param context current context
     * @return current instance for the Recycler item
     */
    public abstract BaseRecyclerItem getRecyclerItem(Context context);

}
