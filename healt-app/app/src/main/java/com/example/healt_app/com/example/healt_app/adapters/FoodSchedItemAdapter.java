package com.example.healt_app.com.example.healt_app.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.healt_app.R;
import com.example.healt_app.com.example.healt_app.models.FoodScheduleItem;

import java.util.ArrayList;

public class FoodSchedItemAdapter extends ArrayAdapter<FoodScheduleItem> {


    public FoodSchedItemAdapter(Context context, int resource, FoodScheduleItem[] objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        FoodScheduleItem a = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.food_schedule_list_item, parent, false);
        }

        TextView time = convertView.findViewById(R.id.tv_food_sched_time);
        TextView name = convertView.findViewById(R.id.tv_food_sched_name);
        ListView lvComps = convertView.findViewById(R.id.lv_food_sched_components);

        time.setText(a.getTime());
        name.setText(a.getName());

        ArrayAdapter<String> foodComponents = new ArrayAdapter<String>(parent.getContext(), android.R.layout.simple_list_item_1, a.getComponents());
        lvComps.setAdapter(foodComponents);

        return convertView;
    }

}
