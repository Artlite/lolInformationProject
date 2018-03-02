package com.artlite.adapteredrecyclerview.core;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.artlite.adapteredrecyclerview.R;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredBaseCallback;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredPagingCallback;
import com.artlite.adapteredrecyclerview.callbacks.OnAdapteredRefreshCallback;
import com.artlite.adapteredrecyclerview.constants.ARColorStateConstants;
import com.artlite.adapteredrecyclerview.helpers.ARColorHelper;
import com.artlite.adapteredrecyclerview.models.ARObject;
import com.artlite.adapteredrecyclerview.ui.views.ARRecycleView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Artli on 25.08.2016.
 */
public class ARView<T extends ARObject> extends FrameLayout {

    private static final class Attributes {
        private static Attributes instance;

        protected boolean isInit = false;
        protected boolean isNeedRefresh = false;
        protected ColorStateList refreshColor;
        protected ColorStateList refreshBackgroundColor;

        /**
         * Method which provide the getting instance of the Attributes class
         *
         * @return
         */
        public static Attributes getInstance() {
            if (instance == null) {
                instance = new Attributes();
            }
            return instance;
        }

        /**
         * Method which provide the attribute validation
         */
        protected void validate() {
            if (refreshColor == null) {
                refreshColor = ARColorStateConstants.K_DEFAULT_REFRESH_COLOR;
            }

            if (refreshBackgroundColor == null) {
                refreshBackgroundColor = ARColorStateConstants.K_DEFAULT_REFRESH_BACKGROUND_COLOR;
            }
        }
    }

    private View baseView;
    private ARRecycleView<T> recyclerView;
    private SwipeRefreshLayout refreshLayout;
    private OnAdapteredRefreshCallback refreshCallback;

    public ARView(Context context) {
        super(context);
        onInitializeView(context, null);
    }

    public ARView(Context context, AttributeSet attrs) {
        super(context, attrs);
        onInitializeView(context, attrs);
    }

