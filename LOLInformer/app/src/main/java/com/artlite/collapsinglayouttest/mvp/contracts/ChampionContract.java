package com.artlite.collapsinglayouttest.mvp.contracts;

import android.support.annotation.NonNull;

import com.artlite.collapsinglayouttest.model.Champion;
import com.artlite.collapsinglayouttest.mvp.abs.BaseContract;

import java.util.List;

/**
 * Contract which provide the champion displaying
 * Created by dlernatovich on 9/30/16.
 */

public interface ChampionContract {

    /**
     * Champion view
     */
    interface View extends BaseContract.BaseView {
        /**
         * Method which provide the champions setting
         *
         * @param champions list of champions
         */
        void setChampions(@NonNull final List<Champion> champions);

        /**
         * Method which provide the action when champion click
         *
         * @param champion champion
         */
        void onChampionClick(@NonNull final Champion champion);
    }

    /**
     * Champion class
     */
    abstract class ViewClass extends BaseContract.BaseVewClass implements View {
    }

    /**
     * Champion presenter
     */
    interface Presenter extends BaseContract.BasePresenter {
        /**
         * Method which provide the getting of the column count
         *
         * @return column count
         */
        int getColumnCount();
    }

}
