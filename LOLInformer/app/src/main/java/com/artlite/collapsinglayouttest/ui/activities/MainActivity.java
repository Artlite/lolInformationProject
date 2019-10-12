package com.artlite.collapsinglayouttest.ui.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.artlite.bslibrary.annotations.FindViewBy;
import com.artlite.bslibrary.ui.activity.BSActivity;
import com.artlite.bslibrary.ui.custom.BSViewPagerNonScroll;
import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.ui.adapters.viewpager.MainPagerAdapter;
import com.artlite.collapsinglayouttest.ui.views.bar.ViewBottomBar;


public class MainActivity extends BSActivity implements ViewBottomBar.ViewBottomBarDelegate {

    /**
     * Instance of the {@link ViewPager}
     */
    @FindViewBy(id = R.id.pager)
    private BSViewPagerNonScroll viewPager;

    /**
     * Instance of the {@link ViewBottomBar}
     */
    @FindViewBy(id = R.id.view_bottom_bar)
    private ViewBottomBar viewBottomBar;

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
        viewPager.setAdapter(mainPagerAdapter);
        viewBottomBar.delegate = this;
    }

    /**
     * Method which provide the action when the view did select
     *
     * @param view  instance of the {@link ViewBottomBar}
     * @param index instance of the {@link Integer}
     */
    @Override
    public void viewBottomDidSelect(@NonNull ViewBottomBar view, int index) {
        if (index != -1) {
            this.viewPager.setCurrentItem(index);
        }
    }
}
