package com.recycler.view.base.adapter.using.java.multi;

import com.recycler.view.base.adapter.using.java.baseadapter.adapter.IMultiType;

class FoodMultiItem implements IMultiType {

    private Food food;
    private int itemType;

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }
}
