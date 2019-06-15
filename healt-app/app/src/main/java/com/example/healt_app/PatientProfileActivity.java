package com.example.healt_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.healt_app.com.example.healt_app.models.Patient;

public class PatientProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);

        Intent i = getIntent();

        Patient p = (Patient) i.getSerializableExtra("patient");

        setTitle(p.getName());

        TextView tvNome = findViewById(R.id.tv_profile_name);
        tvNome.setText(p.getName());
    }
}
