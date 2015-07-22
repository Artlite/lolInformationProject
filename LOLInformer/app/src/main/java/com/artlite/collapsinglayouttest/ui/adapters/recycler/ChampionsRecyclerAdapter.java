package com.artlite.collapsinglayouttest.ui.adapters.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.artlite.collapsinglayouttest.model.ListItem;
import com.artlite.collapsinglayouttest.ui.views.MainRecycleItem;

import java.util.List;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class ChampionsRecyclerAdapter extends RecyclerView.Adapter<ChampionsRecyclerAdapter.ViewHolder> {

    private List<ListItem> listItems;

    public ChampionsRecyclerAdapter(List<ListItem> listItems) {
        this.listItems = listItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(new MainRecycleItem(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.recycleItem.mainTextView.setText(listItems.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public MainRecycleItem recycleItem;

        public ViewHolder(View itemView) {
            super(itemView);
            recycleItem = (MainRecycleItem) itemView;
        }
    }
}
