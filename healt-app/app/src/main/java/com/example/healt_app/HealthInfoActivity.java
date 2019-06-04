package com.example.healt_app;

import android.graphics.Color;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.healt_app.com.example.healt_app.dialog.ExamAddDialog;
import com.example.healt_app.com.example.healt_app.fragments.DatePickerFragment;

import java.util.ArrayList;

public class HealthInfoActivity extends AppCompatActivity implements ExamAddDialog.ExamAddDialogListener {

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

        Button btAddExam = findViewById(R.id.bt_add_exam);
        btAddExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExamAddDialog dialog = new ExamAddDialog();
                dialog.show(getSupportFragmentManager(), "ExamAddDialog");
            }
        });

    }


    @Override
    public void onExamAddClick(DialogFragment dialog) {

    }
}
