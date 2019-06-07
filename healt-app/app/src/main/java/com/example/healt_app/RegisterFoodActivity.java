package com.example.healt_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.healt_app.com.example.healt_app.adapters.FoodItemAddAdapter;
import com.example.healt_app.com.example.healt_app.models.FoodAddItem;

import java.util.ArrayList;

public class RegisterFoodActivity extends AppCompatActivity implements FoodItemAddAdapter.FoodItemAddListener {

    ArrayList<FoodAddItem> items;
    ArrayAdapter<FoodAddItem> itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_food);

        setTitle("Registrar alimentação");

        ListView lvFoodAdd = findViewById(R.id.lv_add_foods);
        items = new ArrayList();
        items.add(new FoodAddItem("oi", 239.0));
        items.add(new FoodAddItem("oi", 239.0));
        items.add(new FoodAddItem("oi", 239.0));
        items.add(new FoodAddItem("oi", 239.0));
        itemsAdapter = new ArrayAdapter<FoodAddItem>(this, R.layout.food_add_list_item, R.id.et_food_list_name, items);
        lvFoodAdd.setAdapter(itemsAdapter);

        ImageButton btAddFood = findViewById(R.id.bt_food_list_add);
        btAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tvNome = findViewById(R.id.et_food_list_name_add);
                EditText tvQtd = findViewById(R.id.et_food_list_qtd_add);
                FoodAddItem fai = new FoodAddItem(tvNome.getText().toString(), Double.valueOf(tvQtd.getText().toString()));
                items.add(fai);
                itemsAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onRemoveItem(int pos) {

    }
}
