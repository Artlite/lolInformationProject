package com.artlite.collapsinglayouttest.ui.adapters.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.artlite.collapsinglayouttest.model.Champion;
import com.artlite.collapsinglayouttest.ui.views.recycler.ChampionRecycleItem;

import java.util.List;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class ChampionsRecyclerAdapter extends RecyclerView.Adapter<ChampionsRecyclerAdapter.ViewHolder> {

    private List<Champion> listItems;

    public ChampionsRecyclerAdapter(List<Champion> listItems) {
        this.listItems = listItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(new ChampionRecycleItem(parent.getContext()));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.recycleItem.setChampion(listItems.get(position));
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ChampionRecycleItem recycleItem;

        public ViewHolder(View itemView) {
            super(itemView);
            recycleItem = (ChampionRecycleItem) itemView;
        }
    }
}
