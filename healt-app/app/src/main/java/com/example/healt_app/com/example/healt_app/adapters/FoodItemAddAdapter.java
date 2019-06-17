package com.example.healt_app.com.example.healt_app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.healt_app.R;
import com.example.healt_app.com.example.healt_app.models.FoodAddItem;

import java.util.ArrayList;
import java.util.List;

public class FoodItemAddAdapter extends BaseAdapter {


    FoodItemAddListener listener;

    private ArrayList<FoodAddItem> items;
    private Context context;

    public FoodItemAddAdapter(Context context, ArrayList<FoodAddItem> items) {
        this.items = items;
        this.context = context;
        listener = (FoodItemAddListener) context;
    }

    public interface FoodItemAddListener {
        void onRemoveItem(int pos);
    };


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        FoodAddItem a = items.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.food_add_list_item, parent, false);
        }

        final int pos = position;

        TextView edtName = convertView.findViewById(R.id.et_food_list_name);
        EditText edtQtd = convertView.findViewById(R.id.et_food_list_qtd);
        ImageButton btRemove = convertView.findViewById(R.id.bt_food_list_remove);

        edtName.setText(a.getName());
        edtQtd.setText(String.valueOf(a.getQtd()));

        btRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRemoveItem(pos);
            }
        });

        return convertView;
    }
}
