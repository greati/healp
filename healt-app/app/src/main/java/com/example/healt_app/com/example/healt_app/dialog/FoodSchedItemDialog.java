package com.example.healt_app.com.example.healt_app.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.healt_app.R;

import java.util.ArrayList;

public class FoodSchedItemDialog extends DialogFragment {

    private ArrayList<String> components;
    private ArrayAdapter<String> comps_adapter;

    private TextView tvNewCompName;
    ArrayList<Integer> selected_comps;

    public FoodSchedItemDialog() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.dialog_food_sched_add, null);

        Spinner spHours = v.findViewById(R.id.sp_food_sched_time);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(v.getContext(),
                R.array.hours_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spHours.setAdapter(adapter);

        components = new ArrayList<>();

        comps_adapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, components);

        tvNewCompName = v.findViewById(R.id.tv_food_comp_new);

        selected_comps = new ArrayList<>();

        final ListView lvComps = v.findViewById(R.id.lv_food_sched_comps);
        lvComps.setAdapter(comps_adapter);

        Button btAddComp = v.findViewById(R.id.bt_add_food_comp);
        btAddComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = tvNewCompName.getText().toString();
                tvNewCompName.setText("");
                components.add(name);
                comps_adapter.notifyDataSetChanged();
            }
        });

        lvComps.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ListView lv = (ListView) parent;
                lv.setItemChecked(position, true);
                view.setBackgroundColor(Color.GRAY);
                selected_comps.add(position);
                return true;
            }
        });

        Button btRemoveExam = v.findViewById(R.id.bt_remove_food_comp);
        btRemoveExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<String> keep_exams = new ArrayList<>(components);

                for (Integer p : selected_comps) {
                    keep_exams.remove(p.intValue());
                }

                for (int i=0; i < lvComps.getCount(); ++i) {
                    View view = lvComps.getChildAt(i);
                    view.setBackgroundColor(Color.TRANSPARENT);
                }

                components.clear();
                components.addAll(keep_exams);
                selected_comps.clear();

                comps_adapter.notifyDataSetChanged();
            }
        });


        builder.setView(v)
                .setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        return builder.create();
    }
}