package com.artlite.collapsinglayouttest.model;

import android.content.Context;

import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.constants.ChampionType;
import com.artlite.collapsinglayouttest.core.application.CurrentApplication;
import com.artlite.collapsinglayouttest.ui.custom.AdapteredRecyclerView;
import com.artlite.collapsinglayouttest.ui.views.recycler.ChampionRecycleItem;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class Champion extends AdapteredRecyclerView.BaseObject {

    private static final String DEFAULT_SKIN_URL = "http://ru.leagueoflegends.com/sites/default/files/upload/art/teambuilder-wallpaper.jpg";

    private int iconID;
    private int name;
    private int title;
    private int history;
    private ChampionType championType;

    //TODO Temporary variable (remove this after the implementation)
    private boolean isFinished;

    public Champion() {
        isFinished = false;
    }

    @Override
    public AdapteredRecyclerView.BaseRecyclerItem getRecyclerItem(Context context) {
        return new ChampionRecycleItem(context);
    }

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

        public Builder addIcon(int iconID) {
            this.iconID = iconID;
            return this;
        }

        public Builder addName(int name) {
            this.name = name;
            return this;
        }

        public Builder setFinished() {
            isFinished = true;
            return this;
        }

        public Builder addTitle(int title) {
            this.title = title;
            return this;
        }

        public Builder addChampionType(ChampionType championType) {
            this.championType = championType;
            return this;
        }

        public Builder addHistory(int history) {
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
        String historyValue = CurrentApplication.getInstance().getStringValue(history);
        if (historyValue.isEmpty() == false) {
            return historyValue.split("\n")[0];
        }
        return "";
    }

}
