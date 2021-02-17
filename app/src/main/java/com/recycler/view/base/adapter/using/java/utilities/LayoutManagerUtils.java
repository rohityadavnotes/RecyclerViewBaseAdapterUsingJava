package com.recycler.view.base.adapter.using.java.utilities;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class LayoutManagerUtils {

    private LayoutManagerUtils() {
        throw new UnsupportedOperationException("You can't create instance of Util class. Please use as static..");
    }

    public static LinearLayoutManager getLinearLayoutManagerVertical(Context context) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        return linearLayoutManager;
    }

    public static LinearLayoutManager getLinearLayoutManagerHorizontal(Context context) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        return linearLayoutManager;
    }

    public static GridLayoutManager getGridLayoutManagerVertical(Context context) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        return gridLayoutManager;
    }

    public static GridLayoutManager getGridLayoutManagerHorizontal(Context context) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        return gridLayoutManager;
    }

    public static StaggeredGridLayoutManager getStaggeredGridLayoutManagerVertical() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        return staggeredGridLayoutManager;
    }

    public static StaggeredGridLayoutManager getStaggeredGridLayoutManagerHorizontal() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL);
        return staggeredGridLayoutManager;
    }
}