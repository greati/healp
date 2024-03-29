package com.example.healt_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    FoodItemAddAdapter itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_food);

        setTitle("Registrar alimentação");

        Intent i = getIntent();
        ArrayList<FoodAddItem> itemsIntent = (ArrayList<FoodAddItem>) i.getSerializableExtra("items");

        ListView lvFoodAdd = findViewById(R.id.lv_add_foods);
        items = new ArrayList();
        items.addAll(itemsIntent);

        itemsAdapter = new FoodItemAddAdapter(this, items);
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

        Button btUpdate = findViewById(R.id.bt_update_food);

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btCancel = findViewById(R.id.bt_cancel);
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onRemoveItem(int pos) {
        items.remove(pos);
        itemsAdapter.notifyDataSetChanged();
    }
}
