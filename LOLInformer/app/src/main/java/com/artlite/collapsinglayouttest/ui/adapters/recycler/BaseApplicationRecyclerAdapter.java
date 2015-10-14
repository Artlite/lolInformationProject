package com.artlite.collapsinglayouttest.ui.adapters.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.artlite.collapsinglayouttest.model.abs.BaseObject;
import com.artlite.collapsinglayouttest.ui.views.abs.BaseRecyclerItem;

import java.util.List;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class BaseApplicationRecyclerAdapter<T extends BaseObject> extends RecyclerView.Adapter<BaseApplicationRecyclerAdapter.ViewHolder> {

    private List<T> listItems;

    public BaseApplicationRecyclerAdapter(List<T> listItems) {
        this.listItems = listItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(listItems.get(viewType).getRecyclerItem(parent.getContext()));
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.recycleItem.setUp(listItems.get(position));
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public BaseRecyclerItem recycleItem;

        public ViewHolder(View itemView) {
            super(itemView);
            recycleItem = (BaseRecyclerItem) itemView;
        }
    }
}
