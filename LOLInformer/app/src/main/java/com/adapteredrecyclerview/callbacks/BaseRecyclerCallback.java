package com.adapteredrecyclerview.callbacks;

import android.support.annotation.NonNull;

import com.adapteredrecyclerview.events.RecycleEvent;
import com.adapteredrecyclerview.models.BaseObject;


/**
 * Created by Artli_000 on 24.07.2016.
 */
public interface BaseRecyclerCallback<T extends BaseObject> {

    /**
     * Method which provide the action when user press on the channel object
     *
     * @param index  current index
     * @param object current object
     */
    void onItemClick(int index, @NonNull final T object);

    /**
     * Method which provide the action listening
     *
     * @param recycleEvent event
     * @param index        index
     * @param object       object
     */
    void onActionReceived(@NonNull RecycleEvent recycleEvent, int index, @NonNull final T object);
}
