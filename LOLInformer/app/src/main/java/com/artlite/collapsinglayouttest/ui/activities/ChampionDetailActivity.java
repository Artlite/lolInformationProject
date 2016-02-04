package com.artlite.collapsinglayouttest.ui.activities;

import android.view.View;
import android.widget.ImageView;

import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.core.application.CurrentApplication;
import com.artlite.collapsinglayouttest.model.Champion;
import com.artlite.collapsinglayouttest.ui.activities.abs.BaseActivity;
import com.artlite.collapsinglayouttest.ui.custom.RoundedImageView;
import com.artlite.collapsinglayouttest.ui.views.fonted.FTextView;

import butterknife.InjectView;

/**
 * Created by dlernatovich on 7/23/15.
 */
public class ChampionDetailActivity extends BaseActivity {

    @InjectView(R.id.championImageView)
    RoundedImageView championImageView;
    @InjectView(R.id.textview_name)
    FTextView nameTextView;
    @InjectView(R.id.textview_history)
    FTextView historyTextView;
    @InjectView(R.id.imageview_type)
    ImageView typeImageView;
    @InjectView(R.id.button_back)
    View buttonBack;

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
        setOnClickListeners(buttonBack);
        updateUI();
    }

    private void updateUI() {
        if (currentChampion != null) {
            championImageView.setBackgroundResource(currentChampion.getIconID());
            nameTextView.setText(currentChampion.getName());
            historyTextView.setText(currentChampion.getHistory());
            typeImageView.setImageResource(currentChampion.getChampionType().getImageID());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_back:
                onBackPressed();
                break;
            default:
                break;

        }
    }
}
