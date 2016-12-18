package com.artlite.collapsinglayouttest.ui.fragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.artlite.adapteredrecyclerview.anotations.FindViewBy;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredBaseCallback;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredRefreshCallback;
import com.artlite.adapteredrecyclerview.containers.AdapteredResourceContainer;
import com.artlite.adapteredrecyclerview.core.AdapteredView;
import com.artlite.adapteredrecyclerview.events.RecycleEvent;
import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.core.application.CurrentApplication;
import com.artlite.collapsinglayouttest.core.managers.Managers;
import com.artlite.collapsinglayouttest.model.Champion;
import com.artlite.collapsinglayouttest.mvp.contracts.ChampionContract;
import com.artlite.collapsinglayouttest.mvp.impl.ChampionPresenter;
import com.artlite.collapsinglayouttest.providers.ChampionProvider;
import com.artlite.collapsinglayouttest.ui.activities.ChampionDetailActivity;
import com.artlite.collapsinglayouttest.ui.fragments.abs.BaseFragment;

import java.util.List;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class ChampionListFragment extends BaseFragment {

    @FindViewBy(id = R.id.main_recycler_view)
    private AdapteredView recyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_champion_list;
    }

    @Override
    protected void onCreateFragment(View containerView) {
        recyclerView.init(championPresenter.getLayoutManager(getContext()), recyclerCallback,
                refreshCallback);
        recyclerView.setIsNeedResfresh(false);
        championView.onCreateView();
    }

    /**
     * Callback which provide the action performing
     */
    private final OnAdapteredBaseCallback<Champion> recyclerCallback =
            new OnAdapteredBaseCallback<Champion>() {
                @Override
                public void onItemClick(int index, @NonNull Champion object) {
                    championView.onChampionClick(object);
                }

                @Override
                public void onItemLongClick(int index, @NonNull Champion object) {

                }

                @Override
                public void onActionReceived(@NonNull RecycleEvent recycleEvent,
                                             int index, @NonNull Champion object) {

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

    //MVP

    /**
     * View which provide the champion displaying
     */
    private final ChampionContract.ViewClass championView = new ChampionContract.ViewClass() {

        /**
         * Method which provide the actions when view created
         */
        @Override
        public void onCreateView() {
            setChampions(new ChampionProvider().get());
        }

        /**
         * Method which provide the champions setting
         *
         * @param champions list of champions
         */
        @Override
        public void setChampions(@NonNull List<Champion> champions) {
            recyclerView.set(champions);
        }

        /**
         * Method which provide the action when champion click
         *
         * @param champion champion
         */
        @Override
        public void onChampionClick(@NonNull Champion champion) {
            Managers.getTransferManager().setChampion(champion);
            startActivity(ChampionDetailActivity.class);
        }

        /**
         * Method which provide the getting of the current context
         *
         * @return context
         */
        @NonNull
        @Override
        public Context getCurrentContext() {
            return getContext();
        }
    };

    //PRESENTERS
    private final ChampionPresenter championPresenter = new ChampionPresenter(championView);

}
