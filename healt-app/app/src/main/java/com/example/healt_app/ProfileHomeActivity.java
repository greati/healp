package com.example.healt_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ProfileHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_home);

        setTitle("Atualizar perfil");


        ImageView iVprofileAvatar = findViewById(R.id.profile_avatar);
        iVprofileAvatar.setImageDrawable(getResources().getDrawable(R.drawable.paula_santos));

        LinearLayout btPersonalInfo = findViewById(R.id.bt_personal_info);
        btPersonalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PersonalInfoActivity.class);
                startActivity(i);
            }
        });

        LinearLayout btHealthInfo = findViewById(R.id.bt_health_profile);
        btHealthInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), HealthInfoActivity.class);
                startActivity(i);
            }
        });


        LinearLayout btFoodProfile = findViewById(R.id.bt_food_profile);
        btFoodProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), FoodInfoActivity.class);
                startActivity(i);
            }
        });

    }


}
