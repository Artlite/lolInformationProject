package com.artlite.collapsinglayouttest.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.artlite.adapteredrecyclerview.anotations.ARFindViewBy;
import com.artlite.bslibrary.annotations.FindViewBy;
import com.artlite.bslibrary.ui.activity.BSActivity;
import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.model.Champion;
import com.artlite.collapsinglayouttest.ui.activities.abs.BaseActivity;
import com.artlite.collapsinglayouttest.ui.custom.RoundedImageView;
import com.artlite.collapsinglayouttest.ui.views.fonted.FTextView;

import jp.wasabeef.blurry.Blurry;

/**
 * Created by dlernatovich on 7/23/15.
 */
public class ChampionDetailActivity extends BSActivity {

    /**
     * Instance of the {@link String}
     */
    private static final String K_CHAMPION_KEY = "ChampionDetailActivity:Champion";

    /**
     * Instance of the {@link View}
     */
    @FindViewBy(id = R.id.championImageView)
    private RoundedImageView championImageView;

    /**
     * Instance of the {@link View}
     */
    @FindViewBy(id = R.id.textview_name)
    private FTextView nameTextView;

    /**
     * Instance of the {@link View}
     */
    @FindViewBy(id = R.id.textview_history)
    private FTextView historyTextView;

    /**
     * Instance of the {@link View}
     */
    @FindViewBy(id = R.id.button_back)
    private View buttonBack;

    /**
     * Instance of the {@link Champion}
     */
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
     * Method which provide the action when Activity is created
     *
     * @param bundle
     */
    @Override
    protected void onCreateActivity(@Nullable Bundle bundle) {
    }

    /**
     * Method which provide the action when Activity is created (post creation)
     * Use it if you create any callback inside the activity like
     * <b>final |CallbackType| callback = new |CallbackType|</b>
     *
     * @param bundle
     */
    @Override
    protected void onActivityPostCreation(@Nullable Bundle bundle) {
        champion = bundle.getParcelable(K_CHAMPION_KEY);
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

    /**
     * Method which provide the finishing activity
     */
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.fade_in,
                android.R.anim.fade_out);
    }

    /**
     * Method which provide the start activity of the {@link ChampionDetailActivity}
     *
     * @param activity instance of the {@link Activity}
     * @param champion instance of the {@link Champion}
     */
    public static void startActivity(@Nullable Activity activity,
                                     @Nullable Champion champion) {
        if ((activity != null) && (champion != null)) {
            final Intent intent = new Intent(activity, ChampionDetailActivity.class);
            intent.putExtra(K_CHAMPION_KEY, champion);
            activity.startActivity(intent);
            activity.overridePendingTransition(android.R.anim.fade_in,
                    android.R.anim.fade_out);
        }
    }
}
