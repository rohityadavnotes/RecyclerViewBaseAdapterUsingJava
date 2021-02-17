package com.recycler.view.base.adapter.using.java.baseadapter.listener;

import android.view.View;

public interface OnRecyclerViewItemClick<T> {
    void OnItemClick(View itemView, T t, int position);
}
