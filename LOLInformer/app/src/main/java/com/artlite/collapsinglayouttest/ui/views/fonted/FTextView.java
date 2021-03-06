package com.artlite.collapsinglayouttest.ui.views.fonted;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;

import com.artlite.bslibrary.annotations.Warning;
import com.artlite.bslibrary.managers.BSTypefaceManager;
import com.artlite.bslibrary.ui.fonted.BSButton;
import com.artlite.bslibrary.ui.fonted.BSTextView;

/**
 * Created by dlernatovich on 12/1/15.
 */
public class FTextView extends BSTextView {

    /**
     * Constructor which provide the creating of the {@link BSButton} from
     *
     * @param context instance of {@link Context}
     */
    public FTextView(Context context) {
        super(context);
    }

    /**
     * Constructor which provide the creating of the {@link BSButton} from
     *
     * @param context instance of {@link Context}
     * @param attrs   instance of {@link AttributeSet}
     */
    public FTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Constructor which provide the creating of the {@link BSButton} from
     *
     * @param context      instance of {@link Context}
     * @param attrs        instance of {@link AttributeSet}
     * @param defStyleAttr value of default style attributes
     */
    public FTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
