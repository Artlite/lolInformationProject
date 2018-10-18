package com.artlite.collapsinglayouttest.ui.views.bar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;

import com.artlite.bslibrary.ui.view.BSView;
import com.artlite.collapsinglayouttest.R;

/**
 * Class which provide the bottom bar functional
 */
public final class ViewBottomBar extends BSView {

    /**
     * Delegate for the {@link ViewBottomBar}
     */
    public interface ViewBottomBarDelegate {

        /**
         * Method which provide the action when the view did select
         *
         * @param view  instance of the {@link ViewBottomBar}
         * @param index instance of the {@link Integer}
         */
        void viewBottomDidSelect(@NonNull final ViewBottomBar view,
                                 int index);

    }

    /**
     * Instance of the {@link ViewBottomBarDelegate}
     */
    public ViewBottomBarDelegate delegate;

    /**
     * Constructor which provide the create {@link BSView} from
     *
     * @param context instance of {@link Context}
     */
    public ViewBottomBar(Context context) {
        super(context);
    }

    /**
     * Constructor which provide the create {@link BSView} from
     *
     * @param context instance of {@link Context}
     * @param attrs   instance of {@link AttributeSet}
     */
    public ViewBottomBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Constructor which provide the create {@link BSView} from
     *
     * @param context      instance of {@link Context}
     * @param attrs        instance of {@link AttributeSet}
     * @param defStyleAttr attribute style
     */
    public ViewBottomBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Method which provide the getting of the layout ID
     *
     * @return layout ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.view_bottom_bar;
    }

    /**
     * Method which provide interface linking
     */
    @Override
    protected void onLinkInterface() {

    }

    /**
     * Method which provide the creating of the {@link View}
     */
    @Override
    protected void onCreateView() {
        this.setOnClickListeners(R.id.view_index_1, R.id.view_index_2);
    }

    /**
     * Method which provide the on click functional
     *
     * @param view instance of {@link View}
     */
    @Override
    public void onClick(View view) {
        int index = -1;
        if (view.getId() == R.id.view_index_1) {
            index = 0;
        } else if (view.getId() == R.id.view_index_2) {
            index = 1;
        }
        if (this.delegate != null) {
            this.delegate.viewBottomDidSelect(this, index);
        }
    }
}
