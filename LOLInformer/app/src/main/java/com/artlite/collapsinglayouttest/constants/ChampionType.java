package com.artlite.collapsinglayouttest.constants;

import com.artlite.collapsinglayouttest.R;

/**
 * Created by dlernatovich on 12/14/15.
 */
public enum ChampionType {
    ASSASIN(R.mipmap.type_assassin, R.string.text_type_assassin),
    FIGHTER(R.mipmap.ic_type_fighter, R.string.text_type_fighter),
    MAGE(R.mipmap.ic_type_mage, R.string.text_type_mage),
    MARKSMAN(R.mipmap.ic_type_marksman, R.string.text_type_marksman),
    SUPPORT(R.mipmap.ic_type_support, R.string.text_type_support),
    TANK(R.mipmap.ic_type_tank, R.string.text_type_tank);

    private final int imageID;
    private final int nameID;

    ChampionType(int imageID, int name) {
        this.imageID = imageID;
        this.nameID = name;
    }

    public int getImageID() {
        return imageID;
    }

    public int getNameID() {
        return nameID;
    }
}
