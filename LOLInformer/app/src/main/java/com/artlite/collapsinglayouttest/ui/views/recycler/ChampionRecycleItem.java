package com.artlite.collapsinglayouttest.ui.views.recycler;

import android.content.Context;
import android.widget.ImageView;

import com.artlite.adapteredrecyclerview.models.BaseRecyclerItem;
import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.model.Champion;
import com.artlite.collapsinglayouttest.ui.views.fonted.FTextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class ChampionRecycleItem extends BaseRecyclerItem<Champion> {

    @InjectView(R.id.textview_main)
    FTextView mainTextView;
    @InjectView(R.id.imageview_champion)
    ImageView championImageView;
    @InjectView(R.id.imageview_type)
    ImageView typeImageView;
    @InjectView(R.id.textview_history)
    FTextView historyTextView;

    private Champion champion;

    public ChampionRecycleItem(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.recycle_item_main;
    }

    @Override
    protected void onLinkInterface() {
        ButterKnife.inject(this);
    }

    @Override
    protected int getClickedID() {
        return R.id.conten;
    }

    @Override
    protected void onCreateView() {
        updateUI();
    }

    /**
     * Method which provide the updating of the UI
     */
    private void updateUI() {
        if (champion != null) {
            mainTextView.setText(champion.getName());
            historyTextView.setText(champion.getShortHistory());
            championImageView.setImageResource(champion.getIconID());
            typeImageView.setImageResource(champion.getTypeImage());
        }
    }

    /**
     * Method which provide the setting up for the current recycler item
     *
     * @param baseObject current object
     */
    @Override
    public void setUp(Champion baseObject) {
        this.champion = baseObject;
        updateUI();
    }
}
