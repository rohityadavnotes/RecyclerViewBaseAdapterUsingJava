package com.recycler.view.base.adapter.using.java.multi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.recycler.view.base.adapter.using.java.R;
import com.recycler.view.base.adapter.using.java.baseadapter.listener.OnRecyclerViewItemChildClick;
import com.recycler.view.base.adapter.using.java.baseadapter.listener.OnRecyclerViewItemClick;
import com.recycler.view.base.adapter.using.java.utilities.LayoutManagerUtils;
import java.util.ArrayList;
import java.util.List;

public class MultiTypeItemTwoRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Food> foodArrayListOne;
    private ArrayList<Food> foodArrayListTwo;
    private List<FoodMultiItem> foodMultiItems;
    private MultiTypeItemRecyclerViewAdapter multiTypeItemRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_type_item_two_recycler_view);
        initializeView();
        initializeObject();
        initializeEvent();
    }

    private void initializeView() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    private void initializeObject() {
        foodArrayListOne    = new ArrayList<>();
        foodArrayListTwo    = new ArrayList<>();
        generateList();

        foodMultiItems      = new ArrayList<>();
        foodMultiItems.addAll(getList1());
        foodMultiItems.addAll(getList2());
        foodMultiItems.addAll(getList3());
        foodMultiItems.addAll(getList4());
        foodMultiItems.addAll(getList5());
        foodMultiItems.addAll(getList6());
        foodMultiItems.addAll(getList7());
        foodMultiItems.addAll(getList8());
        foodMultiItems.addAll(getList9());
        foodMultiItems.addAll(getList10());
        foodMultiItems.addAll(getList11());
        foodMultiItems.addAll(getList12());
        foodMultiItems.addAll(getList13());
        foodMultiItems.addAll(getList14());
        foodMultiItems.addAll(getList15());
        foodMultiItems.addAll(getList16());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(LayoutManagerUtils.getLinearLayoutManagerVertical(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        multiTypeItemRecyclerViewAdapter = new MultiTypeItemRecyclerViewAdapter();
        multiTypeItemRecyclerViewAdapter.addArrayList(foodMultiItems);
        recyclerView.setAdapter(multiTypeItemRecyclerViewAdapter);
    }


    private void initializeEvent() {
        multiTypeItemRecyclerViewAdapter.setOnRecyclerViewItemClick(new OnRecyclerViewItemClick<FoodMultiItem>() {
            @Override
            public void OnItemClick(View itemView, FoodMultiItem foodMultiItem, int position) {
                Toast.makeText(
                        getApplicationContext(),
                        "The position you click is ：" + position + "==" + foodMultiItem.getFood().getFoodName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        multiTypeItemRecyclerViewAdapter.setOnRecyclerViewItemChildClick(new OnRecyclerViewItemChildClick<FoodMultiItem>() {
            @Override
            public void OnItemChildClick(View viewChild, FoodMultiItem foodMultiItem, int position) {
                switch (viewChild.getId()) {
                    case R.id.foodImageViewOne:
                        Toast.makeText(
                                getApplicationContext(),
                                "You clicked on foodImageViewOne ：" + foodMultiItem.getFood().getFoodName(),
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.foodImageViewTwo:
                        Toast.makeText(
                                getApplicationContext(),
                                "You clicked on foodImageViewTwo ：" + foodMultiItem.getFood().getFoodName(),
                                Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private List<FoodMultiItem> getList1() {
        List<FoodMultiItem> multiItems = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < 3; i++) {
            index++;
            FoodMultiItem multiItem = new FoodMultiItem();
            multiItem.setFood(foodArrayListOne.get(i));
            int value = 1;
            multiItem.setItemType(value);
            multiItems.add(multiItem);
        }
        return multiItems;
    }

    private List<FoodMultiItem> getList2() {
        List<FoodMultiItem> multiItems = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < 3; i++) {
            index++;
            FoodMultiItem multiItem = new FoodMultiItem();
            multiItem.setFood(foodArrayListTwo.get(i));
            int value = 2;
            multiItem.setItemType(value);
            multiItems.add(multiItem);
        }
        return multiItems;
    }

    private List<FoodMultiItem> getList3() {
        List<FoodMultiItem> multiItems = new ArrayList<>();
        int index = 0;
        for (int i = 3; i < 6; i++) {
            index++;
            FoodMultiItem multiItem = new FoodMultiItem();
            multiItem.setFood(foodArrayListOne.get(i));
            int value = 1;
            multiItem.setItemType(value);
            multiItems.add(multiItem);
        }
        return multiItems;
    }

    private List<FoodMultiItem> getList4() {
        List<FoodMultiItem> multiItems = new ArrayList<>();
        int index = 0;
        for (int i = 3; i < 6; i++) {
            index++;
            FoodMultiItem multiItem = new FoodMultiItem();
            multiItem.setFood(foodArrayListTwo.get(i));
            int value = 2;
            multiItem.setItemType(value);
            multiItems.add(multiItem);
        }
        return multiItems;
    }

    private List<FoodMultiItem> getList5() {
        List<FoodMultiItem> multiItems = new ArrayList<>();
        int index = 0;
        for (int i = 6; i < 9; i++) {
            index++;
            FoodMultiItem multiItem = new FoodMultiItem();
            multiItem.setFood(foodArrayListOne.get(i));
            int value = 1;
            multiItem.setItemType(value);
            multiItems.add(multiItem);
        }
        return multiItems;
    }

    private List<FoodMultiItem> getList6() {
        List<FoodMultiItem> multiItems = new ArrayList<>();
        int index = 0;
        for (int i = 6; i < 9; i++) {
            index++;
            FoodMultiItem multiItem = new FoodMultiItem();
            multiItem.setFood(foodArrayListTwo.get(i));
            int value = 2;
            multiItem.setItemType(value);
            multiItems.add(multiItem);
        }
        return multiItems;
    }

    private List<FoodMultiItem> getList7() {
        List<FoodMultiItem> multiItems = new ArrayList<>();
        int index = 0;
        for (int i = 9; i < 12; i++) {
            index++;
            FoodMultiItem multiItem = new FoodMultiItem();
            multiItem.setFood(foodArrayListOne.get(i));
            int value = 1;
            multiItem.setItemType(value);
            multiItems.add(multiItem);
        }
        return multiItems;
    }

    private List<FoodMultiItem> getList8() {
        List<FoodMultiItem> multiItems = new ArrayList<>();
        int index = 0;
        for (int i = 9; i < 12; i++) {
            index++;
            FoodMultiItem multiItem = new FoodMultiItem();
            multiItem.setFood(foodArrayListTwo.get(i));
            int value = 2;
            multiItem.setItemType(value);
            multiItems.add(multiItem);
        }
        return multiItems;
    }

    private List<FoodMultiItem> getList9() {
        List<FoodMultiItem> multiItems = new ArrayList<>();
        int index = 0;
        for (int i = 12; i < 15; i++) {
            index++;
            FoodMultiItem multiItem = new FoodMultiItem();
            multiItem.setFood(foodArrayListOne.get(i));
            int value = 1;
            multiItem.setItemType(value);
            multiItems.add(multiItem);
        }
        return multiItems;
    }

    private List<FoodMultiItem> getList10() {
        List<FoodMultiItem> multiItems = new ArrayList<>();
        int index = 0;
        for (int i = 12; i < 15; i++) {
            index++;
            FoodMultiItem multiItem = new FoodMultiItem();
            multiItem.setFood(foodArrayListTwo.get(i));
            int value = 2;
            multiItem.setItemType(value);
            multiItems.add(multiItem);
        }
        return multiItems;
    }

    private List<FoodMultiItem> getList11() {
        List<FoodMultiItem> multiItems = new ArrayList<>();
        int index = 0;
        for (int i = 15; i < 18; i++) {
            index++;
            FoodMultiItem multiItem = new FoodMultiItem();
            multiItem.setFood(foodArrayListOne.get(i));
            int value = 1;
            multiItem.setItemType(value);
            multiItems.add(multiItem);
        }
        return multiItems;
    }

    private List<FoodMultiItem> getList12() {
        List<FoodMultiItem> multiItems = new ArrayList<>();
        int index = 0;
        for (int i = 15; i < 18; i++) {
            index++;
            FoodMultiItem multiItem = new FoodMultiItem();
            multiItem.setFood(foodArrayListTwo.get(i));
            int value = 2;
            multiItem.setItemType(value);
            multiItems.add(multiItem);
        }
        return multiItems;
    }

    private List<FoodMultiItem> getList13() {
        List<FoodMultiItem> multiItems = new ArrayList<>();
        int index = 0;
        for (int i = 18; i < 21; i++) {
            index++;
            FoodMultiItem multiItem = new FoodMultiItem();
            multiItem.setFood(foodArrayListOne.get(i));
            int value = 1;
            multiItem.setItemType(value);
            multiItems.add(multiItem);
        }
        return multiItems;
    }

    private List<FoodMultiItem> getList14() {
        List<FoodMultiItem> multiItems = new ArrayList<>();
        int index = 0;
        for (int i = 18; i < 20; i++) {
            index++;
            FoodMultiItem multiItem = new FoodMultiItem();
            multiItem.setFood(foodArrayListTwo.get(i));
            int value = 2;
            multiItem.setItemType(value);
            multiItems.add(multiItem);
        }
        return multiItems;
    }

    private List<FoodMultiItem> getList15() {
        List<FoodMultiItem> multiItems = new ArrayList<>();
        int index = 0;
        for (int i = 21; i < 24; i++) {
            index++;
            FoodMultiItem multiItem = new FoodMultiItem();
            multiItem.setFood(foodArrayListOne.get(i));
            int value = 1;
            multiItem.setItemType(value);
            multiItems.add(multiItem);
        }
        return multiItems;
    }

    private List<FoodMultiItem> getList16() {
        List<FoodMultiItem> multiItems = new ArrayList<>();
        int index = 0;
        for (int i = 24; i < 26; i++) {
            index++;
            FoodMultiItem multiItem = new FoodMultiItem();
            multiItem.setFood(foodArrayListOne.get(i));
            int value = 2;
            multiItem.setItemType(value);
            multiItems.add(multiItem);
        }
        return multiItems;
    }

    private void generateList() {
        /* 26 */
        foodArrayListOne.add(new Food(R.drawable.aubergine, "Aubergine", "Created By Aubergine"));
        foodArrayListOne.add(new Food(R.drawable.beer, "Beer", "Created By Beer"));
        foodArrayListOne.add(new Food(R.drawable.birthdaycake, "Birthday Cake", "Created By Birthday Cake"));
        foodArrayListOne.add(new Food(R.drawable.biscuit, "Biscuit", "Created By Biscuit"));
        foodArrayListOne.add(new Food(R.drawable.bread, "Bread", "Created By Bread"));
        foodArrayListOne.add(new Food(R.drawable.breakfast, "Breakfast", "Created By Breakfast"));
        foodArrayListOne.add(new Food(R.drawable.brochettes, "Brochettes", "Created By Brochettes"));
        foodArrayListOne.add(new Food(R.drawable.burger, "Burger", "Created By Burger"));
        foodArrayListOne.add(new Food(R.drawable.carrot, "Carrot", "Created By Carrot"));
        foodArrayListOne.add(new Food(R.drawable.cheese, "Cheese", "Created By Cheese"));
        foodArrayListOne.add(new Food(R.drawable.chicken, "Chicken", "Created By Chicken"));
        foodArrayListOne.add(new Food(R.drawable.chocolate, "Chocolate", "Created By Chocolate"));
        foodArrayListOne.add(new Food(R.drawable.cocktail, "Cocktail", "Created By Cocktail"));
        foodArrayListOne.add(new Food(R.drawable.coffee, "Coffee", "Created By Coffee"));
        foodArrayListOne.add(new Food(R.drawable.coke, "Coke", "Created By Coke"));
        foodArrayListOne.add(new Food(R.drawable.covering, "Covering", "Created By Covering"));
        foodArrayListOne.add(new Food(R.drawable.croissant, "Croissant", "Created By Croissant"));
        foodArrayListOne.add(new Food(R.drawable.cup, "Cup", "Created By Cup"));
        foodArrayListOne.add(new Food(R.drawable.cupcake, "Cupacke", "Created By Cupacke"));
        foodArrayListOne.add(new Food(R.drawable.donut, "Donut", "Created By Donut"));
        foodArrayListOne.add(new Food(R.drawable.egg, "Egg", "Created By Egg"));
        foodArrayListOne.add(new Food(R.drawable.fish, "Fish", "Created By Fish"));
        foodArrayListOne.add(new Food(R.drawable.fries, "Fries", "Created By Fries"));
        foodArrayListOne.add(new Food(R.drawable.honey, "Honey", "Created By Brown"));
        foodArrayListOne.add(new Food(R.drawable.icecream, "Icecream", "Created By Icecream"));
        foodArrayListOne.add(new Food(R.drawable.jam, "Jam", "Created By Jam"));

        /* 20 */
        foodArrayListTwo.add(new Food(R.drawable.jelly, "Jelly", "Created By Jelly"));
        foodArrayListTwo.add(new Food(R.drawable.juice, "Juice", "Created By Juice"));
        foodArrayListTwo.add(new Food(R.drawable.ketchup, "Ketchup", "Created By Ketchup"));
        foodArrayListTwo.add(new Food(R.drawable.lemon, "Lemon", "Created By Lemon"));
        foodArrayListTwo.add(new Food(R.drawable.lettuce, "Lettuce", "Created By Lettuce"));
        foodArrayListTwo.add(new Food(R.drawable.loaf, "Loaf", "Created By Loaf"));
        foodArrayListTwo.add(new Food(R.drawable.milk, "Milk", "Created By Milk"));
        foodArrayListTwo.add(new Food(R.drawable.noodles, "Noodles", "Created By Noodles"));
        foodArrayListTwo.add(new Food(R.drawable.pepper, "Pepper", "Created By Pepper"));
        foodArrayListTwo.add(new Food(R.drawable.pickles, "Pickles", "Created By Pickles"));
        foodArrayListTwo.add(new Food(R.drawable.pie, "Pie", "Created By Pie"));
        foodArrayListTwo.add(new Food(R.drawable.pizza, "Pizza", "Created By Pizza"));
        foodArrayListTwo.add(new Food(R.drawable.rice, "Rice", "Created By Rice"));
        foodArrayListTwo.add(new Food(R.drawable.sausage, "Sausage", "Created By Sausage"));
        foodArrayListTwo.add(new Food(R.drawable.spaguetti, "Spaguetti", "Created By Spaguetti"));
        foodArrayListTwo.add(new Food(R.drawable.waterglass, "Waterglass", "Created By Waterglass"));
        foodArrayListTwo.add(new Food(R.drawable.steak, "Steak", "Created By Steak"));
        foodArrayListTwo.add(new Food(R.drawable.tea, "Tea", "Created By Tea"));
        foodArrayListTwo.add(new Food(R.drawable.watermelon, "Watermelon", "Created By Watermelon"));
        foodArrayListTwo.add(new Food(R.drawable.wine, "Wine", "Created By Wine"));
    }
}