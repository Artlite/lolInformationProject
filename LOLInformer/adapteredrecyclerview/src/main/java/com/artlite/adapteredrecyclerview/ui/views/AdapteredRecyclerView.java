package com.artlite.adapteredrecyclerview.ui.views;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.util.Log;

import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredBaseCallback;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredPagingCallback;
import com.artlite.adapteredrecyclerview.models.BaseObject;
import com.artlite.adapteredrecyclerview.ui.adapter.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Artli_000 on 24.07.2016.
 */

/**
 * Created by Artli_000 on 02.11.2015.
 */
public final class AdapteredRecyclerView<T extends BaseObject> extends RecyclerView {

    private static final String TAG = "AdapteredRecyclerView";

    /**
     * Interface which provide the doing some action inside the Handler thread
     */
    protected interface OnActionPerformer {
        void onActionPerform();
    }

    private final Handler MAIN_THREAD_HANDLER = new Handler();

    private BaseRecyclerViewAdapter innerAdapter;
    private List<T> innerObjects;

    /**
     * Constructor with context
     *
     * @param context context
     */
    public AdapteredRecyclerView(Context context) {
        super(context);
        onCreate(context);
    }

    /**
     * Constructor with context and attributes
     *
     * @param context context
     * @param attrs   attributes
     */
    public AdapteredRecyclerView(Context context, AttributeSet attrs) {
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
    public AdapteredRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        onCreate(context);
    }

    /**
     * Method which provide the action when RecyclerView is creating
     *
     * @param context current context
     */
    private void onCreate(@NonNull final Context context) {
        if (isInEditMode() == true) {
            return;
        }
        innerObjects = new ArrayList<>();
        innerAdapter = new BaseRecyclerViewAdapter(innerObjects);
        innerAdapter.setOldSizeList(0);
        setAdapter(innerAdapter);
        setHasFixedSize(true);
    }

    /**
     * Method which provide the sorting of the objects
     *
     * @param comparator comparartor
     * @param isReverse  is need reverse
     */
    public void sort(final Comparator<T> comparator, final boolean isReverse) {
        runOnBackground(new OnActionPerformer() {
            @Override
            public void onActionPerform() {
                if (isReverse == false) {
                    Collections.sort(innerObjects, comparator);
                } else {
                    Collections.sort(innerObjects, Collections.reverseOrder(comparator));
                }
                notifyDataSetChanged(true);
            }
        });
    }

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

    /**
     * Method which provide the list clearing
     */
    public void clear() {
        innerObjects.clear();
        innerAdapter.setOldSizeList(0);
        notifyDataSetChanged();
    }

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
     * Method which provide the notifying of the data set changed
     */
    public void notifyDataSetChanged() {
        this.notifyDataSetChanged(true);
    }

    /**
     * Method which provide the notifying of the data set changed
     */
    private void notifyDataSetChanged(final boolean needViewsReload) {
        runOnMainThread(0, new OnActionPerformer() {
            @Override
            public void onActionPerform() {
                if (needViewsReload == true) {
                    forceReloadViewHolder();
                }
                if (getAdapter() != null) {
                    getAdapter().notifyDataSetChanged();
                }
            }
        });
    }

    /**
     * Method that provide the invalidate {@link StaggeredGridLayoutManager}
     */
    private final void forceReloadViewHolder() {
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
     * Method which provide the setting of the item action listener
     *
     * @param itemActionListener
     */
    public void setActionCallback(@Nullable final OnAdapteredBaseCallback itemActionListener) {
        if (innerAdapter != null) {
            innerAdapter.setActionCallback(itemActionListener);
        }
    }

    /**
     * Method which provide the setting of the lazy load callback
     *
     * @param pagingCallback lazy load callback
     */
    public void setPagingCallback(@Nullable final OnAdapteredPagingCallback pagingCallback) {
        if (innerAdapter != null) {
            innerAdapter.setPagingCallback(pagingCallback);
        }
    }

    /**
     * Method which provide the sorting by priority
     *
     * @param objectList priority list
     */
    private void sortByPriority(@Nullable final List<T> objectList) {
        if (objectList != null) {
            Collections.sort(objectList, new PriorityComparator());
        }
    }

    /**
     * Method which provide the doing action on UI thread after the delaying time
     *
     * @param delay     delaying time (in seconds)
     * @param performer current action
     */
    protected void runOnMainThread(int delay, @NonNull final OnActionPerformer performer) {
        MAIN_THREAD_HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                performer.onActionPerform();
            }
        }, delay);
    }

    /**
     * Method which provide the running action on the background thread
     *
     * @param onActionPerformer action performer
     */
    protected void runOnBackground(@NonNull final OnActionPerformer onActionPerformer) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                onActionPerformer.onActionPerform();
            }
        };
        new Thread(runnable).start();
    }


    //COMPARATORS

    /**
     * Priority comparator class
     */
    private static class PriorityComparator implements Comparator<BaseObject> {
        /**
         * Compares its two arguments for order.  Returns a negative integer,
         * zero, or a positive integer as the first argument is less than, equal
         * to, or greater than the second.<p>
         */
        @Override
        public int compare(BaseObject lhs, BaseObject rhs) {
            return lhs.getPriority().compareTo(rhs.getPriority());
        }
    }

}
