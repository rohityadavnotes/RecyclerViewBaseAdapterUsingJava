package com.recycler.view.base.adapter.using.java.baseadapter.adapter;

import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import java.util.List;

public abstract class BaseSingleItemAdapter<T, VH extends BaseViewHolder> extends BaseAdapter<T, VH> {

    public BaseSingleItemAdapter() {
    }

    public BaseSingleItemAdapter(List<T> data) {
        super(data);
    }

    protected VH onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType) {
        return createBaseViewHolder(parent, getViewHolderLayoutResId());
    }

    /**
     * The layout id of the item
     * @return
     */
    protected abstract @LayoutRes
    int getViewHolderLayoutResId();
}
