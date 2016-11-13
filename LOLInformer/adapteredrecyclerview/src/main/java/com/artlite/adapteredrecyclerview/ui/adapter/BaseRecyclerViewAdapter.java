package com.artlite.adapteredrecyclerview.ui.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredBaseCallback;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredPagingCallback;
import com.artlite.adapteredrecyclerview.models.BaseObject;
import com.artlite.adapteredrecyclerview.models.BaseRecyclerItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artli_000 on 24.07.2016.
 */
public class BaseRecyclerViewAdapter<T extends BaseObject> extends RecyclerView.Adapter<BaseRecyclerViewAdapter.ViewHolder> {

    private List<T> listItems;
    private OnAdapteredBaseCallback actionCallback;
    private OnAdapteredPagingCallback pagingCallback;
    private int oldSizeList;
    //ViewHolder management
    private int index = 0;
    private List<Class> classes = new ArrayList<>();
    private List<ViewHolder> viewHolders = new ArrayList<>();

    /**
     * Default constructor
     *
     * @param listItems list item
     */
    public BaseRecyclerViewAdapter(@NonNull final List<T> listItems) {
        this.listItems = listItems;
        this.oldSizeList = 0;
    }

    /**
     * Called when RecyclerView needs a new {@link RecyclerView.ViewHolder} of the given type to represent
     * an item.
     * <p>
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     * <p>
     * The new ViewHolder will be used to display items of the adapter using
     * {@link #onBindViewHolder(RecyclerView.ViewHolder, int, List)}. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary {@link View#findViewById(int)} calls.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     * @see #getItemViewType(int)
     * @see #onBindViewHolder(RecyclerView.ViewHolder, int)
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = null;
        if (viewType < viewHolders.size()) {
            viewHolder = viewHolders.get(viewType);
        } else {
            viewHolder = new ViewHolder(listItems.get(index).getRecyclerItem(parent.getContext()));
        }
        return viewHolder;
    }

    /**
     * Return the view type of the item at <code>position</code> for the purposes
     * of view recycling.
     * <p>
     * <p>The default implementation of this method returns 0, making the assumption of
     * a single view type for the adapter. Unlike ListView adapters, types need not
     * be contiguous. Consider using id resources to uniquely identify item view types.
     *
     * @param position position to query
     * @return integer value identifying the type of the view needed to represent the item at
     * <code>position</code>. Type codes need not be contiguous.
     */
    @Override
    public int getItemViewType(int position) {
        index = position;
        final Class aClass = listItems.get(position).getClass();
        if (classes.contains(aClass) == false) {
            classes.add(aClass);
        }
        return classes.indexOf(aClass);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link RecyclerView.ViewHolder#itemView} to reflect the item at the given
     * position.
     * <p>
     * Note that unlike {@link android.widget.ListView}, RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the <code>position</code> parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use {@link RecyclerView.ViewHolder#getAdapterPosition()} which will
     * have the updated adapter position.
     * <p>
     * Override {@link #onBindViewHolder(RecyclerView.ViewHolder, int, List)} instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //Get object
        T recyclerItem = listItems.get(position);
        //Set index
        recyclerItem.setIndex(position);
        //Set up the view
        holder.recycleItem.setUp(recyclerItem);
        //Set object inside the view as WeakReference
        holder.recycleItem.setObject(recyclerItem);
        //Set item listener
        holder.recycleItem.setItemActionListener(actionCallback);
        //Lazy load
        int listItemSize = listItems.size();
        if ((position == listItemSize - 1)
                && (listItemSize > oldSizeList)) {
            if (pagingCallback != null) {
                pagingCallback.onNextPage(listItemSize);
                oldSizeList = listItemSize;
            }
        }
    }

    /**
     * Method which provide the getting of the item counts
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return listItems.size();
    }

    /**
     * Method which provide the setting of the item action listener
     *
     * @param itemActionListener
     */
    public void setActionCallback(@Nullable final OnAdapteredBaseCallback itemActionListener) {
        this.actionCallback = itemActionListener;
        notifyDataSetChanged();
    }

    /**
     * Method which provide the setting of the lazy load callback
     *
     * @param lazyLoadCallback lazy load callback
     */
    public void setPagingCallback(@NonNull final OnAdapteredPagingCallback lazyLoadCallback) {
        this.pagingCallback = lazyLoadCallback;
    }

    /**
     * Method which provide the setting of the old list size
     *
     * @param oldSizeList size list (old value)
     */
    public void setOldSizeList(int oldSizeList) {
        this.oldSizeList = oldSizeList;
    }

    /**
     * View holder class
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public BaseRecyclerItem recycleItem;

        /**
         * Default constructor
         *
         * @param itemView item view
         */
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            recycleItem = (BaseRecyclerItem) itemView;
        }
    }
}
