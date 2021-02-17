package com.recycler.view.base.adapter.using.java.single;

import androidx.annotation.NonNull;
import com.recycler.view.base.adapter.using.java.R;
import com.recycler.view.base.adapter.using.java.baseadapter.adapter.BaseSingleItemAdapter;
import com.recycler.view.base.adapter.using.java.baseadapter.adapter.BaseViewHolder;
import com.recycler.view.base.adapter.using.java.multi.Food;

public class SingleTypeItemRecyclerViewAdapter extends BaseSingleItemAdapter<Food, BaseViewHolder> {

    public SingleTypeItemRecyclerViewAdapter() {
        addChildClickViewIds(R.id.foodImageViewOne);
    }

    @Override
    protected int getViewHolderLayoutResId() {
        return R.layout.recycler_view_item_row_a;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder viewHolder, Food food, int position) {
        viewHolder.setImageResource(R.id.foodImageViewOne, food.getFoodImageResourceId());
        viewHolder.setText(R.id.foodNameTextViewOne, food.getFoodName());
        viewHolder.setText(R.id.foodDescriptionTextViewOne, food.getFoodDescription());
    }
}
