package com.kasparpeterson.simplerecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;

/**
 * Created by kaspar on 18/02/2017.
 */

class SimpleViewType {

    private final int viewType;
    private final int layoutId;
    private final Class viewHolderClass;

    /**
     * Attention! Please make sure to always provide different view types when having multiple view
     * types in same recycler view adapter. Also make sure that view types start from 0.
     */
    SimpleViewType(int viewType, int layoutId, Class viewHolderClass) {
        this.viewType = viewType;
        this.layoutId = layoutId;
        this.viewHolderClass = viewHolderClass;
    }

    int getViewTypeAsInt() {
        return viewType;
    }

    SimpleRecyclerViewAdapter.SimpleViewHolder getViewHolder(LayoutInflater layoutInflater, ViewGroup parent) throws Exception {
        View view = getView(layoutInflater, parent);
        Class<?> klass = Class.forName(viewHolderClass.getName());
        Constructor<?> constructor = klass.getConstructor(View.class);
        return (SimpleRecyclerViewAdapter.SimpleViewHolder) constructor.newInstance(view);
    }

    private View getView(LayoutInflater layoutInflater, ViewGroup parent) {
        return layoutInflater.inflate(layoutId, parent, false);
    }
}
