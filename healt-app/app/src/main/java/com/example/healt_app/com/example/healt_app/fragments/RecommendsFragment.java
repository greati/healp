package com.example.healt_app.com.example.healt_app.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.healt_app.R;
import com.example.healt_app.com.example.healt_app.adapters.RecommAdapter;
import com.example.healt_app.com.example.healt_app.models.Recommendation;

import java.util.ArrayList;

public class RecommendsFragment extends Fragment {

    private ArrayList<Recommendation> recomms;
    private RecommAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag_recommendations, container, false);

        ListView lv = v.findViewById(R.id.lv_recommendations);

        recomms = new ArrayList<>();
        recomms.add(new Recommendation("Ingira 20g de proteínas", Recommendation.Type.FOOD));
        recomms.add(new Recommendation("Beba 3L de água", Recommendation.Type.WATER));
        recomms.add(new Recommendation("Abasteça sua reserva de cálcio", Recommendation.Type.FOOD));
        recomms.add(new Recommendation("Faça um exame de sangue", Recommendation.Type.HEALTH));

        adapter = new RecommAdapter(getActivity(), recomms);

        lv.setAdapter(adapter);

        return v;
    }
}
