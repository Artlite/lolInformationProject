package com.artlite.collapsinglayouttest.ui.activities;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.model.ListItem;
import com.artlite.collapsinglayouttest.providers.ListItemProvider;
import com.artlite.collapsinglayouttest.ui.activities.abs.BaseActivity;
import com.artlite.collapsinglayouttest.ui.adapters.MainRecyclerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.InjectView;


public class MainActivity extends BaseActivity {

    @InjectView(R.id.main_recycler_view)
    RecyclerView mainRecyclerView;
    @InjectView(R.id.main_tab_bar)
    TabLayout mainTabLayout;

    private MainRecyclerAdapter mainRecyclerAdapter;

    @Override
    protected void onCreateActivity() {
        mainRecyclerAdapter = new MainRecyclerAdapter(new ListItemProvider().get());
        mainRecyclerView.setHasFixedSize(true);
        mainRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mainRecyclerView.setAdapter(mainRecyclerAdapter);

        mainTabLayout.addTab(mainTabLayout.newTab().setText("Champions"));
        mainTabLayout.addTab(mainTabLayout.newTab().setText("Items"));
        mainTabLayout.addTab(mainTabLayout.newTab().setText("Tab 3"));
        mainTabLayout.addTab(mainTabLayout.newTab().setText("Tab 4"));
        mainTabLayout.addTab(mainTabLayout.newTab().setText("Tab 5"));
    }

    @Override
    protected int getMenuId() {
        return R.menu.menu_main;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
