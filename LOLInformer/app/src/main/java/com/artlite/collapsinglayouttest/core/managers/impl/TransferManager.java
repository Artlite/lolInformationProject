package com.artlite.collapsinglayouttest.core.managers.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.artlite.collapsinglayouttest.core.managers.abs.AbstractManager;
import com.artlite.collapsinglayouttest.model.Champion;

/**
 * Created by Tatyana on 13.11.2016.
 */

public final class TransferManager extends AbstractManager {

    private Champion champion;

    /**
     * Method which provide the {@link Champion} setting
     *
     * @param champion object to set
     */
    public void setChampion(@NonNull final Champion champion) {
        this.champion = champion;
    }

    /**
     * Method which provide the getting of the current {@link Champion}
     *
     * @return current {@link Champion}
     */
    @Nullable
    public Champion getChampion() {
        return champion;
    }
}
