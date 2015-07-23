package com.artlite.collapsinglayouttest.model;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class Champion {
    private String iconURL;
    private String name;
    private String title;
    private String defaultSkin;

    //TODO Temporary variable (remove this after the implementation)
    private boolean isFinished;

    public Champion() {
        isFinished = false;
    }

    public static class Builder {
        private String iconURL;
        private String name;
        private String title;
        private String defaultSkin;


        //TODO Temporary variable (remove this after the implementation)
        private boolean isFinished;

        public Builder addIcon(String url) {
            this.iconURL = url;
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
            champion.iconURL = this.iconURL;
            champion.name = this.name;
            champion.isFinished = this.isFinished;
            champion.defaultSkin = this.defaultSkin;
            return champion;
        }
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
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
