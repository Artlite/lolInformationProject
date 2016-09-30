package com.artlite.collapsinglayouttest.mvp.abs;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by dlernatovich on 9/30/16.
 */

public interface BaseContract {

    /**
     * Base view interface
     */
    interface BaseView {

        /**
         * Method which provide the actions when view created
         */
        void onCreateView();

        /**
         * Method which provide the action when view resumed
         */
        void onResumeView();

        /**
         * Method which provide the action when view on pause
         */
        void onPauseView();

        /**
         * Method which provide the action when view destroy
         */
        void onDestroyView();

        /**
         * Method which provide the getting of the current context
         *
         * @return context
         */
        @NonNull
        Context getCurrentContext();
    }

    /**
     * Abstract view class
     */
    abstract class BaseVewClass implements BaseView {

        /**
         * Method which provide the actions when view created
         */
        @Override
        public void onCreateView() {

        }

        /**
         * Method which provide the action when view resumed
         */
        @Override
        public void onResumeView() {

        }

        /**
         * Method which provide the action when view on pause
         */
        @Override
        public void onPauseView() {

        }

        /**
         * Method which provide the action when view destroy
         */
        @Override
        public void onDestroyView() {

        }
    }

    /**
     * Base presenter
     */
    interface BasePresenter {

    }
}
