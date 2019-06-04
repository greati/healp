package com.example.healt_app;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HealthInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_info);

        setTitle("Perfil de saúde");

        ListView lv = findViewById(R.id.lv_queixas);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayList items = new ArrayList();
        items.add("Dores de cabeça");
        items.add("Tosse");
        items.add("Espirros");
        items.add("Enjoo");
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        lv.setAdapter(adapter);


        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ListView lv = (ListView) parent;
                lv.setItemChecked(position, true);
                view.setBackgroundColor(Color.GRAY);
                return true;
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView lv = (ListView) parent;
                    lv.setItemChecked(position, false);
                    view.setBackgroundColor(Color.TRANSPARENT);
            }
        });
    }


}
