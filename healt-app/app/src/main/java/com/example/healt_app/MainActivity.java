package com.example.healt_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.healt_app.com.example.healt_app.fragments.DashboardHomeFragment;
import com.example.healt_app.com.example.healt_app.fragments.PointsFragment;
import com.example.healt_app.com.example.healt_app.fragments.RecommendsFragment;

public class MainActivity extends AppCompatActivity {
    //private TextView mTextMessage;

    private FragmentManager fragManager;
    private Fragment fragment = null;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    fragment = new DashboardHomeFragment();
                    break;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    fragment = new PointsFragment();
                    break;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    fragment = new RecommendsFragment();
                    break;
                default:
                    fragment = null;
            }

            if (fragment != null) {
                final FragmentTransaction transaction = fragManager.beginTransaction();
                transaction.replace(R.id.dash_fragment_holder, fragment).commit();
                return true;
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        //mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fragManager = getSupportFragmentManager();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.dash_toolbar);
        setSupportActionBar(myToolbar);

        final FragmentTransaction transaction = fragManager.beginTransaction();
        transaction.replace(R.id.dash_fragment_holder, new DashboardHomeFragment()).commit();

        setTitle("Dashboard");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        ((MenuInflater) inflater).inflate(R.menu.dash_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.menu_my_profile: {
                Intent i = new Intent(this, ProfileHomeActivity.class);
                startActivity(i);
                return true;
            }
            case R.id.menu_register_food: {
                Intent i = new Intent(this, RegisterFoodImageActivity.class);
                startActivity(i);
                return true;
            }
            case R.id.menu_patients: {
                Intent i = new Intent(this, PatientChatActivity.class);
                startActivity(i);
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
