package com.artlite.collapsinglayouttest.ui.fragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.adapteredrecyclerview.callbacks.BaseRecyclerCallback;
import com.adapteredrecyclerview.events.RecycleEvent;
import com.adapteredrecyclerview.ui.views.AdapteredRecyclerView;
import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.core.application.CurrentApplication;
import com.artlite.collapsinglayouttest.model.Champion;
import com.artlite.collapsinglayouttest.providers.ChampionProvider;
import com.artlite.collapsinglayouttest.ui.activities.ChampionDetailActivity;
import com.artlite.collapsinglayouttest.ui.fragments.abs.BaseFragment;

import butterknife.InjectView;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class ChampionListFragment extends BaseFragment {

    @InjectView(R.id.main_recycler_view)
    AdapteredRecyclerView currenRecyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_champion_list;
    }

    @Override
    protected void onCreateFragment(View containerView) {
        currenRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        currenRecyclerView.setActionCallback(recyclerCallback);
        currenRecyclerView.set(new ChampionProvider().get());
    }

    /**
     * Callback which provide the action performing
     */
    private final BaseRecyclerCallback<Champion> recyclerCallback = new BaseRecyclerCallback<Champion>() {
        @Override
        public void onItemClick(int index, @NonNull Champion object) {
            CurrentApplication.getInstance().setCurrentChampion(object);
            startActivity(ChampionDetailActivity.class);
        }

        @Override
        public void onActionReceived(@NonNull RecycleEvent recycleEvent, int index, @NonNull Champion object) {

        }
    };

}
