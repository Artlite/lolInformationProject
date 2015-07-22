package com.artlite.collapsinglayouttest.ui.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created on 2/5/15.
 */
public class ViewPagerWithoutScroll extends ViewPager {

    private static final boolean IS_PAGING_ENABLED = false;

    public ViewPagerWithoutScroll(Context context) {
        super(context);
    }

    public ViewPagerWithoutScroll(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.IS_PAGING_ENABLED && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.IS_PAGING_ENABLED && super.onInterceptTouchEvent(event);
    }
}
