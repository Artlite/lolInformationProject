package com.artlite.adapteredrecyclerview.models;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

//==================================================================================================
//                                         EXAMPLE
//==================================================================================================
//                                         CREATOR
//==================================================================================================
/*
public static final Parcelable.Creator<ARObject> CREATOR = new Parcelable.Creator<ARObject>() {
        @Override
        public ARObject createFromParcel(Parcel source) {
            return new ARObject(source);
        }

        @Override
        public ARObject[] newArray(int size) {
            return new ARObject[size];
        }
    };
 */

/**
 * Created by Artli_000 on 24.07.2016.
 */
public abstract class ARObject implements Parcelable {

    /**
     * Priority enumerator
     */
    public enum Priority {
        MIN,
        VERY_LOW,
        LOW,
        MIDDLE,
        HIGH,
        VERY_HIGH,
        MAX
    }

    /**
     * {@link Priority} for the {@link ARObject}
     */
    protected Priority priority = Priority.MIDDLE;

    /**
     * {@link Integer} value of the index
     */
    protected int index;

    /**
     * {@link Boolean} value value which define if object is selected
     */
    protected boolean isSelected;

    /**
     * {@link String} value of the object ID
     */
    protected String objectId;

    /**
     * Default constructor for {@link ARObject}
     */
    public ARObject() {
        this.priority = Priority.MIDDLE;
        this.isSelected = false;
    }

    /**
     * Constructor which provide the creating of the {@link ARObject} from {@link Parcel}
     *
     * @param parcel instance of {@link Parcel}
     */
    protected ARObject(@NonNull final Parcel parcel) {
        int tmpPriority = parcel.readInt();
        this.priority = tmpPriority == -1 ? null : Priority.values()[tmpPriority];
        this.index = parcel.readInt();
        this.isSelected = parcel.readInt() == 1;
    }

    /**
     * Method which provide the getting of the current recycler item
     *
     * @param context current context
     * @return current instance for the Recycler item
     */
    public abstract ARCell getRecyclerItem(@NonNull final Context context);

    /**
     * Method which provide the priority getting
     *
     * @return
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Method which provide the priority setting
     *
     * @param priority
     */
    public void setPriority(@NonNull final Priority priority) {
        this.priority = priority;
    }

    /**
     * Method which provide the index setting
     *
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Method which provide the index getting
     *
     * @return
     */
    public int getIndex() {
        return index;
    }

    /**
     * Method which provide the setting of the {@link Boolean} value if object is selected
     *
     * @param selected {@link Boolean} value if object is selected
     */
    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    /**
     * Method which provide the getting of the {@link Boolean} value if object is selected
     *
     * @return {@link Boolean} value if object is selected
     */
    public boolean isSelected() {
        return isSelected;
    }

    /**
     * Method which provide the switching of the selected value
     */
    public void switchSelected() {
        setSelected(!isSelected());
    }

    /**
     * Method which provide the describe content for the {@link ARObject}
     *
     * @return described content for the {@link ARObject}
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Method which provide the write {@link ARObject} to {@link Parcel}
     *
     * @param parcel instance of {@link Parcel}
     * @param flags  flags value
     */
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(this.priority == null ? -1 : this.priority.ordinal());
        parcel.writeInt(this.index);
        parcel.writeInt((isSelected() == true) ? 1 : 0);
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
        return "#";
    }

    /**
     * Method which provide the equaling of the objects
     *
     * @param o instance of the {@link Object}
     * @return equaling result
     */
    @Override
    public boolean equals(Object o) {
        return false;
    }

    /**
     * Method which provide the hash code for the object
     *
     * @return hash value
     */
    @Override
    public int hashCode() {
        int result = priority.hashCode();
        result = 31 * result + index;
        result = 31 * result + (isSelected ? 1 : 0);
        result = 31 * result + (objectId != null ? objectId.hashCode() : 0);
        return result;
    }
}
