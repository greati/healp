package com.example.healt_app;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.healt_app.com.example.healt_app.fragments.ProfileChartsFragment;
import com.example.healt_app.com.example.healt_app.models.Patient;

public class PatientProfileActivity extends AppCompatActivity {

    private FragmentManager fragManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);

        fragManager = getSupportFragmentManager();

        Intent i = getIntent();

        Patient p = (Patient) i.getSerializableExtra("patient");

        setTitle(p.getName());

        TextView tvNome = findViewById(R.id.tv_profile_name);
        tvNome.setText(p.getName());

        final FragmentTransaction transaction = fragManager.beginTransaction();
        transaction.replace(R.id.frag_patient_charts, new ProfileChartsFragment()).commit();
    }
}
