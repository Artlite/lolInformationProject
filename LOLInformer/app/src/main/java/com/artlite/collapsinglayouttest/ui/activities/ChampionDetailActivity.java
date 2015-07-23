package com.artlite.collapsinglayouttest.ui.activities;

import android.widget.ImageView;

import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.core.CurrentApplication;
import com.artlite.collapsinglayouttest.model.Champion;
import com.artlite.collapsinglayouttest.ui.activities.abs.BaseActivity;
import com.squareup.picasso.Picasso;

import butterknife.InjectView;

/**
 * Created by dlernatovich on 7/23/15.
 */
public class ChampionDetailActivity extends BaseActivity {

    @InjectView(R.id.championImageView)
    ImageView championImageView;

    private Champion currentChampion;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_champion_details;
    }

    @Override
    protected int getMenuId() {
        return NON_MENU_ID;
    }

    @Override
    protected void onCreateActivity() {
        currentChampion = CurrentApplication.getInstance().getCurrentChampion();
        updateUI();
    }

    private void updateUI() {
        if (currentChampion != null) {
            Picasso.with(getBaseContext()).load(currentChampion.getDefaultSkin()).placeholder(R.anim.progress_animation).error(R.drawable.icon_no_image).fit().centerInside().into(championImageView);
        }
    }
}
