package com.artlite.collapsinglayouttest.providers.abs;

import java.util.List;

/**
 * Created by dlernatovich on 7/22/15.
 */
public interface BaseProvider<T> {
    List<T> get();
}
