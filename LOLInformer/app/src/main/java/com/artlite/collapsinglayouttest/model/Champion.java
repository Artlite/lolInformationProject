package com.artlite.collapsinglayouttest.model;

import android.content.Context;

import com.artlite.collapsinglayouttest.ui.custom.AdapteredRecyclerView;
import com.artlite.collapsinglayouttest.ui.views.recycler.ChampionRecycleItem;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class Champion extends AdapteredRecyclerView.BaseObject {

    private static final String DEFAULT_SKIN_URL = "http://ru.leagueoflegends.com/sites/default/files/upload/art/teambuilder-wallpaper.jpg";

    private int iconID;
    private String name;
    private String title;
    private String defaultSkin;

    //TODO Temporary variable (remove this after the implementation)
    private boolean isFinished;

    public Champion() {
        isFinished = false;
        defaultSkin = DEFAULT_SKIN_URL;
    }

    @Override
    public AdapteredRecyclerView.BaseRecyclerItem getRecyclerItem(Context context) {
        return new ChampionRecycleItem(context);
    }

    public static class Builder {
        private int iconID;
        private String name;
        private String title;
        private String defaultSkin;


        //TODO Temporary variable (remove this after the implementation)
        private boolean isFinished;

        public Builder() {
            isFinished = false;
            defaultSkin = DEFAULT_SKIN_URL;
        }

        public Builder addIcon(int iconID) {
            this.iconID = iconID;
            return this;
        }

        public Builder addName(String name) {
            this.name = name;
            return this;
        }

        public Builder setFinished() {
            isFinished = true;
            return this;
        }

        public Builder addTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder addDefaultSkin(String defaultSkin) {
            this.defaultSkin = defaultSkin;
            return this;
        }

        public Champion build() {
            Champion champion = new Champion();
            champion.iconID = this.iconID;
            champion.name = this.name;
            champion.isFinished = this.isFinished;
            champion.defaultSkin = this.defaultSkin;
            return champion;
        }
    }

    public int getIconID() {
        return iconID;
    }

    public void setIconID(int iconID) {
        this.iconID = iconID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDefaultSkin() {
        return defaultSkin;
    }

    public void setDefaultSkin(String defaultSkin) {
        this.defaultSkin = defaultSkin;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }
}
