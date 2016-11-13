package com.artlite.collapsinglayouttest.ui.activities;

import android.view.View;
import android.widget.ImageView;

import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.core.managers.Managers;
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

    protected Champion champion;

    /**
     * method which provide the getting of the current layout ID
     *
     * @return current layout ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_champion_details;
    }

    /**
     * Method which provide the getting of current menu ID
     *
     * @return current menu ID
     */
    @Override
    protected int getMenuId() {
        return NON_MENU_ID;
    }

    /**
     * Method which provide the action when the Activity was created
     */
    @Override
    protected void onCreateActivity() {
        champion = Managers.getTransferManager().getChampion();
        setOnClickListeners(buttonBack);
        updateUI();
    }

    /**
     * Method which provide the updating of the user interface
     */
    protected void updateUI() {
        if (champion != null) {
            championImageView.setBackgroundResource(champion.getIconID());
            nameTextView.setText(champion.getName());
            historyTextView.setText(champion.getHistory());
            typeImageView.setImageResource(champion.getTypeImage());
        }
    }

    /**
     * Method which provide the action for the OnClickListener event
     *
     * @param v current view
     */
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
