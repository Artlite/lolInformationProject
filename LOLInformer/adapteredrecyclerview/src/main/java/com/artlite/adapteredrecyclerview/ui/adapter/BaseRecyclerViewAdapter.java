package com.artlite.adapteredrecyclerview.ui.adapter;

import android.support.annotation.NonNull;
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

    public BaseRecyclerViewAdapter(List<T> listItems) {
        this.listItems = listItems;
        this.oldSizeList = 0;
    }

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

    @Override
    public int getItemViewType(int position) {
        index = position;
        final Class aClass = listItems.get(position).getClass();
        if (classes.contains(aClass) == false) {
            classes.add(aClass);
        }
        return classes.indexOf(aClass);
    }

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
    public void setActionCallback(OnAdapteredBaseCallback itemActionListener) {
        this.actionCallback = itemActionListener;
        notifyDataSetChanged();
    }

    /**
     * Method which provide the setting of the lazy load callback
     *
     * @param lazyLoadCallback lazy load callback
     */
    public void setPagingCallback(@NonNull OnAdapteredPagingCallback lazyLoadCallback) {
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

        public ViewHolder(View itemView) {
            super(itemView);
            recycleItem = (BaseRecyclerItem) itemView;
        }
    }
}
