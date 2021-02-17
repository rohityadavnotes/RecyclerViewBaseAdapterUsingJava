package com.recycler.view.base.adapter.using.java.baseadapter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.recycler.view.base.adapter.using.java.baseadapter.listener.OnRecyclerViewItemChildClick;
import com.recycler.view.base.adapter.using.java.baseadapter.listener.OnRecyclerViewItemChildLongClick;
import com.recycler.view.base.adapter.using.java.baseadapter.listener.OnRecyclerViewItemClick;
import com.recycler.view.base.adapter.using.java.baseadapter.listener.OnRecyclerViewItemLongClick;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public abstract class BaseAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {

    protected List<T> data = new ArrayList<T>();

    /*
     ***********************************************************************************************
     ******************************************* Constructor ***************************************
     ***********************************************************************************************
     */
    public BaseAdapter() {
    }

    public BaseAdapter(List<T> dataList) {
        if (dataList != null) {
            this.data = dataList;
        }
    }
    /*
     ***********************************************************************************************
     ************************************** CRUD Operation Methods *********************************
     ***********************************************************************************************
     */
    public void addSingleItem(T item) {
        if (item != null) {
            data.add(item);
            notifyItemInserted(data.size() - 1);
        }
    }

    public void addSingleItemAtSpecificPosition(T item, int position) {
        if (item != null) {
            data.add(position, item);
            notifyItemInserted(position);
        }
    }

    public void addArrayList(List<T> items) {
        if (items != null) {
            data.addAll(items);
            notifyDataSetChanged();
        }
    }

    public void replaceArrayList(List<T> items) {
        if (items != null) {
            data.clear();
            addArrayList(items);
        }
    }

    public void addArray(T[] items) {
        if (items != null) {
            addArrayList(Arrays.asList(items));
            notifyDataSetChanged();
        }
    }

    public void addOrUpdateSingleItem(T item) {
        if (item != null) {
            int i = data.indexOf(item);
            if (i >= 0) {
                data.set(i, item);
                notifyItemChanged(i);
            } else {
                addSingleItem(item);
            }
        }
    }

    public void addOrUpdateArrayList(List<T> items) {
        if (items != null) {
            for (T item : items) {
                addOrUpdateSingleItem(item);
            }
            notifyDataSetChanged();
        }
    }

    public T getSingleItemUsingPosition(int position) {
        return data.get(position);
    }

    public void removeSingleItemUsingPosition(int position) {
        if (position >= 0 && position < data.size()) {
            data.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void removeSingleItem(T item) {
        if (item != null) {
            int position = data.indexOf(item);
            removeSingleItemUsingPosition(position);
        }
    }

    public void clearAllItem() {
        data.clear();
        notifyDataSetChanged();
    }

    private T getDataByPosition(int position) {
        T t = null;
        if (position != RecyclerView.NO_POSITION) {
            t = data.get(position);
        }
        return t;
    }
    /*
     ***********************************************************************************************
     ******************* Implemented methods form RecyclerView.ViewHolder class ********************
     ***********************************************************************************************
     */
    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        }
        return 0;
    }

    protected VH createBaseViewHolder(@NonNull ViewGroup parent, @LayoutRes int layoutResId) {
        VH viewHolder = (VH) new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false));
        return viewHolder;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        VH viewHolder = (VH) onCreateDefViewHolder(parent, viewType);
        bindViewClickListener(viewHolder, viewType);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VH viewHolder, int position) {
        T t = data.get(position);
        convert(viewHolder, t, position);
    }
    /*
     ***********************************************************************************************
     ****************************************** Click Events ***************************************
     ***********************************************************************************************
     */

    /**
     * Click event of row
     * Example : R.layout.recycler_view_item_row_a
     */
    protected OnRecyclerViewItemClick mOnRecyclerViewItemClick;

    /**
     * Long press event of row
     * Example : R.layout.recycler_view_item_row_a
     */
    protected OnRecyclerViewItemLongClick mOnRecyclerViewItemLongClick;

    /**
     * The click event of view
     * Example : foodImageView, foodNameTextView, foodDescriptionTextView
     */
    protected OnRecyclerViewItemChildClick mOnRecyclerViewItemChildClick;

    /**
     * The long press event of view
     * Example : foodImageView, foodNameTextView, foodDescriptionTextView
     */
    protected OnRecyclerViewItemChildLongClick mOnRecyclerViewItemChildLongClick;

    /**
     * Used to save the ViewId of the click event that needs to be set
     */
    protected LinkedHashSet<Integer> childClickViewIds;

    /**
     * Used to save the ViewId that needs to be set for the long press click event
     */
    protected LinkedHashSet<Integer> childLongClickViewIds;

    public void setOnRecyclerViewItemClick(OnRecyclerViewItemClick<T> onRecyclerViewItemClick) {
        mOnRecyclerViewItemClick = onRecyclerViewItemClick;
    }

    public void setOnRecyclerViewItemLongClick(OnRecyclerViewItemLongClick<T> onRecyclerViewItemLongClick) {
        mOnRecyclerViewItemLongClick = onRecyclerViewItemLongClick;
    }

    public void setOnRecyclerViewItemChildClick(OnRecyclerViewItemChildClick<T> onRecyclerViewItemChildClick) {
        mOnRecyclerViewItemChildClick = onRecyclerViewItemChildClick;
    }

    public void setOnRecyclerViewItemChildLongClick(OnRecyclerViewItemChildLongClick<T> onRecyclerViewItemChildLongClick) {
        mOnRecyclerViewItemChildLongClick = onRecyclerViewItemChildLongClick;
    }

    /**
     * Binding monitoring events
     *
     * @param viewHolder
     * @param viewType
     */
    private void bindViewClickListener(VH viewHolder, int viewType) {
        bindViewItemClickListener(viewHolder);
        bindViewItemChildClickListener(viewHolder);
    }

    private void bindViewItemChildClickListener(VH viewHolder) {
        if (mOnRecyclerViewItemChildClick != null && childClickViewIds != null) {
            for (int viewId : childClickViewIds) {
                View viewChild = viewHolder.getViewOrNull(viewId);
                if (viewChild != null) {
                    viewChild.setOnClickListener(v -> {
                        int position = viewHolder.getAdapterPosition();
                        T t = getDataByPosition(position);
                        mOnRecyclerViewItemChildClick.OnItemChildClick(v, t, position);
                    });
                }
            }
        }
        if (mOnRecyclerViewItemChildLongClick != null && childLongClickViewIds != null) {
            for (int viewId : childLongClickViewIds) {
                View viewChild = viewHolder.getViewOrNull(viewId);
                if (viewChild != null) {
                    viewChild.setOnLongClickListener(v -> {
                        int position = viewHolder.getAdapterPosition();
                        T t = getDataByPosition(position);
                        mOnRecyclerViewItemChildLongClick.OnItemChildLongClick(v, t, position);
                        return true;
                    });
                }
            }
        }
    }

    private void bindViewItemClickListener(VH viewHolder) {
        if (mOnRecyclerViewItemClick != null) {
            viewHolder.itemView.setOnClickListener(v -> {
                int position = viewHolder.getAdapterPosition();
                T t = getDataByPosition(position);
                mOnRecyclerViewItemClick.OnItemClick(v, t, position);
            });
        }
        if (mOnRecyclerViewItemLongClick != null) {
            viewHolder.itemView.setOnLongClickListener(v -> {
                int position = viewHolder.getAdapterPosition();
                T t = getDataByPosition(position);
                mOnRecyclerViewItemLongClick.OnItemLongClick(v, t, position);
                return true;
            });
        }
    }

    /**
     * Set the child view that needs to click event
     *
     * @param viewIds intArray
     */
    protected void addChildClickViewIds(@IdRes int... viewIds) {
        if (childClickViewIds == null) {
            childClickViewIds = new LinkedHashSet<>();
        }
        for (int viewId : viewIds) {
            childClickViewIds.add(viewId);
        }
    }

    /**
     * Set the child view that needs to press and hold the click event
     *
     * @param viewIds intArray
     */
    protected void addChildLongClickViewIds(@IdRes int... viewIds) {
        if (childLongClickViewIds == null) {
            childLongClickViewIds = new LinkedHashSet<>();
        }
        for (int viewId : viewIds) {
            childLongClickViewIds.add(viewId);
        }
    }

    /*
     ***********************************************************************************************
     ****************************************** Abstract methods ***********************************
     ***********************************************************************************************
     */
    protected abstract VH onCreateDefViewHolder(@NonNull ViewGroup parent, int viewType);
    protected abstract void convert(@NonNull VH viewHolder, T t, int position);
}
