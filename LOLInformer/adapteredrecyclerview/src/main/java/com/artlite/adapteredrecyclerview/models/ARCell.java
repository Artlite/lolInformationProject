package com.artlite.adapteredrecyclerview.models;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredBaseCallback;
import com.artlite.adapteredrecyclerview.events.AREvent;
import com.artlite.adapteredrecyclerview.ui.views.ARBaseCell;

import java.lang.ref.WeakReference;

/**
 * Created by Artli_000 on 24.07.2016.
 */
public abstract class ARCell<T extends ARObject> extends ARBaseCell {

    /**
     * Instance of the {@link WeakReference}
     */
    protected WeakReference<OnAdapteredBaseCallback> callbackReference;

    /**
     * Instance of the {@link WeakReference}
     */
    protected WeakReference<T> objectReference;

    /**
     * {@link Integer} value of the index
     */
    protected int index;

    /**
     * Default constructor
     *
     * @param context context to set
     */
    public ARCell(@NonNull final Context context) {
        super(context);
    }

    /**
     * Method which provide the setting up for the current recycler item
     *
     * @param baseObject current object
     */
    public abstract void setUp(@NonNull final T baseObject);

    /**
     * Method which provide the listener initializing
     */
    @Override
    protected void onCallbacksInitialize() {
        View view = findViewById(getClickedID());
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick();
                }
            });
            view.setOnLongClickListener(new OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onItemLongClick();
                    return true;
                }
            });
        }
    }

    /**
     * Method which provide the on item click action
     */
    protected final void onItemClick() {
        final T object = getObject();
        final OnAdapteredBaseCallback callback = getCallback();
        if (object != null) {
            onItemClick(object);
            if (callback != null) {
                callback.onItemClick(index, object);
            }
        }
    }

    /**
     * Method which provide the functional of the object management
     * (just use for override)
     *
     * @param object object instance
     */
    protected void onItemClick(@NonNull final T object) {
        // TODO: Override this if needed
    }

    /**
     * Method which provide the item long click functional
     */
    protected final void onItemLongClick() {
        final T object = getObject();
        final OnAdapteredBaseCallback callback = getCallback();
        if (object != null) {
            onItemLongClick(object);
            if (callback != null) {
                callback.onItemLongClick(index, object);
            }
        }
    }

    /**
     * Method which provide the item long click functional
     * (just use for override)
     *
     * @param object object instance
     */
    protected final void onItemLongClick(@NonNull final T object) {
        // TODO: Override this if needed
    }

    /**
     * Method which provide the setting of the object inside the view
     *
     * @param object current object
     */
    public void setObject(@NonNull final T object) {
        index = object.getIndex();
        objectReference = new WeakReference<T>(object);
    }

    /**
     * Method which provide the getting of the instance of the {@link Object}
     *
     * @return instance of the {@link Object}
     */
    @Nullable
    public T getObject() {
        return (objectReference == null)
                ? null : objectReference.get();
    }

    /**
     * Method which provide the setting of the item action listener
     *
     * @param callback
     * @deprecated user {@link #setAdapteredCallback(OnAdapteredBaseCallback)} instead of it
     */
    @Deprecated
    public void setItemActionListener(@Nullable final OnAdapteredBaseCallback callback) {
        setAdapteredCallback(callback);
    }

    /**
     * Method which provide the setting of the item action listener
     *
     * @param callback
     */
    public void setAdapteredCallback(@Nullable final OnAdapteredBaseCallback callback) {
        if (callback != null) {
            this.callbackReference = new WeakReference<OnAdapteredBaseCallback>(callback);
        }
    }

    /**
     * Method which provide the getting of the instance of the {@link OnAdapteredBaseCallback}
     *
     * @return instance of the {@link OnAdapteredBaseCallback}
     */
    @Nullable
    protected OnAdapteredBaseCallback getCallback() {
        return (callbackReference == null)
                ? null : callbackReference.get();
    }

    /**
     * Method which provide the event sending
     *
     * @param AREvent recycler event
     */
    protected void sendEvent(@NonNull final AREvent AREvent) {
        final T object = getObject();
        final OnAdapteredBaseCallback callback = getCallback();
        if ((object != null) && (callback != null)) {
            callback.onActionReceived(AREvent, index, objectReference.get());
        }
    }
}
