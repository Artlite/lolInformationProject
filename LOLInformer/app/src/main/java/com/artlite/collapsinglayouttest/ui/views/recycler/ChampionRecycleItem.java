package com.artlite.collapsinglayouttest.ui.views.recycler;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.core.application.CurrentApplication;
import com.artlite.collapsinglayouttest.model.Champion;
import com.artlite.collapsinglayouttest.ui.activities.ChampionDetailActivity;
import com.artlite.collapsinglayouttest.ui.custom.AdapteredRecyclerView;
import com.artlite.collapsinglayouttest.ui.views.fonted.FTextView;

import butterknife.InjectView;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class ChampionRecycleItem extends AdapteredRecyclerView.BaseRecyclerItem<Champion> {

    @InjectView(R.id.textview_main)
    FTextView mainTextView;
    @InjectView(R.id.imageview_champion)
    ImageView championImageView;
    @InjectView(R.id.imageview_type)
    ImageView typeImageView;
    @InjectView(R.id.textview_history)
    FTextView hidtoryTextView;

    private Champion champion;

    public ChampionRecycleItem(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.recycle_item_main;
    }

    @Override
    protected void onCreateView() {
        setOnClickListeners(baseView);
        updateUI();
    }

    /**
     * Method which provide the updating of the UI
     */
    private void updateUI() {
        if (champion != null) {
            mainTextView.setText(champion.getName());
            hidtoryTextView.setText(champion.getShortHistory());
            championImageView.setImageResource(champion.getIconID());
            typeImageView.setImageResource(champion.getChampionType().getImageID());
        }
    }

    @Override
    public void onClick(View v) {
        CurrentApplication.getInstance().setCurrentChampion(champion);
        startActivity(ChampionDetailActivity.class);
    }

    @Override
    public void setUp(Champion baseObject) {
        this.champion = baseObject;
        updateUI();
    }
}
