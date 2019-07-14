package com.artlite.adapteredrecyclerview.ui.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredBaseCallback;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredPagingCallback;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredPagingExtendedCallback;
import com.artlite.adapteredrecyclerview.models.ARCell;
import com.artlite.adapteredrecyclerview.models.ARObject;
import com.futuremind.recyclerviewfastscroll.SectionTitleProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artli_000 on 24.07.2016.
 */
public class ARBaseAdapter<T extends ARObject>
        extends ListAdapter<ARObject, ARBaseAdapter.ViewHolder>
        implements SectionTitleProvider {
    // Callbacks
    protected OnAdapteredBaseCallback actionCallback;
    protected OnAdapteredPagingCallback pagingCallback;
    protected int oldSizeList;
    //ViewHolder management
    protected int index = 0;
    protected final List<Class> classes = new ArrayList<>();
    protected final List<ViewHolder> viewHolders = new ArrayList<>();

    /**
     * Default constructor
     */
    public ARBaseAdapter(@NonNull final DiffUtil.ItemCallback diffCallback) {
        super(diffCallback);
        this.oldSizeList = 0;
    }

    /**
     * Default constructor
     *
     * @param listItems list item
     */
    public ARBaseAdapter(@NonNull final List<ARObject> listItems,
                         @NonNull final DiffUtil.ItemCallback diffCallback) {
        super(diffCallback);
        this.update(listItems);
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
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@Nullable final ViewGroup parent, int viewType) {
        ViewHolder viewHolder = null;
        if (viewType < viewHolders.size()) {
            viewHolder = viewHolders.get(viewType);
        } else {
            viewHolder = new ViewHolder(getItem(index).getRecyclerItem(parent.getContext()));
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
        final Class aClass = getItem(position).getClass();
        if (!classes.contains(aClass)) {
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
    public void onBindViewHolder(@Nullable final ViewHolder holder, int position) {
        //Get object
        T recyclerItem = (T) getItem(position);
        //Set index
        recyclerItem.setIndex(position);
        if ((holder != null) && (holder.recycleItem != null)) {
            //Set up the view
            holder.recycleItem.setUp(recyclerItem);
            //Set object inside the view as WeakReference
            holder.recycleItem.setObject(recyclerItem);
            //Set item listener
            holder.recycleItem.setItemActionListener(actionCallback);
        }
        //Lazy load
        int listItemSize = getItemCount();
        if ((position == listItemSize - 1)
                && (listItemSize > oldSizeList)) {
            if (pagingCallback != null) {
                pagingCallback.onNextPage(listItemSize);
                oldSizeList = listItemSize;
            }
        } else {
            if (pagingCallback != null) {
                if (pagingCallback instanceof OnAdapteredPagingExtendedCallback) {
                    final OnAdapteredPagingExtendedCallback callback
                            = (OnAdapteredPagingExtendedCallback) pagingCallback;
                    callback.onItemVisible(position);
                }
            }
        }
    }

    /**
     * Method which provide the setting of the item action listener
     *
     * @param callback
     */
    public void setActionCallback(@Nullable final OnAdapteredBaseCallback callback) {
        this.actionCallback = callback;
        notifyDataSetChanged();
    }

    /**
     * Method which provide the setting of the lazy load callback
     *
     * @param callback lazy load callback
     */
    public <T extends OnAdapteredPagingCallback>
    void setPagingCallback(@NonNull final T callback) {
        this.pagingCallback = callback;
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
     * Method which provide the setting of the {@link List} items
     *
     * @param listItems instance of the {@link List}
     */
    public void setListItems(@Nullable final List<ARObject> listItems) {
        this.submitList((listItems == null) ? new ArrayList<ARObject>() : listItems);
    }

    /**
     * Should be implemented by the adapter of the RecyclerView.
     * Provides a text to be shown by the bubble, when RecyclerView reaches
     * the position. Usually the first letter of the text shown by the item
     * at this position.
     *
     * @param position Position of the row in adapter
     * @return The text to be shown in the bubble
     * @see com.futuremind.recyclerviewfastscroll.FastScroller
     */
    @Override
    public String getSectionTitle(int position) {
        return this.getItem(position).getSectionTitle(position);
    }

    /**
     * Method which provide the update list
     *
     * @param list instance of the {@link List}
     */
    public void update(List<ARObject> list) {
        this.submitList(new ArrayList<>(list));
    }

    /**
     * View holder class
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * Instance of the {@link ARCell}
         */
        public ARCell recycleItem;

        /**
         * Default constructor
         *
         * @param itemView item view
         */
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            recycleItem = (ARCell) itemView;
        }
    }
}
