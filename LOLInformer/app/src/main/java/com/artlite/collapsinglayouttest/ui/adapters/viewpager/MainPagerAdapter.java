package com.artlite.collapsinglayouttest.ui.adapters.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.artlite.collapsinglayouttest.factories.FragmentFactory;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = FragmentFactory.getFragmentByIndex(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return FragmentFactory.FRAGMENTS_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return FragmentFactory.getTitleByIndex(position);
    }
}
