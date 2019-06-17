package com.example.healt_app.com.example.healt_app.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.healt_app.R;

public class DashboardHomeFragment extends Fragment {

    private FragmentManager manager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.dashboard_home_frag, container, false);

        manager = getActivity().getSupportFragmentManager();

        Fragment chartsFragment = new ProfileChartsFragment();
        final FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frag_dash_home_charts, chartsFragment).commit();

        return v;
    }
}
