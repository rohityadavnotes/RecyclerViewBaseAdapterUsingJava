package com.recycler.view.base.adapter.using.java.multi;

import androidx.annotation.NonNull;
import com.recycler.view.base.adapter.using.java.R;
import com.recycler.view.base.adapter.using.java.baseadapter.adapter.BaseMultipleItemAdapter;
import com.recycler.view.base.adapter.using.java.baseadapter.adapter.BaseViewHolder;

public class MultiTypeItemRecyclerViewAdapter extends BaseMultipleItemAdapter<FoodMultiItem, BaseViewHolder> {

    public MultiTypeItemRecyclerViewAdapter() {
        addItemType(1, R.layout.recycler_view_item_row_a);
        addItemType(2, R.layout.recycler_view_item_row_b);
        addChildClickViewIds(R.id.foodImageViewOne, R.id.foodImageViewTwo);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder viewHolder, FoodMultiItem foodMultiItem, int position) {
        Food food = foodMultiItem.getFood();
        int itemViewType = viewHolder.getItemViewType();
        switch (itemViewType) {
            case 1:
                viewHolder.setImageResource(R.id.foodImageViewOne, food.getFoodImageResourceId());
                viewHolder.setText(R.id.foodNameTextViewOne, food.getFoodName());
                viewHolder.setText(R.id.foodDescriptionTextViewOne, food.getFoodDescription());
                break;
            case 2:
                viewHolder.setImageResource(R.id.foodImageViewTwo, food.getFoodImageResourceId());
                viewHolder.setText(R.id.foodNameTextViewTwo, food.getFoodName());
                viewHolder.setText(R.id.foodDescriptionTextViewTwo, food.getFoodDescription());
                break;
            default:
                break;
        }
    }
}
