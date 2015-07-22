package com.artlite.collapsinglayouttest.ui.views;

import android.content.Context;
import android.widget.TextView;

import com.artlite.collapsinglayouttest.R;

import butterknife.InjectView;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class MainRecycleItem extends BaseView {

    @InjectView(R.id.textview_main)
    public TextView mainTextView;

    public MainRecycleItem(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.recycle_item_main;
    }

    @Override
    protected void onCreateView() {

    }
}
