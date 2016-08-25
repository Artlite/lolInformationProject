package com.artlite.adapteredrecyclerview.callbacks;

/**
 * Created by Artli_000 on 24.07.2016.
 */

/**
 * Callback which provide the lazy loading inside the RecyclerView
 */
public interface OnAdapteredPagingCallback {
    /**
     * Method which provide the notifying about end of list
     *
     * @param listSize list size
     */
    void onNextPage(int listSize);
}
