package com.artlite.adapteredrecyclerview.models;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

//==================================================================================================
//                                         EXAMPLE
//==================================================================================================
//                                         CREATOR
//==================================================================================================
/*
public static final Parcelable.Creator<BaseObject> CREATOR = new Parcelable.Creator<BaseObject>() {
        @Override
        public BaseObject createFromParcel(Parcel source) {
            return new BaseObject(source);
        }

        @Override
        public BaseObject[] newArray(int size) {
            return new BaseObject[size];
        }
    };
 */

/**
 * Created by Artli_000 on 24.07.2016.
 */
public abstract class BaseObject implements Parcelable {

    /**
     * Priority enumerator
     */
    public enum Priority {
        LOW,
        MIDDLE,
        HIGH
    }

    private Priority priority = Priority.MIDDLE;
    private int index;

    /**
     * Default constructor for {@link BaseObject}
     */
    public BaseObject() {
        this.priority = Priority.MIDDLE;
    }

    /**
     * Constructor which provide the creating of the {@link BaseObject} from {@link Parcel}
     *
     * @param parcel instance of {@link Parcel}
     */
    protected BaseObject(@NonNull final Parcel parcel) {
        int tmpPriority = parcel.readInt();
        this.priority = tmpPriority == -1 ? null : Priority.values()[tmpPriority];
        this.index = parcel.readInt();
    }

    /**
     * Method which provide the getting of the current recycler item
     *
     * @param context current context
     * @return current instance for the Recycler item
     */
    public abstract BaseRecyclerItem getRecyclerItem(@NonNull final Context context);

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
     * Method which provide the describe content for the {@link BaseObject}
     *
     * @return described content for the {@link BaseObject}
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Method which provide the write {@link BaseObject} to {@link Parcel}
     *
     * @param parcel instance of {@link Parcel}
     * @param flags  flags value
     */
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(this.priority == null ? -1 : this.priority.ordinal());
        parcel.writeInt(this.index);
    }

}
