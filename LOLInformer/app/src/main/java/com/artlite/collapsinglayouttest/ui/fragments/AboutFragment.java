package com.artlite.collapsinglayouttest.ui.fragments;

import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.artlite.collapsinglayouttest.R;
import com.artlite.collapsinglayouttest.ui.fragments.abs.BaseFragment;

import butterknife.InjectView;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class AboutFragment extends BaseFragment {

    @InjectView(R.id.textview_about_information)
    TextView informationTextView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_about;
    }

    @Override
    protected void onCreateFragment(View containerView) {
        informationTextView.setText(Html.fromHtml(getResources().getString(R.string.text_about)));
    }
}