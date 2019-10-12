package com.artlite.collapsinglayouttest.ui.adapters.viewpager;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.artlite.collapsinglayouttest.factories.FragmentFactory;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {

    /**
     * Default constructor
     *
     * @param fm instance of the {@link FragmentManager}
     */
    public MainPagerAdapter(@NonNull final FragmentManager fm) {
        super(fm);
    }

    /**
     * Return the Fragment associated with a specified position.
     */
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = FragmentFactory.getFragmentByIndex(position);
        return fragment;
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return FragmentFactory.FRAGMENTS_COUNT;
    }

    /**
     * This method may be called by the ViewPager to obtain a title string
     * to describe the specified page. This method may return null
     * indicating no title for this page. The default implementation returns
     * null.
     *
     * @param position The position of the title requested
     * @return A title for the requested page
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return FragmentFactory.getTitleByIndex(position);
    }
}
