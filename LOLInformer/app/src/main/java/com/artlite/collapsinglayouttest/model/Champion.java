package com.artlite.collapsinglayouttest.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.Log;

import com.artlite.adapteredrecyclerview.helpers.ARInjector;
import com.artlite.adapteredrecyclerview.models.ARCell;
import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.constants.ChampionType;
import com.artlite.collapsinglayouttest.model.abs.AbstractModel;
import com.artlite.collapsinglayouttest.ui.views.recycler.ChampionRecycleItem;

import java.lang.ref.WeakReference;

/**
 * Created by dlernatovich on 7/22/15.
 */
@SuppressLint("ParcelCreator")
public class Champion extends AbstractModel {

    private static final String TAG = Champion.class.getSimpleName();

    private static final String DEFAULT_SKIN_URL = "http://ru.leagueoflegends.com/sites/default/files/upload/art/teambuilder-wallpaper.jpg";

    @DrawableRes
    private int iconID;
    @StringRes
    private int name;
    @StringRes
    private int title;
    @StringRes
    private int history;
    private ChampionType championType;

    private WeakReference<Context> contextReference;

    //TODO Temporary variable (remove this after the implementation)
    private boolean isFinished;

    public Champion() {
        isFinished = false;
    }

    @Override
    public ARCell getRecyclerItem(Context context) {
        this.contextReference = new WeakReference<>(context);
        ARInjector.inject(this, context);
        return new ChampionRecycleItem(context);
    }

    /**
     * Method which provide the getting of the short history of the {@link Champion}
     *
     * @param history history id
     * @return history text
     */
    @Nullable
    public static String getShortHistory(@StringRes int history) {
        String historyValue = getText(history);
        if (historyValue.isEmpty() == false) {
            return historyValue.split("\n")[0];
        }
        return "";
    }

    /**
     * Builder
     */
    public static class Builder {
        private int iconID;
        private int name;
        private int title;
        private int history;
        private ChampionType championType;


        //TODO Temporary variable (remove this after the implementation)
        private boolean isFinished;

        public Builder() {
            isFinished = false;
            championType = ChampionType.FIGHTER;
            history = R.string.text_empty;
            name = R.string.text_empty;
            title = R.string.text_empty;
        }

        public Builder addIcon(@DrawableRes int iconID) {
            this.iconID = iconID;
            return this;
        }

        public Builder addName(@StringRes int name) {
            this.name = name;
            return this;
        }

        public Builder setFinished() {
            isFinished = true;
            return this;
        }

        public Builder addTitle(@StringRes int title) {
            this.title = title;
            return this;
        }

        public Builder addChampionType(@NonNull ChampionType championType) {
            this.championType = championType;
            return this;
        }

        public Builder addHistory(@StringRes int history) {
            this.history = history;
            return this;
        }

        public Champion build() {
            Champion champion = new Champion();
            champion.iconID = this.iconID;
            champion.name = this.name;
            champion.isFinished = this.isFinished;
            champion.championType = this.championType;
            champion.history = this.history;
            return champion;
        }
    }

    public static String getDefaultSkinUrl() {
        return DEFAULT_SKIN_URL;
    }

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public ChampionType getChampionType() {
        return championType;
    }

    /**
     * Method which provide the getting of the type image ID
     *
     * @return type image ID
     * @see ChampionType
     */
    @DrawableRes
    public int getTypeImage() {
        return championType.getImageID();
    }

    public void setChampionType(ChampionType championType) {
        this.championType = championType;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    public String getShortHistory() {
        return getShortHistory(history);
    }

    /**
     * Should be implemented by the adapter of the RecyclerView.
     * Provides a text to be shown by the bubble, when RecyclerView reaches
     * the position. Usually the first letter of the text shown by the item
     * at this position.
     *
     * @param position Position of the row in adapter
     * @return The text to be shown in the bubble
     * @warning This method should be overriding
     * @see com.futuremind.recyclerviewfastscroll.FastScroller
     */
    public String getSectionTitle(int position) {
        try {
            return this.getText(this.name).substring(0, 1);
        } catch (Exception ex) {
            Log.e(TAG, "getSectionTitle: ", ex);
        }
        return "#";
    }
}
