package com.recycler.view.base.adapter.using.java.multi;

public class Food {

    private int foodImageResourceId;
    private String foodName;
    public String foodDescription;

    public Food(int foodImageResourceId, String foodName, String foodDescription) {
        this.foodImageResourceId = foodImageResourceId;
        this.foodName = foodName;
        this.foodDescription = foodDescription;
    }

    public int getFoodImageResourceId() {
        return foodImageResourceId;
    }

    public void setFoodImageResourceId(int foodImageResourceId) {
        this.foodImageResourceId = foodImageResourceId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }
}