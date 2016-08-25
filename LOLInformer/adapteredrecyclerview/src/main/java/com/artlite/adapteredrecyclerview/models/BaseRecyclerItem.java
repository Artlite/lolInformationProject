package com.artlite.adapteredrecyclerview.models;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredBaseCallback;
import com.artlite.adapteredrecyclerview.events.RecycleEvent;
import com.artlite.adapteredrecyclerview.ui.views.BaseRecyclerView;

import java.lang.ref.WeakReference;

/**
 * Created by Artli_000 on 24.07.2016.
 */
public abstract class BaseRecyclerItem<T extends BaseObject> extends BaseRecyclerView {

    protected WeakReference<OnAdapteredBaseCallback> callbackReference;
    protected WeakReference<T> objectReference;
    protected int index;

    public BaseRecyclerItem(Context context) {
        super(context);
    }

    /**
     * Method which provide the setting up for the current recycler item
     *
     * @param baseObject current object
     */
    public abstract void setUp(@NonNull T baseObject);

    /**
     * Method which provide the listener initializing
     */
    @Override
    protected void onCallbacksInitialize() {
        ViewGroup view = (ViewGroup) findViewById(getClickedID());
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callbackReference != null
                            && objectReference != null
                            && objectReference.get() != null
                            && callbackReference.get() != null) {
                        T object = objectReference.get();
                        callbackReference.get().onItemClick(index, object);
                    }
                }
            });
        }
    }

    /**
     * Method which provide the setting of the object inside the view
     *
     * @param object current object
     */
    public void setObject(@NonNull T object) {
        index = object.getIndex();
        objectReference = new WeakReference<T>(object);
    }

    /**
     * Method which provide the setting of the item action listener
     *
     * @param itemActionListener
     */
    public void setItemActionListener(OnAdapteredBaseCallback itemActionListener) {
        this.callbackReference = new WeakReference<OnAdapteredBaseCallback>(itemActionListener);
    }

    /**
     * Method which provide the event sending
     *
     * @param recycleEvent recycler event
     */
    protected void sendEvent(@NonNull RecycleEvent recycleEvent) {
        if (callbackReference != null
                && callbackReference.get() != null
                && objectReference != null
                && objectReference.get() != null) {
            callbackReference.get().onActionReceived(recycleEvent, index, objectReference.get());
        }
    }
}
