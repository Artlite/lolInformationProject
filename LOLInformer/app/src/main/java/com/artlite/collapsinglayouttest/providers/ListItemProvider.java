package com.artlite.collapsinglayouttest.providers;

import com.artlite.collapsinglayouttest.model.ListItem;
import com.artlite.collapsinglayouttest.providers.abs.BaseProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dlernatovich on 7/22/15.
 */
public class ListItemProvider implements BaseProvider<ListItem> {
    @Override
    public List<ListItem> get() {
        return new ArrayList<>(Arrays.asList(new ListItem[]{
                new ListItem("Item 1"),
                new ListItem("Item 1"),
                new ListItem("Item 1"),
                new ListItem("Item 1"),
                new ListItem("Item 1"),
                new ListItem("Item 1"),
                new ListItem("Item 1"),
                new ListItem("Item 1"),
                new ListItem("Item 1"),
                new ListItem("Item 1"),
                new ListItem("Item 1"),
                new ListItem("Item 1"),
                new ListItem("Item 1"),
                new ListItem("Item 1"),
                new ListItem("Item 1"),
                new ListItem("Item 1"),
                new ListItem("Item 1"),
                new ListItem("Item 1"),
                new ListItem("Item 1"),
                new ListItem("Item 1"),
                new ListItem("Item 1"),
                new ListItem("Item 1"),
        }));
    }
}
