package com.example.healt_app;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.healt_app.com.example.healt_app.fragments.ProfileChartsFragment;
import com.example.healt_app.com.example.healt_app.models.Patient;

public class PatientProfileActivity extends AppCompatActivity {

    private FragmentManager fragManager;
    private Patient p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);

        fragManager = getSupportFragmentManager();

        Intent i = getIntent();

        p = (Patient) i.getSerializableExtra("patient");

        setTitle(p.getName());

        TextView tvNome = findViewById(R.id.tv_profile_name);
        tvNome.setText(p.getName());

        final FragmentTransaction transaction = fragManager.beginTransaction();
        transaction.replace(R.id.frag_patient_charts, new ProfileChartsFragment()).commit();


        Button btChatPatient = findViewById(R.id.bt_chat_patient);
        btChatPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), ChatActivity.class);
                i.putExtra("patient", p);
                startActivity(i);
            }
        });


        Button btRecommPatient = findViewById(R.id.bt_recomm_patient);
        btRecommPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), CreateRecommActivity.class);
                i.putExtra("patient", p);
                startActivity(i);
            }
        });

    }
}
