package com.artlite.collapsinglayouttest.model;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class Champion {
    private String iconURL;
    private String name;

    public static class Builder {
        private String iconURL;
        private String name;

        public Builder addIcon(String url) {
            this.iconURL = url;
            return this;
        }

        public Builder addName(String name) {
            this.name = name;
            return this;
        }

        public Champion build() {
            Champion champion = new Champion();
            champion.iconURL = this.iconURL;
            champion.name = this.name;
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
}
