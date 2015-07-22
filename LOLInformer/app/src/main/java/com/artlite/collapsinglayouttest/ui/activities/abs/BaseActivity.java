package com.artlite.collapsinglayouttest.ui.activities.abs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by dlernatovich on 7/22/15.
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    protected static final int NON_MENU_ID = -10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.inject(this);
        onCreateActivity();
    }

    /**
     * method which provide the getting of the current layout ID
     *
     * @return current layout ID
     */
    protected abstract int getLayoutId();

    /**
     * Method which provide the getting of current menu ID
     *
     * @return current menu ID
     */
    protected abstract int getMenuId();

    /**
     * Method which provide the action when the Activity was created
     */
    protected abstract void onCreateActivity();


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        int menuID = getMenuId();
        if (menuID == NON_MENU_ID) {
            return false;
        }
        getMenuInflater().inflate(menuID, menu);
        return true;
    }

    /**
     * Method which provide the setting of the OnClickListener
     *
     * @param views current list of Views
     */
    protected void setOnClickListeners(View... views) {
        for (View view : views) {
            view.setOnClickListener(this);
        }
    }

    /**
     * Method which provide the action for the OnClickListener event
     *
     * @param v current view
     */
    @Override
    public void onClick(View v) {

    }
}
