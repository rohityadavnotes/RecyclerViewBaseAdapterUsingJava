package com.recycler.view.base.adapter.using.java.baseadapter.listener;

import android.view.View;

public interface OnRecyclerViewItemLongClick<T> {
    void OnItemLongClick(View itemView, T t, int position);
}
