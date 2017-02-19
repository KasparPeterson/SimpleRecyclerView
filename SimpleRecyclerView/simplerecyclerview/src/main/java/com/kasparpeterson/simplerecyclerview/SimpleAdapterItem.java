package com.kasparpeterson.simplerecyclerview;

/**
 * Created by kaspar on 18/02/2017.
 */

public abstract class SimpleAdapterItem {

    private SimpleViewType simpleViewType;

    /**
     * Attention! Please make sure to always provide different view types when having multiple view
     * types in same recycler view adapter. Keep in mind that view types must start from 0.
     */
    public SimpleAdapterItem(int viewType, int layoutId, Class viewHolderClass) {
        this.simpleViewType = new SimpleViewType(viewType, layoutId, viewHolderClass);
    }

    SimpleViewType getViewType() {
        return simpleViewType;
    }

}
