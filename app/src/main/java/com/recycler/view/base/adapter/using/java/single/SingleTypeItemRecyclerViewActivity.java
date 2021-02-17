package com.recycler.view.base.adapter.using.java.single;

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
import com.recycler.view.base.adapter.using.java.multi.Food;
import com.recycler.view.base.adapter.using.java.utilities.LayoutManagerUtils;
import java.util.ArrayList;

public class SingleTypeItemRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Food> foodArrayList;
    private SingleTypeItemRecyclerViewAdapter singleTypeItemRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_type_item_recycler_view);
        initializeView();
        initializeObject();
        initializeEvent();
    }

    private void initializeView() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    private void initializeObject() {
        foodArrayList = new ArrayList<>();
        generateList();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(LayoutManagerUtils.getLinearLayoutManagerVertical(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        singleTypeItemRecyclerViewAdapter = new SingleTypeItemRecyclerViewAdapter();
        singleTypeItemRecyclerViewAdapter.addArrayList(foodArrayList);
        recyclerView.setAdapter(singleTypeItemRecyclerViewAdapter);
    }


    private void initializeEvent() {
        singleTypeItemRecyclerViewAdapter.setOnRecyclerViewItemClick(new OnRecyclerViewItemClick<Food>() {
            @Override
            public void OnItemClick(View itemView, Food food, int position) {
                Toast.makeText(
                        getApplicationContext(),
                        "The position you click is ：" + position + "==" + food.getFoodName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        singleTypeItemRecyclerViewAdapter.setOnRecyclerViewItemChildClick(new OnRecyclerViewItemChildClick<Food>() {
            @Override
            public void OnItemChildClick(View viewChild, Food food, int position) {
                switch (viewChild.getId()) {
                    case R.id.foodImageViewOne:
                        Toast.makeText(
                                getApplicationContext(),
                                "You clicked on foodImageViewOne ：" + food.getFoodName(),
                                Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void generateList() {
        foodArrayList.add(new Food(R.drawable.aubergine, "Aubergine", "Created By Aubergine"));
        foodArrayList.add(new Food(R.drawable.beer, "Beer", "Created By Beer"));
        foodArrayList.add(new Food(R.drawable.birthdaycake, "Birthday Cake", "Created By Birthday Cake"));
        foodArrayList.add(new Food(R.drawable.biscuit, "Biscuit", "Created By Biscuit"));
        foodArrayList.add(new Food(R.drawable.bread, "Bread", "Created By Bread"));
        foodArrayList.add(new Food(R.drawable.breakfast, "Breakfast", "Created By Breakfast"));
        foodArrayList.add(new Food(R.drawable.brochettes, "Brochettes", "Created By Brochettes"));
        foodArrayList.add(new Food(R.drawable.burger, "Burger", "Created By Burger"));
        foodArrayList.add(new Food(R.drawable.carrot, "Carrot", "Created By Carrot"));
        foodArrayList.add(new Food(R.drawable.cheese, "Cheese", "Created By Cheese"));
        foodArrayList.add(new Food(R.drawable.chicken, "Chicken", "Created By Chicken"));
        foodArrayList.add(new Food(R.drawable.chocolate, "Chocolate", "Created By Chocolate"));
        foodArrayList.add(new Food(R.drawable.cocktail, "Cocktail", "Created By Cocktail"));
        foodArrayList.add(new Food(R.drawable.coffee, "Coffee", "Created By Coffee"));
        foodArrayList.add(new Food(R.drawable.coke, "Coke", "Created By Coke"));
        foodArrayList.add(new Food(R.drawable.covering, "Covering", "Created By Covering"));
        foodArrayList.add(new Food(R.drawable.croissant, "Croissant", "Created By Croissant"));
        foodArrayList.add(new Food(R.drawable.cup, "Cup", "Created By Cup"));
        foodArrayList.add(new Food(R.drawable.cupcake, "Cupacke", "Created By Cupacke"));
        foodArrayList.add(new Food(R.drawable.donut, "Donut", "Created By Donut"));
        foodArrayList.add(new Food(R.drawable.egg, "Egg", "Created By Egg"));
        foodArrayList.add(new Food(R.drawable.fish, "Fish", "Created By Fish"));
        foodArrayList.add(new Food(R.drawable.fries, "Fries", "Created By Fries"));
        foodArrayList.add(new Food(R.drawable.honey, "Honey", "Created By Brown"));
        foodArrayList.add(new Food(R.drawable.icecream, "Icecream", "Created By Icecream"));
        foodArrayList.add(new Food(R.drawable.jam, "Jam", "Created By Jam"));
        foodArrayList.add(new Food(R.drawable.jelly, "Jelly", "Created By Jelly"));
        foodArrayList.add(new Food(R.drawable.juice, "Juice", "Created By Juice"));
        foodArrayList.add(new Food(R.drawable.ketchup, "Ketchup", "Created By Ketchup"));
        foodArrayList.add(new Food(R.drawable.lemon, "Lemon", "Created By Lemon"));
        foodArrayList.add(new Food(R.drawable.lettuce, "Lettuce", "Created By Lettuce"));
        foodArrayList.add(new Food(R.drawable.loaf, "Loaf", "Created By Loaf"));
        foodArrayList.add(new Food(R.drawable.milk, "Milk", "Created By Milk"));
        foodArrayList.add(new Food(R.drawable.noodles, "Noodles", "Created By Noodles"));
        foodArrayList.add(new Food(R.drawable.pepper, "Pepper", "Created By Pepper"));
        foodArrayList.add(new Food(R.drawable.pickles, "Pickles", "Created By Pickles"));
        foodArrayList.add(new Food(R.drawable.pie, "Pie", "Created By Pie"));
        foodArrayList.add(new Food(R.drawable.pizza, "Pizza", "Created By Pizza"));
        foodArrayList.add(new Food(R.drawable.rice, "Rice", "Created By Rice"));
        foodArrayList.add(new Food(R.drawable.sausage, "Sausage", "Created By Sausage"));
        foodArrayList.add(new Food(R.drawable.spaguetti, "Spaguetti", "Created By Spaguetti"));
        foodArrayList.add(new Food(R.drawable.waterglass, "Waterglass", "Created By Waterglass"));
        foodArrayList.add(new Food(R.drawable.steak, "Steak", "Created By Steak"));
        foodArrayList.add(new Food(R.drawable.tea, "Tea", "Created By Tea"));
        foodArrayList.add(new Food(R.drawable.watermelon, "Watermelon", "Created By Watermelon"));
        foodArrayList.add(new Food(R.drawable.wine, "Wine", "Created By Wine"));
    }
}