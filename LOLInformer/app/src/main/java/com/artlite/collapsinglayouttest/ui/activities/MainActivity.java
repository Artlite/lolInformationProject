package com.artlite.collapsinglayouttest.ui.activities;

import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.artlite.adapteredrecyclerview.anotations.ARFindViewBy;
import com.artlite.bslibrary.annotations.FindViewBy;
import com.artlite.bslibrary.ui.activity.BSActivity;
import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.ui.activities.abs.BaseActivity;
import com.artlite.collapsinglayouttest.ui.adapters.viewpager.MainPagerAdapter;
import com.artlite.collapsinglayouttest.ui.views.fonted.FTabLayout;


public class MainActivity extends BSActivity {

    /**
     * Instance of the {@link ViewPager}
     */
    @FindViewBy(id = R.id.pager)
    private ViewPager mainViewPager;

    /**
     * Instance of the {@link MainPagerAdapter}
     */
    protected MainPagerAdapter mainPagerAdapter;


    /**
     * Method which provide the getting of the layout ID for the current Activity
     *
     * @return layout ID for the current Activity
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
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
        mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mainViewPager.setAdapter(mainPagerAdapter);
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
