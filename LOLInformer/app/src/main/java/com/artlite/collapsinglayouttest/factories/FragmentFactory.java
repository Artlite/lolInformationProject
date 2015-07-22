package com.artlite.collapsinglayouttest.factories;

import com.artlite.collapsinglayouttest.ui.fragments.AboutFragment;
import com.artlite.collapsinglayouttest.ui.fragments.abs.BaseFragment;
import com.artlite.collapsinglayouttest.ui.fragments.ChampionListFragment;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class FragmentFactory {
    public static final int FRAGMENTS_COUNT = 2;

    public static BaseFragment getFragmentByIndex(int index) {
        switch (index) {
            case 0:
                return new ChampionListFragment();
            case 1:
                return new AboutFragment();
            default:
                return new ChampionListFragment();
        }
    }

    public static String getTitleByIndex(int index) {
        switch (index) {
            case 0:
                return "Champion list";
            case 1:
                return "About";
            default:
                return "None";
        }
    }
}
