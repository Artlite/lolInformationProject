package com.artlite.collapsinglayouttest.ui.views.fonted;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;

import com.artlite.collapsinglayouttest.core.managers.TypeFaceManager;

/**
 * Created by dlernatovich on 12/1/15.
 */
public class FTextView extends TextView {
    public FTextView(Context context) {
        super(context);
        onSetTypeface();
    }

    public FTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        onSetTypeface();
    }

    public FTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        onSetTypeface();
    }

    private void onSetTypeface() {

        if (this.isInEditMode()) {
            return;
        }

        Typeface typeface = this.getTypeface();
        if (typeface != null && typeface.isBold()) {
            this.setTypeface(getBoldTypeface());
        } else {
            this.setTypeface(getDefaultTypeface());
        }
    }

    protected Typeface getDefaultTypeface() {
        return TypeFaceManager.getInstance().geBarriolFont();
    }


    protected Typeface getBoldTypeface() {
        return TypeFaceManager.getInstance().getBarriolBoldFont();
    }

    /**
     * Method which provide the formatting text from the HTML value
     *
     * @param formatedText current text
     */
    public void setTextFromHtml(String formatedText) {
        setText(Html.fromHtml(formatedText));
    }

    /**
     * Method which provide the formatting text from the HTML value
     *
     * @param stringId current text ID
     */
    public void setTextFromHtml(int stringId) {
        String formatedText = getContext().getString(stringId);
        setText(Html.fromHtml(formatedText));
    }

    /**
     * Method which provide the setting of the text with null value
     *
     * @param text current text
     */
    public void setSafeText(String text) {
        setText(String.format("%s", text));
    }

    /**
     * Method which provide the getting text from the current component
     *
     * @return current String value
     */
    public String getStringValue() {
        return this.getText().toString().trim();
    }
}
