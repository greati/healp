package com.example.healt_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.healt_app.com.example.healt_app.adapters.PatientChatAdapter;
import com.example.healt_app.com.example.healt_app.models.Patient;

import java.util.ArrayList;
import java.util.Date;

public class PatientChatActivity extends AppCompatActivity {

    private ArrayList<Patient> patients;
    private PatientChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_chat);

        ListView lvChat = findViewById(R.id.lv_patient_chat);

        patients = new ArrayList<Patient>();
        patients.add(new Patient("Carlos", new Date(), R.drawable.ic_user_md_solid));
        patients.add(new Patient("Pedro", new Date(), R.drawable.ic_user_md_solid));

        adapter = new PatientChatAdapter(this, patients);
        lvChat.setAdapter(adapter);

        lvChat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Patient p = patients.get(position);
                Intent i = new Intent(view.getContext(), PatientProfileActivity.class);
                i.putExtra("patient", p);
                startActivity(i);
            }
        });

        setTitle("Pacientes");
    }
}
