package com.artlite.collapsinglayouttest.ui.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.providers.ListItemProvider;
import com.artlite.collapsinglayouttest.ui.activities.abs.BaseActivity;
import com.artlite.collapsinglayouttest.ui.adapters.recycler.ChampionsRecyclerAdapter;
import com.artlite.collapsinglayouttest.ui.adapters.viewpager.MainPagerAdapter;

import butterknife.InjectView;


public class MainActivity extends BaseActivity {

    @InjectView(R.id.main_tab_bar)
    TabLayout mainTabLayout;
    @InjectView(R.id.pager)
    ViewPager mainViewPager;

    private MainPagerAdapter mainPagerAdapter;


    @Override
    protected void onCreateActivity() {
        mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mainViewPager.setAdapter(mainPagerAdapter);
        mainTabLayout.setupWithViewPager(mainViewPager);
    }

    @Override
    protected int getMenuId() {
        return NON_MENU_ID;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