    public ARView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onInitializeView(context, attrs);
    }

    /**
     * Method which provide the inflating of the view
     *
     * @param context  current context
     * @param layoutID layout id
     */
    private void inflateView(@NonNull final Context context, int layoutID) {
        LayoutInflater inflater = LayoutInflater.from(context);
        this.baseView = inflater.inflate(layoutID, this);
    }

    /**
     * Method which provide the initialize of the view
     *
     * @param context
     */
    private void onInitializeView(@NonNull final Context context,
                                  @Nullable final AttributeSet attributeSet) {
        if (isInEditMode() == true) {
            return;
        }
        this.inflateView(context, R.layout.adaptered_view);
        this.recyclerView = (ARRecycleView) baseView.findViewById(R.id.adaptered_recycler_view);
        this.refreshLayout = (SwipeRefreshLayout) baseView.findViewById(R.id.swipe_layout);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (refreshCallback != null) {
                    refreshCallback.onRefreshData();
                }
            }
        });
        if (attributeSet != null) {
            this.onInitiAttrs(attributeSet, context);
        }
        this.onApplyAttrs();
    }

    /**
     * Method which provide the attributes applying
     *
     * @param attrs   attributes
     * @param context context
     */
    private void onInitiAttrs(@NonNull final AttributeSet attrs, @NonNull final Context context) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ARView);
        if (Attributes.getInstance().isInit == false) {
            try {
                Attributes.getInstance().isNeedRefresh = a
                        .getBoolean(R.styleable.ARView_need_refresh, false);
                Attributes.getInstance().refreshColor = a
                        .getColorStateList(R.styleable.ARView_refresh_color);
                Attributes.getInstance().refreshBackgroundColor = a
                        .getColorStateList(R.styleable.ARView_refresh_background);
                Attributes.getInstance().validate();
            } finally {
                Attributes.getInstance().isInit = true;
                a.recycle();
            }
        }
    }

    /**
     * Method which provide the attribute applying
     */
    private void onApplyAttrs() {
        if (Attributes.getInstance().refreshColor == null) {
            Attributes.getInstance().refreshColor = ColorStateList
                    .valueOf(getContext().getResources().getColor(android.R.color.black));
        }
        if (Attributes.getInstance().refreshBackgroundColor == null) {
            Attributes.getInstance().refreshColor = ColorStateList
                    .valueOf(getContext().getResources().getColor(android.R.color.white));
        }
        refreshLayout.setEnabled(Attributes.getInstance().isNeedRefresh);
        setRefreshColoursRes(Attributes.getInstance().refreshBackgroundColor,
                Attributes.getInstance().refreshColor);
    }

    //INIT METHODS

    /**
     * Method which provide the initialize of the recycler view
     */
    public final void init() {
        this.init(new GridLayoutManager(getContext(), 1), null, null, null);
    }

    /**
     * Method which provide the initialize of the recycler view
     */
    public final void init(@NonNull final RecyclerView.LayoutManager layoutManager) {
        this.init(layoutManager, null, null, null);
    }

    /**
     * Method which provide the initialize of the recycler view
     *
     * @param layoutManager layout manager
     */
    public final void init(@NonNull final RecyclerView.LayoutManager layoutManager,
                           @Nullable final OnAdapteredBaseCallback callback) {
        this.init(layoutManager, callback, null, null);
    }

    /**
     * Method which provide the initialize of the recycler view
     *
     * @param layoutManager layout manager
     * @param callback      action callback
     */
    public final void init(@NonNull final RecyclerView.LayoutManager layoutManager,
                           @Nullable final OnAdapteredBaseCallback callback,
                           @Nullable final OnAdapteredRefreshCallback refreshCallback) {
        this.init(layoutManager, callback, refreshCallback, null);
    }

    /**
     * Method which provide the initialize of the recycler view
     *
     * @param layoutManager  layout manager
     * @param callback       action callback
     * @param pagingCallback paging callback
     */
    public final void init(@NonNull final RecyclerView.LayoutManager layoutManager,
                           @Nullable final OnAdapteredBaseCallback callback,
                           @Nullable final OnAdapteredRefreshCallback refreshCallback,
                           @Nullable final OnAdapteredPagingCallback pagingCallback) {
        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.setHasFixedSize(true);
        //Set callback
        if (callback != null) {
            this.recyclerView.setActionCallback(callback);
        }
        //Set paging callback
        if (pagingCallback != null) {
            this.recyclerView.setPagingCallback(pagingCallback);
        }
        //Set refresh callback
        if (refreshCallback != null) {
            this.refreshCallback = refreshCallback;
        }
    }

    //REFRESH FUNCTIONAL

    /**
     * Method which provide the hiding of the SwipeRefreshLayout
     */
    public final void hideRefresh() {
        this.refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(false);
            }
        });
    }

    /**
     * Method which provide the hide refresh for the SwipeRefreshLayout
     */
    public final void showRefresh() {
        this.refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(true);
            }
        });
    }

    //MANAGEMENT METHODS

    /**
     * Method which provide the object setting
     *
     * @param object object to set
     */
    public final void set(@Nullable final T object) {
        this.recyclerView.set(object);
    }

    /**
     * Method which provide the setting of the list
     *
     * @param objects list objects
     */
    public final void set(@Nullable final List<T> objects) {
        this.recyclerView.set(objects);
    }

    /**
     * Method which provide the object adding
     *
     * @param object object to add
     */
    public final void add(@Nullable final T object) {
        this.recyclerView.add(object);
    }

    /**
     * Method which provide the updating list inside the RecyclerView
     *
     * @param objects current object list
     */
    public final void add(@Nullable final List<T> objects) {
        this.recyclerView.add(objects);
    }

    /**
     * Method which provide the item deleting
     *
     * @param object current item
     * @return deleting results
     */
    public final boolean delete(@Nullable final T object) {
        return this.recyclerView.delete(object);
    }

    /**
     * Method which provide the objects removing
     *
     * @param objects objects
     * @return deleting value
     */
    public final void delete(@Nullable final T[] objects) {
        this.recyclerView.delete(objects);
    }

    /**
     * Method which provide the list clearing
     */
    public final void clear() {
        this.recyclerView.clear();
    }

    /**
     * Method which provide the update object view by object
     *
     * @param object object
     */
    public void update(@Nullable final T object) {
        this.recyclerView.update(object);
    }

    /**
     * Method which provide the update object view by index
     *
     * @param index index for update
     */
    public void update(int index) {
        this.recyclerView.update(index);
    }

    /**
     * Method which provide the getting of the item by index
     *
     * @param index
     * @return current object
     */
    @Nullable
    public final T getItem(int index) {
        return this.recyclerView.getItem(index);
    }

    /**
     * Method which provide the getting item index
     *
     * @param object object
     * @return index
     */
    public final int getIndex(@Nullable final T object) {
        return this.recyclerView.getIndex(object);
    }

    /**
     * Method which provide the getting of the items list
     *
     * @return current items list
     */
    @NonNull
    public List<T> getListItems() {
        return this.recyclerView.getListItems();
    }

    /**
     * Method which provide the getting of the list item size
     *
     * @return list item size
     */
    public int getListSize() {
        return (getListItems() != null) ? getListItems().size() : 0;
    }

    /**
     * Method which provide the object sorting by priority
     */
    public void sort() {
        if (recyclerView != null) {
            recyclerView.sort();
        }
    }

    /**
     * Method which provide the sorting of the objects
     *
     * @param comparator comparartor
     * @param isReverse  is need reverse
     */
    public <K extends Comparator> void sort(@NonNull final K comparator, final boolean isReverse) {
        if (recyclerView != null) {
            recyclerView.sort(comparator, isReverse);
        }
    }

    /**
     * Method which provide the notifying of the data set changed
     */
    public void notifyDataSetChanged() {
        if (recyclerView != null) {
            recyclerView.notifyDataSetChanged();
        }
    }

    /**
     * Method which provide the setting of the {@link OnAdapteredBaseCallback}
     *
     * @param callback callback
     */
    public void setActionCallback(@Nullable final OnAdapteredBaseCallback callback) {
        if (callback != null) {
            this.recyclerView.setActionCallback(callback);
        }
    }

    /**
     * Method which provide the setting of the {@link OnAdapteredPagingCallback}
     *
     * @param callback callback
     */
    public void setPagingCallback(@Nullable final OnAdapteredPagingCallback callback) {
        //Set paging callback
        if (callback != null) {
            this.recyclerView.setPagingCallback(callback);
        }
    }

    /**
     * Method which provide the setting of the {@link OnAdapteredRefreshCallback}
     *
     * @param callback
     */
    public void setRefreshCallback(@Nullable final OnAdapteredRefreshCallback callback) {
        //Set refresh callback
        if (callback != null) {
            this.refreshCallback = callback;
        }
    }

    /**
     * Method which provide the setting of the definition if {@link ARView} need swipe down to refresh
     *
     * @param isNeedResfresh
     */
    public void setIsNeedResfresh(boolean isNeedResfresh) {
        refreshLayout.setEnabled(isNeedResfresh);
    }

    /**
     * Method which provide the setting of the refresh color
     * from color resources
     *
     * @param backgroundColor background color resource
     * @param refreshColor    refresh color resource
     */
    public void setRefreshColoursInt(@ColorInt int backgroundColor, @ColorInt int refreshColor) {
        final ColorStateList background = ARColorHelper.getColorStateList(backgroundColor);
        final ColorStateList refresh = ARColorHelper.getColorStateList(refreshColor);
        setRefreshColoursRes(background, refresh);
    }

    /**
     * Method which provide the setting of the refresh color
     * from color resources
     *
     * @param backgroundColor background color resource
     * @param refreshColor    refresh color resource
     */
    public void setRefreshColoursRes(@ColorRes int backgroundColor, @ColorRes int refreshColor) {
        final ColorStateList background = ARColorHelper.getColorStateList(backgroundColor, getContext());
        final ColorStateList refresh = ARColorHelper.getColorStateList(refreshColor, getContext());
        setRefreshColoursRes(background, refresh);
    }

    /**
     * Method which provide the setting of the refresh color
     * from {@link ColorStateList}
     *
     * @param backgroundColor
     * @param refreshColor
     */
    public void setRefreshColoursRes(@Nullable final ColorStateList backgroundColor,
                                     @Nullable final ColorStateList refreshColor) {
        int[] focusedState = {android.R.attr.state_focused};
        if ((refreshColor != null)
                && (refreshLayout != null)) {
            refreshLayout.setColorSchemeColors(
                    refreshColor.getColorForState(focusedState, android.R.color.black));
        }
        if ((backgroundColor != null)
                && (refreshLayout != null)) {
            refreshLayout.setProgressBackgroundColorSchemeColor(
                    backgroundColor.getColorForState(focusedState, android.R.color.white));
        }
    }

    /**
     * Method which provide the getting of the {@link List} of the selected {@link ARObject}
     *
     * @return instance of the selected {@link List} of the {@link ARObject}
     */
    @NonNull
    public List<T> getSelectedItems() {
        if (recyclerView != null) {
            return recyclerView.getSelectedItems();
        }
        return new ArrayList<>();
    }

    /**
     * Method which provide the getting of the {@link List} of the deselected {@link ARObject}
     *
     * @return instance of the deselected {@link List} of the {@link ARObject}
     */
    @NonNull
    public List<T> getDeselectedItems() {
        if (recyclerView != null) {
            return recyclerView.getDeselectedItems();
        }
        return new ArrayList<>();
    }

    /**
     * Method which provide the getting of the {@link ARRecycleView}
     *
     * @return instance of the {@link ARRecycleView}
     */
    public ARRecycleView<T> getRecyclerView() {
        return recyclerView;
    }
}

/*HOW TO USE
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <com.artlite.adapteredrecyclerview.core.AdapteredView
        android:id="@+id/main_recycler_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:need_refresh="false"
        app:refresh_background="@color/color_primary_dark"
        app:refresh_color="@color/color_divider_black" />

</LinearLayout>
*/
