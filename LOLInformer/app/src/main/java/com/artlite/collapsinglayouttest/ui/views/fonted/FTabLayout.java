package com.artlite.collapsinglayouttest.ui.views.fonted;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.artlite.bslibrary.managers.BSTypefaceManager;
import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.core.managers.Managers;
import com.artlite.collapsinglayouttest.core.managers.impl.TypeFaceManager;

/**
 * Created by dlernatovich on 12/2/15.
 */
public class FTabLayout extends android.support.design.widget.TabLayout {

    /**
     * Method which provide to create the {@link FTabLayout} with parameters
     *
     * @param context instance of the {@link Context}
     */
    public FTabLayout(Context context) {
        super(context);
    }

    /**
     * Method which provide to create the {@link FTabLayout} with parameters
     *
     * @param context instance of the {@link Context}
     * @param attrs   instance of the {@link AttributeSet}
     */
    public FTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Method which provide to create the {@link FTabLayout} with parameters
     *
     * @param context      instance of the {@link Context}
     * @param attrs        instance of the {@link AttributeSet}
     * @param defStyleAttr instance of the {@link Integer}
     */
    public FTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Add a tab to this layout. The tab will be inserted at <code>position</code>.
     *
     * @param tab         The tab to add
     * @param position    The new position of the tab
     * @param setSelected True if the added tab should become the selected tab.
     */
    @Override
    public void addTab(@NonNull Tab tab, int position, boolean setSelected) {
        super.addTab(tab, position, setSelected);
        ViewGroup mainView = (ViewGroup) getChildAt(0);
        ViewGroup tabView = (ViewGroup) mainView.getChildAt(tab.getPosition());
        int tabChildCount = tabView.getChildCount();
        for (int i = 0; i < tabChildCount; i++) {
            View tabViewChild = tabView.getChildAt(i);
            if (tabViewChild instanceof TextView) {
                TextView textView = (TextView) tabViewChild;
                textView.setTypeface(BSTypefaceManager.getDefaultBold());
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                        getResources().getDimensionPixelSize(R.dimen.text_5));
            }
        }
    }
}
