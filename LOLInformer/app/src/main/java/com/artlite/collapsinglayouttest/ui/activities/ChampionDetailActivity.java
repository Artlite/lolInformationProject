package com.artlite.collapsinglayouttest.ui.activities;

import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.artlite.adapteredrecyclerview.anotations.ARFindViewBy;
import com.artlite.bslibrary.annotations.FindViewBy;
import com.artlite.bslibrary.ui.activity.BSActivity;
import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.core.managers.Managers;
import com.artlite.collapsinglayouttest.model.Champion;
import com.artlite.collapsinglayouttest.ui.activities.abs.BaseActivity;
import com.artlite.collapsinglayouttest.ui.custom.RoundedImageView;
import com.artlite.collapsinglayouttest.ui.views.fonted.FTextView;

/**
 * Created by dlernatovich on 7/23/15.
 */
public class ChampionDetailActivity extends BSActivity {

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
    @FindViewBy(id = R.id.imageview_type)
    private ImageView typeImageView;

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

    /**
     * Method which provide the getting of the start enter animation
     *
     * @return id for start enter animation
     */
    @Override
    @AnimRes
    protected int getStartEnterAnim() {
        return android.R.anim.fade_in;
    }

    /**
     * Method which provide the getting of the start end animation
     *
     * @return id for start end animation
     */
    @Override
    @AnimRes
    protected int getStartEndAnim() {
        return android.R.anim.fade_out;
    }

    /**
     * Method which provide the getting of the finish start animation
     *
     * @return id for start end animation
     */
    @Override
    @AnimRes
    protected int getFinishStartAnim() {
        return android.R.anim.fade_in;
    }

    /**
     * Method which provide the getting of the finish start animation
     *
     * @return id for start end animation
     */
    @Override
    @AnimRes
    protected int getFinishEndAnim() {
        return android.R.anim.fade_out;
    }

    /**
     * Method which provide the defining if need to override of the transition animation
     *
     * @return defining results
     */
    @Override
    protected boolean isOverrideTransitionAnimation() {
        return true;
    }
}
