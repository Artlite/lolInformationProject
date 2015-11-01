package com.artlite.collapsinglayouttest.ui.fragments;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.providers.ChampionProvider;
import com.artlite.collapsinglayouttest.ui.custom.AdapteredRecyclerView;
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
        currenRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        currenRecyclerView.updateList(new ChampionProvider().get());
    }

}
