package com.artlite.adapteredrecyclerview.ui.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredBaseCallback;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredDiffCallback;
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
    protected ARBaseAdapter<T> innerAdapter;

    /**
     * Instance of the {@link List} of the objects
     */
    protected List<ARObject> innerObjects;

    /**
     * Instance of the {@link DiffUtil.ItemCallback}
     */
    protected DiffUtil.ItemCallback<ARObject> diffCallback;

    /**
     * Instance of the {@link OnAdapteredDiffCallback}
     */
    protected OnAdapteredDiffCallback adapteredDiffCallback;

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
        if (isInEditMode()) {
            return;
        }
        innerObjects = new ArrayList<>();
        innerAdapter = new ARBaseAdapter<>(innerObjects, getDiffCallback());
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
    public <K extends Comparator> void sort(@NonNull final K comparator,
                                            final boolean isReverse) {
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
    protected void sortByPriority(@Nullable final List<ARObject> objectList) {
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
            final List<T> list = new ArrayList<>();
            list.add(object);
            this.add(list);
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
                final List<T> list = new ArrayList<>();
                list.add(object);
                this.delete(list);
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
    public void delete(@Nullable final List<T> objects) {
        if (objects != null) {
            innerObjects.removeAll(objects);
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
    public List<ARObject> getListItems() {
        return innerObjects;
    }

    /**
     * Method which provide the getting of the {@link List} of the selected {@link ARObject}
     *
     * @return instance of the selected {@link List} of the {@link ARObject}
     */
    @NonNull
    public List<ARObject> getSelectedItems() {
        final List<ARObject> result = new ArrayList<>();
        for (ARObject object : innerObjects) {
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
    public List<ARObject> getDeselectedItems() {
        final List<ARObject> result = new ArrayList<>();
        for (ARObject object : innerObjects) {
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
                sortByPriority(innerObjects);
                Adapter adapter = getAdapter();
                if (adapter != null) {
                    if (adapter instanceof ARBaseAdapter) {
                        ((ARBaseAdapter) adapter).update(innerObjects);
                    } else {
                        getAdapter().notifyDataSetChanged();
                    }
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
    public void setActionCallback(@Nullable final OnAdapteredBaseCallback<T> callback) {
        if (innerAdapter != null) {
            innerAdapter.setActionCallback(callback);
        }
    }

    /**
     * Method which provide the setting of the lazy load callback
     *
     * @param callback lazy load callback
     */
    public <T extends OnAdapteredPagingCallback>
    void setPagingCallback(@Nullable final T callback) {
        if (innerAdapter != null) {
            innerAdapter.setPagingCallback(callback);
        }
    }

    /**
     * Method which provide to set the adaptered diff callback
     *
     * @param callback instance {@link OnAdapteredDiffCallback}
     */
    public void setDiffCallback(OnAdapteredDiffCallback callback) {
        this.adapteredDiffCallback = callback;
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
    //                                      SET ADAPTER
    //==============================================================================================

    /**
     * Method which provide the adapter setting
     *
     * @param adapter instance of the {@link RecyclerView.Adapter}
     */
    @Override
    public void setAdapter(Adapter adapter) {
        if (adapter instanceof ARBaseAdapter) {
            final ARBaseAdapter baseAdapter = (ARBaseAdapter) adapter;
            if (baseAdapter.getItemCount() <= 0) {
                baseAdapter.setListItems(this.innerObjects);
                baseAdapter.setOldSizeList(0);
            }
        }
        super.setAdapter(adapter);
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

    /**
     * Method which provide the getting of the diff callback
     *
     * @return instance of the {@link DiffUtil.ItemCallback}
     */
    @NonNull
    public DiffUtil.ItemCallback<ARObject> getDiffCallback() {
        if (diffCallback == null) {
            diffCallback = new DiffUtil.ItemCallback<ARObject>() {
                @Override
                public boolean areItemsTheSame(ARObject oldItem, ARObject newItem) {
                    if (adapteredDiffCallback != null) {
                        return adapteredDiffCallback
                                .areItemsTheSame(oldItem, newItem);
                    }
                    return oldItem.equals(newItem);
                }

                @Override
                public boolean areContentsTheSame(ARObject oldItem, ARObject newItem) {
                    if (adapteredDiffCallback != null) {
                        return adapteredDiffCallback
                                .areContentsTheSame(oldItem, newItem);
                    }
                    return oldItem.equals(newItem);
                }
            };
        }
        return diffCallback;
    }
}
