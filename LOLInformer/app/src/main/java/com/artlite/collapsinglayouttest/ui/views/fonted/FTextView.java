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
import com.artlite.collapsinglayouttest.core.managers.Managers;
import com.artlite.collapsinglayouttest.core.managers.impl.TypeFaceManager;

/**
 * Created by dlernatovich on 12/1/15.
 */
public class FTextView extends AppCompatTextView {
    /**
     * Constructor which provide the creating of the {@link BSButton} from
     *
     * @param context instance of {@link Context}
     */
    public FTextView(Context context) {
        super(context);
        onSetTypeface();
    }

    /**
     * Constructor which provide the creating of the {@link BSButton} from
     *
     * @param context instance of {@link Context}
     * @param attrs   instance of {@link AttributeSet}
     */
    public FTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        onSetTypeface();
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
        onSetTypeface();
    }

    /**
     * Method which provide the setting of the interface for {@link BSButton}
     */
    private void onSetTypeface() {
        if (this.isInEditMode()) {
            return;
        }
        this.setTypeface(getFontBoldItalic(), Typeface.BOLD_ITALIC);
        this.setTypeface(getFontItalic(), Typeface.ITALIC);
        this.setTypeface(getFont(), Typeface.NORMAL);
        this.setTypeface(getFontBold(), Typeface.BOLD);
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
     * Method which provide the getting text from the current component
     *
     * @return current String value
     */
    public String getStringValue() {
        return this.getText().toString().trim();
    }

    /**
     * Method which provide the getting of the default {@link Typeface}
     *
     * @return instance of {@link Typeface}
     */
    @Warning(massage = "This method should be overriden if you want to change typeface")
    protected Typeface getFont() {
        return BSTypefaceManager.getDefault();
    }

    /**
     * Method which provide the getting of the default {@link Typeface}
     *
     * @return instance of {@link Typeface}
     */
    @Warning(massage = "This method should be overriden if you want to change typeface")
    protected Typeface getFontBold() {
        return BSTypefaceManager.getDefaultBold();
    }

    /**
     * Method which provide the getting of the default {@link Typeface}
     *
     * @return instance of {@link Typeface}
     */
    @Warning(massage = "This method should be overriden if you want to change typeface")
    protected Typeface getFontItalic() {
        return BSTypefaceManager.getDefaultItalic();
    }

    /**
     * Method which provide the getting of the default {@link Typeface}
     *
     * @return instance of {@link Typeface}
     */
    @Warning(massage = "This method should be overriden if you want to change typeface")
    protected Typeface getFontBoldItalic() {
        return BSTypefaceManager.getDefaultBoldItalic();
    }
}
