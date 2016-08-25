package com.artlite.adapteredrecyclerview.models;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by Artli_000 on 24.07.2016.
 */
public abstract class BaseObject {

    /**
     * Priority enumerator
     */
    public enum Priority {
        LOW,
        MIDDLE,
        HIGHT
    }

    private Priority priority = Priority.MIDDLE;
    private int index;

    /**
     * Method which provide the getting of the current recycler item
     *
     * @param context current context
     * @return current instance for the Recycler item
     */
    public abstract BaseRecyclerItem getRecyclerItem(@NonNull Context context);

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
    public void setPriority(Priority priority) {
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
}
