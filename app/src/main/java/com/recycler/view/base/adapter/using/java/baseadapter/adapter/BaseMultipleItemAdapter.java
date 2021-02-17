package com.recycler.view.base.adapter.using.java.baseadapter.adapter;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import java.util.List;

public abstract class BaseMultipleItemAdapter<T extends IMultiType, VH extends BaseViewHolder> extends BaseAdapter<T, VH> {

    /**
     * The mapping collection of itemType and its corresponding layout file;
     */
    private SparseIntArray itemTypeLayouts = new SparseIntArray();

    public BaseMultipleItemAdapter() {
    }

    public BaseMultipleItemAdapter(List<T> data) {
        super(data);
    }

    @Override
    public int getItemViewType(int position) {
        if (this.data != null) {
            T t = this.data.get(position);
            if (t != null) {
                return t.getItemType();
            }
        }
        return 0;
    }

    protected VH onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutResId = itemTypeLayouts.get(viewType);
        return createBaseViewHolder(parent, layoutResId);
    }

    /**
     * Add itemType and its corresponding layout file to this mapping set;
     *
     * @param viewType
     * @param layoutResId
     */
    protected void addItemType(int viewType, @LayoutRes int layoutResId) {
        itemTypeLayouts.put(viewType, layoutResId);
    }
}
