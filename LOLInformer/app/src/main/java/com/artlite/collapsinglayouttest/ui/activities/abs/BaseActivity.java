package com.artlite.collapsinglayouttest.ui.activities.abs;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.artlite.adapteredrecyclerview.helpers.ARInjector;


/**
 * Created by dlernatovich on 7/22/15.
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    protected static final int NON_MENU_ID = -10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ARInjector.inject(this);
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
     * Bug found in some when toolbar is half-way collapsed and a touch is made on image (some phones only)
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        try {
            return super.dispatchTouchEvent(ev);
        } catch (Exception e) {
            return false;
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


    /**
     * Method which provide starting the Activity
     *
     * @param activtyClass activity which should be starting
     */
    protected void startActivity(Class activtyClass) {
        startActivity(new Intent(this, activtyClass));
    }

    /**
     * Method which provide starting the Service
     *
     * @param serviceClass service which should be starting
     */
    protected void startService(Class serviceClass) {
        if (!isMyServiceRunning(serviceClass)) {
            startService(new Intent(this, serviceClass));
        }
    }

    /**
     * Method which provide the service running checking
     *
     * @param serviceClass current service
     * @return checking results
     */
    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
