package com.example.homework1_thao_b1609548.BarChart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.homework1_thao_b1609548.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class BarChart5 extends AppCompatActivity {
    BarChart mChart;
    TextView textView, textView1, textView2, textView3, textView4, textView5;
    String Des1, Des2, Des3, Des4, Des5, Title;
    BarData databar5;
    double amountbar1, amountbar2, amountbar3, amountbar4, amountbar5;
    ImageButton imageButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart5);
        textView = (TextView) findViewById(R.id.textViewBar);
        textView1 = (TextView) findViewById(R.id.textviewtenduong1);
        textView2 = (TextView) findViewById(R.id.textviewtenduong2);
        textView3 = (TextView) findViewById(R.id.textviewtenduong3);
        textView4 = (TextView) findViewById(R.id.textviewtenduong4);
        textView5 = (TextView) findViewById(R.id.textviewtenduong5);
        imageButton = (ImageButton) findViewById(R.id.imagebuttoncot);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mChart = findViewById(R.id.BarChartMpAndroid);
        Intent intent = getIntent();
        amountbar1 = intent.getDoubleExtra("cot1", 123);
        amountbar2 = intent.getDoubleExtra("cot2", 123);
        amountbar3 = intent.getDoubleExtra("cot3", 123);
        amountbar4 = intent.getDoubleExtra("cot4", 123);
        amountbar5 = intent.getDoubleExtra("cot5", 123);
        Title = intent.getStringExtra("tendothi");
        Des1 = intent.getStringExtra("tencot1");
        Des2 = intent.getStringExtra("tencot2");
        Des3 = intent.getStringExtra("tencot3");
        Des4 = intent.getStringExtra("tencot4");
        Des5 = intent.getStringExtra("tencot5");

        textView.setText("Đồ thị: " + Title);
        textView1.setText("1-" + Des1);
        textView2.setText("2-" + Des2);
        textView3.setText("3-" + Des3);
        textView4.setText("4-" + Des4);
        textView5.setText("5-" + Des5);

        mChart.setDrawBarShadow(false);
        mChart.setDrawValueAboveBar(true);
        mChart.getDescription().setEnabled(false);

        mChart.setMaxVisibleValueCount(60);
        mChart.setPinchZoom(false);
        mChart.setDrawGridBackground(false);
        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(15);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(7);
        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setLabelCount(8, false);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setTextSize(15);
        leftAxis.setAxisMinimum(0f);
        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setLabelCount(8, false);
        rightAxis.setTextSize(15);
        rightAxis.setSpaceTop(15f);
        rightAxis.setAxisMinimum(0f);
        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);
        setDataBar5(3, 100);
        mChart.setData(databar5);
        mChart.setVisibility(View.VISIBLE);
        mChart.invalidate();
    }

    private void setDataBar5(int count, float range) {
        XAxis xAxis = mChart.getXAxis();
        xAxis.setGranularity(1f);
        float start = 1f;
        Double[] Y3 = {amountbar1, amountbar2, amountbar3, amountbar4, amountbar5};
        ArrayList<BarEntry> yVals3 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            double mult = (range);
            double val3 = (double) (Y3[i]);
            yVals3.add(new BarEntry(i + 1, (float) (val3)));
        }
        BarDataSet set1;
        set1 = new BarDataSet(yVals3, "The year 2019");
        set1.setColors(ColorTemplate.MATERIAL_COLORS);
        int startColor1 = ContextCompat.getColor(this, android.R.color.holo_orange_light);
        int startColor2 = ContextCompat.getColor(this, android.R.color.holo_blue_light);
        int startColor3 = ContextCompat.getColor(this, android.R.color.holo_green_light);
        int startColor4 = ContextCompat.getColor(this, android.R.color.holo_red_light);
        int startColor5 = ContextCompat.getColor(this, android.R.color.holo_orange_dark);
        List<Integer> gradientColors = new ArrayList<>();
        gradientColors.add(0, startColor1);
        gradientColors.add(1, startColor2);
        gradientColors.add(2, startColor3);
        gradientColors.add(3, startColor4);
        gradientColors.add(4, startColor5);
        set1.setColors(gradientColors);
        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);
        databar5 = new BarData(dataSets);
        databar5.setValueTextSize(15f);
        databar5.setBarWidth(0.5f);
    }
}

