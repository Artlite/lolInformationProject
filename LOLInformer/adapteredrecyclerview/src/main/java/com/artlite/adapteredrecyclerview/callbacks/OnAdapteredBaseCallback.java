package com.artlite.adapteredrecyclerview.callbacks;


import androidx.annotation.NonNull;

import com.artlite.adapteredrecyclerview.events.AREvent;
import com.artlite.adapteredrecyclerview.models.ARObject;


/**
 * Created by Artli_000 on 24.07.2016.
 */
public interface OnAdapteredBaseCallback<T extends ARObject> {

    /**
     * Method which provide the action when user press on the channel object
     *
     * @param index  current index
     * @param object current object
     */
    void onItemClick(int index, @NonNull final T object);

    /**
     * Method which provide the action when user doing the long press on item
     *
     * @param index  index
     * @param object object
     */
    void onItemLongClick(int index, @NonNull final T object);

    /**
     * Method which provide the action listening
     *
     * @param AREvent event
     * @param index        index
     * @param object       object
     */
    void onActionReceived(@NonNull AREvent AREvent, int index, @NonNull final T object);
}
