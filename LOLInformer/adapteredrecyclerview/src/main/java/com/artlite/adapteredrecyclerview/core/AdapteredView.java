package com.artlite.adapteredrecyclerview.core;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
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
import com.artlite.adapteredrecyclerview.constants.ColorStateConstants;
import com.artlite.adapteredrecyclerview.models.BaseObject;
import com.artlite.adapteredrecyclerview.ui.views.AdapteredRecyclerView;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Artli on 25.08.2016.
 */
public class AdapteredView<T extends BaseObject> extends FrameLayout {

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
                refreshColor = ColorStateConstants.K_DEFAULT_REFRESH_COLOR;
            }

            if (refreshBackgroundColor == null) {
                refreshBackgroundColor = ColorStateConstants.K_DEFAULT_REFRESH_BACKGROUND_COLOR;
            }
        }
    }

    private View baseView;
    private AdapteredRecyclerView<T> recyclerView;
    private SwipeRefreshLayout refreshLayout;
    private OnAdapteredRefreshCallback refreshCallback;

    public AdapteredView(Context context) {
        super(context);
        onInitializeView(context, null);
    }

    public AdapteredView(Context context, AttributeSet attrs) {
        super(context, attrs);
        onInitializeView(context, attrs);
    }

    public AdapteredView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onInitializeView(context, attrs);
    }

    /**
     * Method which provide the inflating of the view
     *
     * @param context  current context
     * @param layoutID layout id
     */
    private void inflateView(Context context, int layoutID) {
        LayoutInflater inflater = LayoutInflater.from(context);
        this.baseView = inflater.inflate(layoutID, this);
    }

    /**
     * Method which provide the initialize of the view
     *
     * @param context
     */
    private void onInitializeView(Context context, @Nullable AttributeSet attributeSet) {
        if (isInEditMode() == true) {
            return;
        }
        this.inflateView(context, R.layout.adaptered_view);
        this.recyclerView = (AdapteredRecyclerView) baseView.findViewById(R.id.adaptered_recycler_view);
        this.refreshLayout = (SwipeRefreshLayout) baseView.findViewById(R.id.swipe_layout);
        this.refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshCallback.onRefreshData();
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
    private void onInitiAttrs(@NonNull AttributeSet attrs, @NonNull Context context) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AdapteredView);
        if (Attributes.getInstance().isInit == false) {
            try {
                Attributes.getInstance().isNeedRefresh = a
                        .getBoolean(R.styleable.AdapteredView_need_refresh, false);
                Attributes.getInstance().refreshColor = a
                        .getColorStateList(R.styleable.AdapteredView_refresh_color);
                Attributes.getInstance().refreshBackgroundColor = a
                        .getColorStateList(R.styleable.AdapteredView_refresh_background);
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
        int[] focusedState = {android.R.attr.state_focused};
        refreshLayout.setEnabled(Attributes.getInstance().isNeedRefresh);
        refreshLayout.setColorSchemeColors(
                Attributes.getInstance().refreshColor.getColorForState(focusedState, android.R.color.black)
        );
        refreshLayout.setProgressBackgroundColorSchemeColor(
                Attributes.getInstance().refreshBackgroundColor.getColorForState(focusedState, android.R.color.white));
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
    public final void init(@NonNull RecyclerView.LayoutManager layoutManager) {
        this.init(layoutManager, null, null, null);
    }

    /**
     * Method which provide the initialize of the recycler view
     *
     * @param layoutManager layout manager
     */
    public final void init(@NonNull RecyclerView.LayoutManager layoutManager,
                           @Nullable OnAdapteredBaseCallback callback) {
        this.init(layoutManager, callback, null, null);
    }

    /**
     * Method which provide the initialize of the recycler view
     *
     * @param layoutManager layout manager
     * @param callback      action callback
     */
    public final void init(@NonNull RecyclerView.LayoutManager layoutManager,
                           @Nullable OnAdapteredBaseCallback callback,
                           @Nullable OnAdapteredRefreshCallback refreshCallback) {
        this.init(layoutManager, callback, refreshCallback, null);
    }

    /**
     * Method which provide the initialize of the recycler view
     *
     * @param layoutManager  layout manager
     * @param callback       action callback
     * @param pagingCallback paging callback
     */
    public final void init(@NonNull RecyclerView.LayoutManager layoutManager,
                           @Nullable OnAdapteredBaseCallback callback,
                           @Nullable OnAdapteredRefreshCallback refreshCallback,
                           @Nullable OnAdapteredPagingCallback pagingCallback) {
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
     * Method which provide the sorting of the objects
     *
     * @param comparator comparartor
     * @param isReverse  is need reverse
     */
    public final void sort(@NonNull final Comparator<T> comparator, final boolean isReverse) {
        this.recyclerView.sort(comparator, isReverse);
    }

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
    public final int getIndex(@Nullable T object) {
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
