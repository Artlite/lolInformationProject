package com.artlite.collapsinglayouttest.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
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
public class Champion extends AbstractModel implements Parcelable {

    /**
     * {@link String} constants of the TAG
     */
    private static final String TAG = Champion.class.getSimpleName();

    /**
     * {@link String} constants of the default skin URL
     */
    private static final String DEFAULT_SKIN_URL = "http://ru.leagueoflegends.com/sites/default/" +
            "files/upload/art/teambuilder-wallpaper.jpg";

    /**
     * {@link Integer} value of the icon id
     */
    @DrawableRes
    private int iconID;

    /**
     * {@link Integer} value of the name
     */
    @StringRes
    private int name;

    /**
     * {@link Integer} value of the title
     */
    @StringRes
    private int title;

    /**
     * {@link Integer} value of the history
     */
    @StringRes
    private int history;

    /**
     * Instance of the {@link ChampionType}
     */
    private ChampionType championType;

    /**
     * Instance of the {@link WeakReference}
     */
    private WeakReference<Context> contextReference;

    /**
     * {@link Boolean} value if the is finished implementation
     */
    //TODO Temporary variable (remove this after the implementation)
    private boolean isFinished;

    /**
     * Default constructor
     */
    public Champion() {
        isFinished = false;
    }

    /**
     * Method which provide the getting of the current recycler item
     *
     * @param context current context
     * @return current instance for the Recycler item
     */
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
     * Method which provide the equaling functionality
     *
     * @param object instance of the {@link Object}
     * @return equaling result
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Champion champion = (Champion) object;
        if (iconID != champion.iconID) return false;
        if (name != champion.name) return false;
        if (title != champion.title) return false;
        if (history != champion.history) return false;
        return championType == champion.championType;
    }

    /**
     * Method which provide the hash code for the object
     *
     * @return hash code value
     */
    @Override
    public int hashCode() {
        int result = iconID;
        result = 31 * result + name;
        result = 31 * result + title;
        result = 31 * result + history;
        result = 31 * result + championType.hashCode();
        return result;
    }

    /**
     * Builder
     */
    public static class Builder {

        /**
         * Instance of the {@link Champion}
         */
        private Champion champion = new Champion();

        /**
         * {@link Boolean} value if the is finished implementation
         */
        //TODO Temporary variable (remove this after the implementation)
        private boolean isFinished;

        /**
         * Default constructor
         */
        public Builder() {
            isFinished = false;
            champion.championType = ChampionType.FIGHTER;
            champion.history = R.string.text_empty;
            champion.name = R.string.text_empty;
            champion.title = R.string.text_empty;
        }

        /**
         * Method which provide the add object
         *
         * @param iconID instance of the {@link Object}
         * @return instance of the {@link Builder}
         */
        public Builder addIcon(@DrawableRes int iconID) {
            champion.iconID = iconID;
            return this;
        }

        /**
         * Method which provide the add object
         *
         * @param name instance of the {@link Object}
         * @return instance of the {@link Builder}
         */
        public Builder addName(@StringRes int name) {
            champion.name = name;
            return this;
        }

        /**
         * Method which provide the set object
         *
         * @return instance of the {@link Builder}
         */
        public Builder setFinished() {
            isFinished = true;
            return this;
        }

        /**
         * Method which provide the add object
         *
         * @param title instance of the {@link Object}
         * @return instance of the {@link Builder}
         */
        public Builder addTitle(@StringRes int title) {
            champion.title = title;
            return this;
        }

        /**
         * Method which provide the add object
         *
         * @param championType instance of the {@link Object}
         * @return instance of the {@link Builder}
         */
        public Builder addChampionType(@NonNull ChampionType championType) {
            champion.championType = championType;
            return this;
        }

        /**
         * Method which provide the add object
         *
         * @param history instance of the {@link Object}
         * @return instance of the {@link Builder}
         */
        public Builder addHistory(@StringRes int history) {
            champion.history = history;
            return this;
        }

        /**
         * Method which provide the build functionality
         *
         * @return instance of the {@link Champion}
         */
        public Champion build() {
            return champion;
        }
    }

    /**
     * Method which provide the getting {@link Object}
     *
     * @return instance of the {@link Object}
     */
    public static String getDefaultSkinUrl() {
        return DEFAULT_SKIN_URL;
    }

    /**
     * Method which provide the getting {@link Object}
     *
     * @return instance of the {@link Object}
     */
    public int getIconID() {
        return iconID;
    }

    /**
     * Method which provide the add object
     *
     * @param iconID instance of the {@link Object}
     * @return instance of the {@link Builder}
     */
    public void setIconID(int iconID) {
        this.iconID = iconID;
    }

    /**
     * Method which provide the getting {@link Object}
     *
     * @return instance of the {@link Object}
     */
    public int getName() {
        return name;
    }

    /**
     * Method which provide the add object
     *
     * @param name instance of the {@link Object}
     * @return instance of the {@link Builder}
     */
    public void setName(int name) {
        this.name = name;
    }

    /**
     * Method which provide the getting {@link Object}
     *
     * @return instance of the {@link Object}
     */
    public int getTitle() {
        return title;
    }

    /**
     * Method which provide the add object
     *
     * @param title instance of the {@link Object}
     * @return instance of the {@link Builder}
     */
    public void setTitle(int title) {
        this.title = title;
    }

    /**
     * Method which provide the getting {@link Object}
     *
     * @return instance of the {@link Object}
     */
    public int getHistory() {
        return history;
    }

    /**
     * Method which provide the add object
     *
     * @param history instance of the {@link Object}
     * @return instance of the {@link Builder}
     */
    public void setHistory(int history) {
        this.history = history;
    }

    /**
     * Method which provide the getting {@link Object}
     *
     * @return instance of the {@link Object}
     */
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

    /**
     * Method which provide the add object
     *
     * @param championType instance of the {@link Object}
     * @return instance of the {@link Builder}
     */
    public void setChampionType(ChampionType championType) {
        this.championType = championType;
    }

    /**
     * Method which provide the getting {@link Object}
     *
     * @return instance of the {@link Object}
     */
    public boolean isFinished() {
        return isFinished;
    }

    /**
     * Method which provide the add object
     *
     * @param isFinished instance of the {@link Object}
     * @return instance of the {@link Builder}
     */
    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    /**
     * Method which provide the getting {@link Object}
     *
     * @return instance of the {@link Object}
     */
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


    /**
     * Method which provide the describe content
     *
     * @return instance of the {@link Integer}
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Method which provide the write to parcel
     *
     * @param dest  instance of the {@link Parcel}
     * @param flags flags value
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.iconID);
        dest.writeInt(this.name);
        dest.writeInt(this.title);
        dest.writeInt(this.history);
        dest.writeInt(this.championType == null ? -1
                : this.championType.ordinal());
        dest.writeByte(this.isFinished ? (byte) 1 : (byte) 0);
    }

    /**
     * Constructor which provide to create the {@link Champion} from parcel
     *
     * @param parcel instance of the {@link Parcel}
     */
    protected Champion(Parcel parcel) {
        super(parcel);
        this.iconID = parcel.readInt();
        this.name = parcel.readInt();
        this.title = parcel.readInt();
        this.history = parcel.readInt();
        int tmpChampionType = parcel.readInt();
        this.championType = tmpChampionType == -1 ? null
                : ChampionType.values()[tmpChampionType];
        this.isFinished = parcel.readByte() != 0;
    }

    /**
     * Instance of the {@link Creator}
     */
    public static final Creator<Champion> CREATOR = new Creator<Champion>() {
        @Override
        public Champion createFromParcel(Parcel source) {
            return new Champion(source);
        }

        @Override
        public Champion[] newArray(int size) {
            return new Champion[size];
        }
    };
}
