package com.artlite.collapsinglayouttest.ui.views.recycler;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;

import com.artlite.adapteredrecyclerview.models.ARCell;
import com.artlite.adapteredrecyclerview.models.ARObject;
import com.artlite.collapsinglayouttest.R;

/**
 * Class which provide the blank spaces for the RecycleView
 */
public class BlankRecyclerItem extends ARCell<BlankRecyclerItem.Object> {

    /**
     * Default constructor
     *
     * @param context context to set
     */
    public BlankRecyclerItem(@NonNull Context context) {
        super(context);
    }

    /**
     * Method which provide the setting up for the current recycler item
     *
     * @param baseObject current object
     */
    @Override
    public void setUp(@NonNull Object baseObject) {

    }

    /**
     * Method which provide to getting of the layout ID
     *
     * @return layout ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.recycle_blank;
    }

    /**
     * Method which provide the action when view will create
     */
    @Override
    protected void onCreateView() {

    }

    /**
     * Object class for the {@link BlankRecyclerItem}
     */
    @SuppressLint("ParcelCreator")
    public static final class Object extends ARObject {

        /**
         * Constructor which provide the create {@link Object} with parametes
         *
         * @param priority instance of the {@link Priority}
         */
        public Object(final Priority priority) {
            this.priority = priority;
        }

        /**
         * Method which provide the getting of the current recycler item
         *
         * @param context current context
         * @return current instance for the Recycler item
         */
        @Override
        public ARCell getRecyclerItem(@NonNull Context context) {
            return new BlankRecyclerItem(context);
        }
    }
}
