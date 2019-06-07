package com.example.healt_app.com.example.healt_app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.healt_app.R;
import com.example.healt_app.com.example.healt_app.models.FoodAddItem;

import java.util.List;

public class FoodItemAddAdapter extends ArrayAdapter<FoodAddItem> {


    FoodItemAddListener listener;

    public FoodItemAddAdapter(Context context, int resource, int textViewResourceId, List<FoodAddItem> objects) {
        super(context,resource, textViewResourceId, objects);
    }

    public interface FoodItemAddListener {
        void onRemoveItem(int pos);
    };


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        FoodAddItem a = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.food_add_list_item, parent, false);
        }

        final int pos = position;

        TextView edtName = convertView.findViewById(R.id.et_food_list_name);
        EditText edtQtd = convertView.findViewById(R.id.et_food_list_qtd);
        ImageButton btRemove = convertView.findViewById(R.id.bt_food_list_remove);

        edtName.setText("asasas");
        edtQtd.setText("asasa");

        btRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRemoveItem(pos);
            }
        });

        return convertView;
    }
}
