package com.artlite.collapsinglayouttest.ui.views.recycler;

import android.content.Context;
import android.widget.ImageView;

import com.artlite.adapteredrecyclerview.anotations.ARFindViewBy;
import com.artlite.adapteredrecyclerview.models.ARCell;
import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.model.Champion;
import com.artlite.collapsinglayouttest.ui.views.fonted.FTextView;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class ChampionRecycleItem extends ARCell<Champion> {

    @ARFindViewBy(id = R.id.textview_main)
    private FTextView mainTextView;
    @ARFindViewBy(id = R.id.imageview_champion)
    private ImageView championImageView;
    @ARFindViewBy(id = R.id.imageview_type)
    private ImageView typeImageView;
    @ARFindViewBy(id = R.id.textview_history)
    private FTextView historyTextView;

    private Champion champion;

    public ChampionRecycleItem(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.recycle_item_main;
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
    protected void updateUI() {
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
