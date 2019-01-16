package com.artlite.adapteredrecyclerview.callbacks;

/**
 * Created by Artli_000 on 24.07.2016.
 */

/**
 * Callback which provide the lazy loading inside the RecyclerView
 */
public interface OnAdapteredPagingExtendedCallback extends OnAdapteredPagingCallback {

    /**
     * Method which provide the notifying about item of list
     *
     * @param index {@link Integer} value of the visible index
     */
    void onItemVisible(int index);

}
