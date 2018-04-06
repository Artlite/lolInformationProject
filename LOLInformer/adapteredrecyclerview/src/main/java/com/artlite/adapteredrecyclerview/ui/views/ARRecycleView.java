package com.artlite.adapteredrecyclerview.ui.views;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredBaseCallback;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredPagingCallback;
import com.artlite.adapteredrecyclerview.models.ARObject;
import com.artlite.adapteredrecyclerview.ui.adapter.ARBaseAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Artli_000 on 24.07.2016.
 */

/**
 * Created by Artli_000 on 02.11.2015.
 */
public final class ARRecycleView<T extends ARObject> extends RecyclerView {

    /**
     * {@link String} constants of the tag
     */
    private static final String TAG = "AdapteredRecyclerView";

    /**
     * Interface which provide the doing some action inside the Handler thread
     */
    protected interface OnActionPerformer {
        void onActionPerform();
    }

    /**
     * Instance of the {@link Handler}
     */
    protected final Handler MAIN_THREAD_HANDLER = new Handler();

    /**
     * Instance of the {@link ARBaseAdapter}
     */
    protected ARBaseAdapter innerAdapter;

    /**
     * Instance of the {@link List} of the objects
     */
    protected List<T> innerObjects;

    //==============================================================================================
    //                                      CONSTRUCTORS
    //==============================================================================================

    /**
     * Constructor with context
     *
     * @param context context
     */
    public ARRecycleView(@NonNull final Context context) {
        super(context);
        onCreate(context);
    }

    /**
     * Constructor with context and attributes
     *
     * @param context context
     * @param attrs   attributes
     */
    public ARRecycleView(@NonNull final Context context,
                         @Nullable final AttributeSet attrs) {
        super(context, attrs);
        onCreate(context);
    }

    /**
     * Constructor with context and attributes and styles
     *
     * @param context  context
     * @param attrs    attributes
     * @param defStyle style
     */
    public ARRecycleView(@NonNull final Context context,
                         @Nullable final AttributeSet attrs,
                         int defStyle) {
        super(context, attrs, defStyle);
        onCreate(context);
    }

    //==============================================================================================
    //                                      ON CREATE
    //==============================================================================================

    /**
     * Method which provide the action when RecyclerView is creating
     *
     * @param context current context
     */
    protected void onCreate(@NonNull final Context context) {
        if (isInEditMode() == true) {
            return;
        }
        innerObjects = new ArrayList<>();
        innerAdapter = new ARBaseAdapter(innerObjects);
        innerAdapter.setOldSizeList(0);
        setAdapter(innerAdapter);
        setHasFixedSize(true);
    }

    //==============================================================================================
    //                                      SORT
    //==============================================================================================

    /**
     * Method which provide the object sorting by priority
     */
    public void sort() {
        sort(new PriorityComparator(), false);
    }

    /**
     * Method which provide the sorting of the objects
     *
     * @param comparator comparartor
     * @param isReverse  is need reverse
     */
    public <K extends Comparator> void sort(@NonNull final K comparator, final boolean isReverse) {
        runOnBackground(new OnActionPerformer() {
            @Override
            public void onActionPerform() {
                if (isReverse == false) {
                    Collections.sort(innerObjects, comparator);
                } else {
                    Collections.sort(innerObjects, Collections.reverseOrder(comparator));
                }
                notifyDataSetChanged();
            }
        });
    }

    /**
     * Method which provide the sorting by priority
     *
     * @param objectList priority list
     */
    protected void sortByPriority(@Nullable final List<T> objectList) {
        if (objectList != null) {
            Collections.sort(objectList, new PriorityComparator());
        }
    }

    //==============================================================================================
    //                                          SET
    //==============================================================================================

    /**
     * Method which provide the object setting
     *
     * @param object object to set
     */
    public void set(@Nullable final T object) {
        if (object != null) {
            List<T> result = new ArrayList<>();
            result.add(object);
            this.set(result);
        }
    }

    /**
     * Method which provide the setting of the list
     *
     * @param objects list objects
     */
    public void set(@Nullable final List<T> objects) {
        if (objects != null) {
            innerObjects.clear();
            innerAdapter.setOldSizeList(0);
            innerObjects.addAll(objects);
            sortByPriority(innerObjects);
            notifyDataSetChanged();
        }
    }

    //==============================================================================================
    //                                          ADD
    //==============================================================================================

    /**
     * Method which provide the object adding
     *
     * @param object object to add
     */
    public void add(@Nullable final T object) {
        if (object != null) {
            innerObjects.add(object);
            sortByPriority(innerObjects);
            if (getAdapter() != null) {
                getAdapter().notifyItemInserted(innerObjects.size() - 1);
            }
        }
    }

    /**
     * Method which provide the updating list inside the RecyclerView
     *
     * @param objects current object list
     */
    public void add(@Nullable final List<T> objects) {
        if (objects != null) {
            innerObjects.addAll(objects);
            sortByPriority(innerObjects);
            notifyDataSetChanged();
        }
    }

    //==============================================================================================
    //                                          DELETE
    //==============================================================================================

    /**
     * Method which provide the item deleting
     *
     * @param object current item
     * @return deleting results
     */
    public boolean delete(@Nullable final T object) {
        if (object != null) {
            if (innerObjects.contains(object)) {
                int objectIndex = innerObjects.indexOf(object);
                innerObjects.remove(object);
                getAdapter().notifyItemRemoved(objectIndex);
                return true;
            }
        }
        return false;
    }

