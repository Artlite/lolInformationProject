package com.artlite.collapsinglayouttest.ui.views.recycler;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.core.CurrentApplication;
import com.artlite.collapsinglayouttest.model.Champion;
import com.artlite.collapsinglayouttest.ui.activities.ChampionDetailActivity;
import com.artlite.collapsinglayouttest.ui.views.abs.BaseView;
import com.squareup.picasso.Picasso;

import butterknife.InjectView;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class ChampionRecycleItem extends BaseView {

    @InjectView(R.id.textview_main)
    public TextView mainTextView;
    @InjectView(R.id.imageview_champion)
    ImageView championImageView;

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
     * Method which provide the set champion to the current ChampionRecycleItem
     *
     * @param champion current champion object
     */
    public void setChampion(Champion champion) {
        this.champion = champion;
        updateUI();
    }

    /**
     * Method which provide the updating of the UI
     */
    private void updateUI() {
        if (champion != null) {
            mainTextView.setText(champion.getName());
            Picasso.with(getContext()).load(champion.getIconURL()).placeholder(R.anim.progress_animation).error(R.drawable.icon_no_image).fit().centerInside().into(championImageView);
        }
    }

    @Override
    public void onClick(View v) {
        CurrentApplication.getInstance().setCurrentChampion(champion);
        startActivity(ChampionDetailActivity.class);
    }
}
