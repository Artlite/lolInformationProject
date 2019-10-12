package com.artlite.collapsinglayouttest.mvp.impl;

import android.content.Context;
import android.content.res.Configuration;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.artlite.collapsinglayouttest.mvp.contracts.ChampionContract;

/**
 * Created by dlernatovich on 9/30/16.
 */

public final class ChampionPresenter implements ChampionContract.Presenter {

    private final ChampionContract.View view;

    /**
     * Default constructor
     *
     * @param view view
     */
    public ChampionPresenter(ChampionContract.View view) {
        this.view = view;
    }

    /**
     * Method which provide the getting of the column count
     *
     * @return column count
     */
    @Override
    public int getColumnCount() {
        if (view != null) {
            if (view.getCurrentContext()
                    .getResources()
                    .getConfiguration()
                    .orientation == Configuration.ORIENTATION_LANDSCAPE) {
                return 2;
            }
        }
        return 1;
    }

    /**
     * Method which provide the getting of the layout manager
     *
     * @return layout manager
     */
    @NonNull
    @Override
    public RecyclerView.LayoutManager getLayoutManager(@NonNull final Context context) {
        return new StaggeredGridLayoutManager(getColumnCount(),
                StaggeredGridLayoutManager.VERTICAL);
    }


}