    /**
     * Method which provide the objects removing
     *
     * @param objects objects
     * @return deleting value
     */
    public void delete(@Nullable final T[] objects) {
        if (objects != null) {
            for (T object : objects) {
                if (innerObjects.contains(object)) {
                    int objectIndex = innerObjects.indexOf(object);
                    innerObjects.remove(object);
                }
            }
            notifyDataSetChanged();
        }
    }

    //==============================================================================================
    //                                          CLEAR
    //==============================================================================================

    /**
     * Method which provide the list clearing
     */
    public void clear() {
        innerObjects.clear();
        innerAdapter.setOldSizeList(0);
        notifyDataSetChanged();
    }

    //==============================================================================================
    //                                          UPDATE
    //==============================================================================================

    /**
     * Method which provide the update object view by object
     *
     * @param object object
     */
    public void update(@Nullable final T object) {
        if (object != null) {
            if (innerObjects.contains(object) == true) {
                update(innerObjects.indexOf(object));
            }
        }
    }

    /**
     * Method which provide the update object view by index
     *
     * @param index index for update
     */
    public void update(int index) {
        if (getAdapter() != null) {
            getAdapter().notifyItemChanged(index);
        }
    }

    //==============================================================================================
    //                                          GET
    //==============================================================================================

    /**
     * Method which provide the getting of the item by index
     *
     * @param index
     * @return current object
     */
    @Nullable
    public T getItem(int index) {
        try {
            T object = (T) innerObjects.get(index);
            return object;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return null;
    }

    /**
     * Method which provide the getting item index
     *
     * @param object object
     * @return index
     */
    public int getIndex(@Nullable final T object) {
        try {
            int index = innerObjects.indexOf(object);
            return index;
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        return 0;
    }

    /**
     * Method which provide the getting of the items list
     *
     * @return current items list
     */
    @NonNull
    public List<T> getListItems() {
        return innerObjects;
    }

    /**
     * Method which provide the getting of the {@link List} of the selected {@link ARObject}
     *
     * @return instance of the selected {@link List} of the {@link ARObject}
     */
    @NonNull
    public List<T> getSelectedItems() {
        final List<T> result = new ArrayList<>();
        for (T object : innerObjects) {
            if (object.isSelected()) {
                result.add(object);
            }
        }
        return result;
    }

    /**
     * Method which provide the getting of the {@link List} of the deselected {@link ARObject}
     *
     * @return instance of the deselected {@link List} of the {@link ARObject}
     */
    @NonNull
    public List<T> getDeselectedItems() {
        final List<T> result = new ArrayList<>();
        for (T object : innerObjects) {
            if (!object.isSelected()) {
                result.add(object);
            }
        }
        return result;
    }

    //==============================================================================================
    //                                      NOTIFY
    //==============================================================================================

    /**
     * Method which provide the notifying of the data set changed
     */
    public void notifyDataSetChanged() {
        runOnMainThread(0, new OnActionPerformer() {
            @Override
            public void onActionPerform() {
                if (getAdapter() != null) {
                    getAdapter().notifyDataSetChanged();
                }
            }
        });
    }

    //==============================================================================================
    //                                      CALLBACKS
    //==============================================================================================

    /**
     * Method which provide the setting of the item action listener
     *
     * @param callback
     */
    public void setActionCallback(@Nullable final OnAdapteredBaseCallback callback) {
        if (innerAdapter != null) {
            innerAdapter.setActionCallback(callback);
        }
    }

    /**
     * Method which provide the setting of the lazy load callback
     *
     * @param callback lazy load callback
     */
    public void setPagingCallback(@Nullable final OnAdapteredPagingCallback callback) {
        if (innerAdapter != null) {
            innerAdapter.setPagingCallback(callback);
        }
    }

    //==============================================================================================
    //                                          THREADS
    //==============================================================================================

    /**
     * Method which provide the doing action on UI thread after the delaying time
     *
     * @param performer current action
     */
    protected void runOnMainThread(@Nullable final OnActionPerformer performer) {
        runOnMainThread(0, performer);
    }

    /**
     * Method which provide the doing action on UI thread after the delaying time
     *
     * @param delay     delaying time (in seconds)
     * @param performer current action
     */
    protected void runOnMainThread(int delay, @Nullable final OnActionPerformer performer) {
        MAIN_THREAD_HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (performer != null) {
                    performer.onActionPerform();
                }
            }
        }, delay);
    }

    /**
     * Method which provide the running action on the background thread
     *
     * @param performer action performer
     */
    protected void runOnBackground(@Nullable final OnActionPerformer performer) {
        runOnBackground(0, performer);

    }

    /**
     * Method which provide the running action on the background thread
     *
     * @param delay     delaying time (in seconds)
     * @param performer action performer
     */
    protected void runOnBackground(int delay, @Nullable final OnActionPerformer performer) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (performer != null) {
                    performer.onActionPerform();
                }
            }
        }, delay * 1000);
    }


    //==============================================================================================
    //                                      COMPARATORS
    //==============================================================================================

    /**
     * Priority comparator class
     */
    protected static class PriorityComparator implements Comparator<ARObject> {
        /**
         * Compares its two arguments for order.  Returns a negative integer,
         * zero, or a positive integer as the first argument is less than, equal
         * to, or greater than the second.<p>
         */
        @Override
        public int compare(@NonNull final ARObject lhs, @NonNull final ARObject rhs) {
            if (lhs.getPriority().ordinal() < rhs.getPriority().ordinal()) {
                return 1;
            } else if (lhs.getPriority().ordinal() == rhs.getPriority().ordinal()) {
                return 0;
            } else {
                return -1;
            }
        }
    }

}
