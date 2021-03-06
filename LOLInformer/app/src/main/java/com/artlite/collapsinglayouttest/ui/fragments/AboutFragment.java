package com.artlite.collapsinglayouttest.ui.fragments;

import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.artlite.adapteredrecyclerview.anotations.ARFindViewBy;
import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.ui.fragments.abs.BaseFragment;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class AboutFragment extends BaseFragment {

    @ARFindViewBy(id = R.id.textview_about_information)
    private TextView informationTextView;

    /**
     * Method which provide the getting of the current layout ID
     *
     * @return current layout ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_about;
    }

    /**
     * Method which provide the action when fragment is created
     *
     * @param containerView current view
     */
    @Override
    protected void onCreateFragment(View containerView) {
        informationTextView.setText(Html.fromHtml(getResources().getString(R.string.text_about)));
    }
}
