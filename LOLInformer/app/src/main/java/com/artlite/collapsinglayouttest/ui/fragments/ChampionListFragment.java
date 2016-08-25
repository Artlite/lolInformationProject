package com.artlite.collapsinglayouttest.ui.fragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredBaseCallback;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredRefreshCallback;
import com.artlite.adapteredrecyclerview.core.AdapteredView;
import com.artlite.adapteredrecyclerview.events.RecycleEvent;
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
    AdapteredView recyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_champion_list;
    }

    @Override
    protected void onCreateFragment(View containerView) {
        recyclerView.init(new GridLayoutManager(getContext(), 1), recyclerCallback, refreshCallback);
        recyclerView.set(new ChampionProvider().get());
    }

    /**
     * Callback which provide the action performing
     */
    private final OnAdapteredBaseCallback<Champion> recyclerCallback = new OnAdapteredBaseCallback<Champion>() {
        @Override
        public void onItemClick(int index, @NonNull Champion object) {
            CurrentApplication.getInstance().setCurrentChampion(object);
            startActivity(ChampionDetailActivity.class);
        }

        @Override
        public void onActionReceived(@NonNull RecycleEvent recycleEvent, int index, @NonNull Champion object) {

        }
    };

    /**
     * Callback which provide the listening of the refresh callback
     */
    private final OnAdapteredRefreshCallback refreshCallback = new OnAdapteredRefreshCallback() {
        @Override
        public void onRefreshData() {
            recyclerView.hideRefresh();
        }
    };

}
