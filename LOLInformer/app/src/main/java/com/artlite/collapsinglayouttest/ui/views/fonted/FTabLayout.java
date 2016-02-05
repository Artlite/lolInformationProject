package com.artlite.collapsinglayouttest.ui.views.fonted;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.core.managers.TypeFaceManager;

/**
 * Created by dlernatovich on 12/2/15.
 */
public class FTabLayout extends android.support.design.widget.TabLayout {

    private Typeface currentTypeface;

    public FTabLayout(Context context) {
        super(context);
        onCreate();
    }

    public FTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        onCreate();
    }

    public FTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onCreate();
    }

    /**
     * Method which provide the actions when view will be create
     */
    private void onCreate() {

        if (this.isInEditMode()) {
            return;
        }

        currentTypeface = TypeFaceManager.getInstance().getBarriolBoldFont();
    }

    @Override
    public void addTab(Tab tab) {
        super.addTab(tab);

        //Functional which provide the replacing of the font typeface in the tab bar
        ViewGroup mainView = (ViewGroup) getChildAt(0);
        ViewGroup tabView = (ViewGroup) mainView.getChildAt(tab.getPosition());

        int tabChildCount = tabView.getChildCount();
        for (int i = 0; i < tabChildCount; i++) {
            View tabViewChild = tabView.getChildAt(i);
            if (tabViewChild instanceof TextView) {
                TextView textView = (TextView) tabViewChild;
                textView.setTypeface(currentTypeface, Typeface.NORMAL);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.text_16));
            }
        }
    }
}
