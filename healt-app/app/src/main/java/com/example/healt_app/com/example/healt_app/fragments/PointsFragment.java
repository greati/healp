package com.example.healt_app.com.example.healt_app.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anychart.APIlib;
import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.example.healt_app.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class PointsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag_pontuacao, container, false);


        AnyChartView nutrientsChart = v.findViewById(R.id.acv_ranking);
        APIlib.getInstance().setActiveAnyChartView(nutrientsChart);

        Cartesian nutrientsColumns = AnyChart.column();

        nutrientsColumns.animation(true);
        nutrientsColumns.legend(false);
        nutrientsColumns.xAxis(true);
        nutrientsColumns.yAxis(false);

        List<DataEntry> nutrientsData = new ArrayList<>();
        nutrientsData.add(new ValueDataEntry("Você", 20));
        nutrientsData.add(new ValueDataEntry("Carlos", 14));
        nutrientsData.add(new ValueDataEntry("Paula", 10));
        nutrientsData.add(new ValueDataEntry("Maria", 4));
        nutrientsData.add(new ValueDataEntry("João", 3));
        nutrientsData.add(new ValueDataEntry("Jonas", 2));
        nutrientsData.add(new ValueDataEntry("Juliete", 2));

        nutrientsColumns.data(nutrientsData);
        nutrientsChart.setChart(nutrientsColumns);

        return v;
    }
}
