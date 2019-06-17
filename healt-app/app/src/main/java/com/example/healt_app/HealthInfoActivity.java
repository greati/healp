package com.example.healt_app;

import android.graphics.Color;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
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

    ArrayList<String> exams = new ArrayList();
    ListView lv_exams;
    ArrayAdapter<String> exams_adapter;

    ArrayList<Integer> selected_exams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_info);

        setTitle("Perfil de saúde");

        ListView lv = findViewById(R.id.lv_queixas);
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ArrayList hproblems = new ArrayList();
        hproblems.add("Dores de cabeça");
        hproblems.add("Tosse");
        hproblems.add("Espirros");
        hproblems.add("Enjoo");
        ListAdapter hproblems_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, hproblems);
        lv.setAdapter(hproblems_adapter);

        selected_exams  = new ArrayList<>();

        exams.add("10/10/2018 - Exame de sangue");
        exams.add("10/12/2018 - Exame de urina");

        lv_exams = findViewById(R.id.lv_exams);
        exams_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, exams);
        lv_exams.setAdapter(exams_adapter);
        lv_exams.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

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

        lv_exams.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ListView lv = (ListView) parent;
                lv.setItemChecked(position, true);
                view.setBackgroundColor(Color.GRAY);
                selected_exams.add(position);
                return true;
            }
        });

        Button btRemoveExam = findViewById(R.id.bt_remove_exam);
        btRemoveExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<String> keep_exams = new ArrayList<>(exams);

                for (Integer p : selected_exams) {
                    Log.i("aaa", p.toString());
                    keep_exams.remove(p.intValue());
                }

                for (int i=0; i < lv_exams.getCount(); ++i) {
                    View view = lv_exams.getChildAt(i);
                    view.setBackgroundColor(Color.TRANSPARENT);
                }

                exams.clear();
                exams.addAll(keep_exams);
                selected_exams.clear();

                exams_adapter.notifyDataSetChanged();
            }
        });

        Button btUpdateProfile = findViewById(R.id.bt_update_profile);

        btUpdateProfile.setOnClickListener(new View.OnClickListener() {
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
    public void onExamAddClick(DialogFragment dialog, String date, String name) {
        exams.add(date + " - " + name);
        exams_adapter.notifyDataSetChanged();
    }
}
