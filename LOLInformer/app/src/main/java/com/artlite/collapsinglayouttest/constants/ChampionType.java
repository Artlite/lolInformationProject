package com.artlite.collapsinglayouttest.constants;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import com.artlite.collapsinglayouttest.R;

/**
 * Created by dlernatovich on 12/14/15.
 */
public enum ChampionType {
    ASSASSIN(R.mipmap.type_assassin, R.string.text_type_assassin),
    FIGHTER(R.mipmap.ic_type_fighter, R.string.text_type_fighter),
    MAGE(R.mipmap.ic_type_mage, R.string.text_type_mage),
    MARKSMAN(R.mipmap.ic_type_marksman, R.string.text_type_marksman),
    SUPPORT(R.mipmap.ic_type_support, R.string.text_type_support),
    TANK(R.mipmap.ic_type_tank, R.string.text_type_tank);

    private final int imageID;
    private final int nameID;

    /**
     * Default constructor
     *
     * @param imageID image res
     * @param name    name res
     */
    ChampionType(@DrawableRes int imageID, @StringRes int name) {
        this.imageID = imageID;
        this.nameID = name;
    }

    /**
     * Method which provide the getting of the image ID
     *
     * @return
     */
    @DrawableRes
    public int getImageID() {
        return imageID;
    }

    /**
     * Method which provide the getting of the type name
     *
     * @return type name
     */
    @StringRes
    public int getNameID() {
        return nameID;
    }
}
