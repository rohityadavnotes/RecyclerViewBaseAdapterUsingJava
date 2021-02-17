package com.recycler.view.base.adapter.using.java.baseadapter.listener;

import android.view.View;

public interface OnRecyclerViewItemChildClick<T> {
    void OnItemChildClick(View viewChild, T t, int position);
}
