package com.example.healt_app.com.example.healt_app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healt_app.R;
import com.example.healt_app.com.example.healt_app.models.Patient;
import com.example.healt_app.com.example.healt_app.models.Recommendation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PatientChatAdapter extends BaseAdapter {

    private ArrayList<Patient> patients;
    private Context context;

    public PatientChatAdapter(Context ctx, ArrayList<Patient> recomms){
        this.patients = recomms;
        this.context = ctx;
    }

    @Override
    public int getCount() {
        return patients.size();
    }

    @Override
    public Object getItem(int position) {
        return patients.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Patient r = patients.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.patient_list_item, parent, false);
        }

        final int pos = position;

        ImageView iv = convertView.findViewById(R.id.iv_patient_talk_img);
        TextView tvName = convertView.findViewById(R.id.tv_patient_talk_name);
        TextView tvDate = convertView.findViewById(R.id.tv_patient_talk_date);

        tvName.setText(r.getName());

        SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = sdt.format(r.getDate());

        tvDate.setText(strDate);

        // check type
        iv.setImageResource(r.getImageId());

        return convertView;

    }
}
