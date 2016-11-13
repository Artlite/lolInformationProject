package com.artlite.collapsinglayouttest.core.managers;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.artlite.collapsinglayouttest.core.managers.abs.BaseManager;
import com.artlite.collapsinglayouttest.core.managers.impl.TransferManager;
import com.artlite.collapsinglayouttest.core.managers.impl.TypeFaceManager;
import com.artlite.collapsinglayouttest.utils.AppLogger;

/**
 * Created by Tatyana on 13.11.2016.
 */

public final class Managers {
    /**
     * Enumerator
     */
    private enum Manager {
        TYPE_FACE(new TypeFaceManager()),
        TRANSFERT(new TransferManager());

        private final BaseManager manager;

        /**
         * Default constructor
         *
         * @param manager
         */
        Manager(@NonNull BaseManager manager) {
            this.manager = manager;
        }

        /**
         * Method which provide the getting manager
         *
         * @param <T> manager type
         * @return
         */
        @Nullable
        public <T extends BaseManager> T getManager() {
            T result = null;
            try {
                result = (T) manager;
            } catch (Exception e) {
                AppLogger.error(this, e.toString());
            } finally {
                return result;
            }
        }
    }

    /**
     * Method which provide the getting of {@link TypeFaceManager}
     *
     * @return TypeFaceManager
     */
    @NonNull
    public static TypeFaceManager getTypeFaceManager() {
        return Manager.TYPE_FACE.getManager();
    }

    /**
     * Method which provide the getting of the {@link TransferManager}
     *
     * @return instance of {@link TransferManager}
     */
    @NonNull
    public static TransferManager getTransferManager() {
        return Manager.TRANSFERT.getManager();
    }
}
