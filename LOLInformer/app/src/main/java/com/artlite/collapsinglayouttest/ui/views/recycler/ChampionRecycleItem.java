package com.artlite.collapsinglayouttest.ui.views.recycler;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.model.Champion;
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
        updateUI();
    }

    public void setChampion(Champion champion) {
        this.champion = champion;
        updateUI();
    }

    private void updateUI() {
        if (champion != null) {
            mainTextView.setText(champion.getName());
            Picasso.with(getContext()).load(champion.getIconURL()).placeholder(R.anim.progress_animation).error(R.mipmap.ic_image_download_error).fit().centerInside().into(championImageView);
        }
    }
}
