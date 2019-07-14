package com.artlite.adapteredrecyclerview.callbacks;

import android.support.v7.util.DiffUtil;

import com.artlite.adapteredrecyclerview.models.ARObject;

/**
 * Callback which provide to difference items
 */
public interface OnAdapteredDiffCallback {

    /**
     * Called to check whether two objects represent the same item.
     * <p>
     * For example, if your items have unique ids, this method should check their id equality.
     *
     * @param oldItem The item in the old list.
     * @param newItem The item in the new list.
     * @return True if the two items represent the same object or false if they are different.
     * @see DiffUtil.Callback#areItemsTheSame(int, int)
     */
    boolean areItemsTheSame(ARObject oldItem, ARObject newItem);

    /**
     * Called to check whether two items have the same data.
     * <p>
     * This information is used to detect if the contents of an item have changed.
     * <p>
     * This method to check equality instead of {@link Object#equals(Object)} so that you can
     * change its behavior depending on your UI.
     * <p>
     * For example, if you are using DiffUtil with a
     * {@link android.support.v7.widget.RecyclerView.Adapter RecyclerView.Adapter}, you should
     * return whether the items' visual representations are the same.
     * <p>
     * This method is called only if {@link #areItemsTheSame(T, T)} returns {@code true} for
     * these items.
     *
     * @param oldItem The item in the old list.
     * @param newItem The item in the new list.
     * @return True if the contents of the items are the same or false if they are different.
     * @see DiffUtil.Callback#areContentsTheSame(int, int)
     */
    boolean areContentsTheSame(ARObject oldItem, ARObject newItem);
}
