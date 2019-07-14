package com.artlite.collapsinglayouttest.ui.fragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.artlite.adapteredrecyclerview.anotations.ARFindViewBy;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredBaseCallback;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredPagingCallback;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredRefreshCallback;
import com.artlite.adapteredrecyclerview.core.ARView;
import com.artlite.adapteredrecyclerview.events.AREvent;
import com.artlite.adapteredrecyclerview.models.ARObject;
import com.artlite.bslibrary.managers.BSThreadManager;
import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.model.Champion;
import com.artlite.collapsinglayouttest.model.abs.AbstractModel;
import com.artlite.collapsinglayouttest.mvp.contracts.ChampionContract;
import com.artlite.collapsinglayouttest.mvp.impl.ChampionPresenter;
import com.artlite.collapsinglayouttest.providers.ChampionProvider;
import com.artlite.collapsinglayouttest.ui.activities.ChampionDetailActivity;
import com.artlite.collapsinglayouttest.ui.fragments.abs.BaseFragment;
import com.artlite.collapsinglayouttest.ui.views.recycler.BlankRecyclerItem;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class ChampionListFragment<T extends AbstractModel>
        extends BaseFragment
        implements OnAdapteredPagingCallback {

    /**
     * Instance of the {@link ARView}
     */
    @ARFindViewBy(id = R.id.main_recycler_view)
    private ARView recyclerView;

    /**
     * Instance of the {@link BlankRecyclerItem.Object}
     */
    private BlankRecyclerItem.Object topBlank
            = new BlankRecyclerItem.Object(ARObject.Priority.MAX);

    /**
     * Instance of the {@link BlankRecyclerItem.Object}
     */
    private BlankRecyclerItem.Object bottomBlank
            = new BlankRecyclerItem.Object(ARObject.Priority.MIN);

    /**
     * Method which provide the getting of the current layout ID
     *
     * @return current layout ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_champion_list;
    }

    /**
     * Method which provide the action when fragment is created
     *
     * @param containerView current view
     */
    @Override
    protected void onCreateFragment(View containerView) {
        recyclerView.init(championPresenter.getLayoutManager(getContext()), recyclerCallback,
                refreshCallback, this);
        recyclerView.setIsNeedResfresh(false);
        recyclerView.set(Arrays.asList(new ARObject[]{this.topBlank, this.bottomBlank}));
        BSThreadManager.main(1, new BSThreadManager.OnThreadCallback() {
            @Override
            public void onExecute() {
                championView.onCreateView();
            }
        });
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
                public void onActionReceived(@NonNull AREvent AREvent,
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
            recyclerView.add(champions);
        }

        /**
         * Method which provide the action when champion click
         *
         * @param champion champion
         */
        @Override
        public void onChampionClick(@NonNull Champion champion) {
            ChampionDetailActivity.startActivity(getActivity(), champion);
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

    /**
     * Instance of the {@link ChampionPresenter}
     */
    private final ChampionPresenter championPresenter = new ChampionPresenter(championView);

//    /**
//     * Method which provide the notifying about item of list
//     *
//     * @param index {@link Integer} value of the visible index
//     */
//    @Override
//    public void onItemVisible(int index) {
//        Toast.makeText(getContext(), "Item :" + index, Toast.LENGTH_SHORT).show();
//    }

    /**
     * Method which provide the notifying about end of list
     *
     * @param listSize list size
     */
    @Override
    public void onNextPage(int listSize) {
        Toast.makeText(getContext(), "List size :" + listSize, Toast.LENGTH_SHORT).show();
    }
}
