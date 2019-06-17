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
import com.anychart.charts.Cartesian3d;
import com.anychart.charts.Pie;
import com.anychart.core.cartesian.series.Line;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Align;
import com.anychart.enums.Anchor;
import com.anychart.enums.LegendLayout;
import com.anychart.enums.MarkerType;
import com.example.healt_app.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileChartsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag_profile_charts, container, false);


        AnyChartView pieChartToday = v.findViewById(R.id.acv_pie_chart_patient);
        pieChartToday.setProgressBar(v.findViewById(R.id.progress_bar));

        APIlib.getInstance().setActiveAnyChartView(pieChartToday);

        Pie pie = AnyChart.pie();
        pie.animation(true);
        List<DataEntry> pieTodayData = new ArrayList<>();
        pieTodayData.add(new ValueDataEntry("Cumpridas", 7));
        pieTodayData.add(new ValueDataEntry("A cumprir", 3));

        pie.data(pieTodayData);
        pie.title("Metas do dia");
        pie.legend(false);

        pieChartToday.setChart(pie);

        AnyChartView nutrientsChart = v.findViewById(R.id.acv_nutrients_chart_patient);
        APIlib.getInstance().setActiveAnyChartView(nutrientsChart);

        Cartesian nutrientsColumns = AnyChart.column();

        nutrientsColumns.title("Nutrientes");

        nutrientsColumns.animation(true);
        nutrientsColumns.legend(false);

        List<DataEntry> nutrientsData = new ArrayList<>();
        nutrientsData.add(new ValueDataEntry("Carboidratos", 20));
        nutrientsData.add(new ValueDataEntry("Proteínas", 10));
        nutrientsData.add(new ValueDataEntry("Vitaminas", 14));
        nutrientsData.add(new ValueDataEntry("Lipídios", 5));

        nutrientsColumns.data(nutrientsData);
        nutrientsChart.setChart(nutrientsColumns);


        AnyChartView monthNutrientsLineChart = v.findViewById(R.id.acv_nutrients_month_chart_patient);
        APIlib.getInstance().setActiveAnyChartView(monthNutrientsLineChart);

        Cartesian monthNutrientsLine = AnyChart.line();

        monthNutrientsLine.title("Nutrientes");

        monthNutrientsLine.animation(true);

        monthNutrientsLine.padding(10d, 20d, 5d, 20d);
        List<DataEntry> seriesData = new ArrayList<>();
        seriesData.add(new CustomDataEntry("jan", 3.6, 2.3, 2.8, 3.0));
        seriesData.add(new CustomDataEntry("fev", 1.0, 5.0, 8.0, 1.0));
        seriesData.add(new CustomDataEntry("mar", 9.0, 3.0, 4.0, 10.0));
        seriesData.add(new CustomDataEntry("abr", 2.0, 1.0, 3.0, 5.0));
        seriesData.add(new CustomDataEntry("mai", 1.0, 5.0, 13.0, 2.0));

        Set set = Set.instantiate();
        set.data(seriesData);
        Mapping series1Mapping = set.mapAs("{ x: 'x', value: 'value' }");
        Mapping series2Mapping = set.mapAs("{ x: 'x', value: 'value2' }");
        Mapping series3Mapping = set.mapAs("{ x: 'x', value: 'value3' }");
        Mapping series4Mapping = set.mapAs("{ x: 'x', value: 'value4' }");

        Line series1 = monthNutrientsLine.line(series1Mapping);
        series1.name("Carboidratos");
        series1.hovered().markers().enabled(true);
        series1.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4d);
        series1.tooltip()
                .position("right")
                .anchor(Anchor.LEFT_CENTER)
                .offsetX(5d)
                .offsetY(5d);

        Line series2 = monthNutrientsLine.line(series2Mapping);
        series2.name("Proteínas");
        series2.hovered().markers().enabled(true);
        series2.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4d);
        series2.tooltip()
                .position("right")
                .anchor(Anchor.LEFT_CENTER)
                .offsetX(5d)
                .offsetY(5d);

        Line series3 = monthNutrientsLine.line(series3Mapping);
        series3.name("Vitaminas");
        series3.hovered().markers().enabled(true);
        series3.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4d);
        series3.tooltip()
                .position("right")
                .anchor(Anchor.LEFT_CENTER)
                .offsetX(5d)
                .offsetY(5d);

        Line series4 = monthNutrientsLine.line(series4Mapping);
        series4.name("Lipídios");
        series4.hovered().markers().enabled(true);
        series4.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4d);
        series4.tooltip()
                .position("right")
                .anchor(Anchor.LEFT_CENTER)
                .offsetX(5d)
                .offsetY(5d);
        monthNutrientsLine.legend(true);

        monthNutrientsLineChart.setChart(monthNutrientsLine);

        return v;
    }

    private class CustomDataEntry extends ValueDataEntry {

        CustomDataEntry(String x, Number value, Number value2, Number value3, Number value4) {
            super(x, value);
            setValue("value2", value2);
            setValue("value3", value3);
            setValue("value4", value4);
        }

    }
}
