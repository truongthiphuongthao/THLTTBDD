package com.example.homework1_thao_b1609548;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class pieChart8 extends AppCompatActivity {
    ImageButton imageButton;
    String Des1, Des2, Des3, Des4,Des5,Des6,Des7,Des8,Title;
    double amount1,amount2,amount3,amount4,amount5,amount6,amount7,amount8;
    TextView textView;
    PieChart pieChartpie;
    PieData data8;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart8);
        pieChartpie = (PieChart) findViewById(R.id.PieChartMp);
        imageButton = (ImageButton) findViewById(R.id.imagebutton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        textView = (TextView) findViewById(R.id.laytitle);
        Intent intent = getIntent();
        amount1 = intent.getDoubleExtra("segment1", 123);
        amount2 = intent.getDoubleExtra("segment2", 123);
        amount3 = intent.getDoubleExtra("segment3", 123);
        amount4 = intent.getDoubleExtra("segment4", 123);
        amount5 = intent.getDoubleExtra("segment5", 123);
        amount6 = intent.getDoubleExtra("segment6", 123);
        amount7 = intent.getDoubleExtra("segment7", 123);
        amount8 = intent.getDoubleExtra("segment8", 123);
        Title = intent.getStringExtra("tendothi");
        Des1 = intent.getStringExtra("Des1");
        Des2 = intent.getStringExtra("Des2");
        Des3 = intent.getStringExtra("Des3");
        Des4 = intent.getStringExtra("Des4");
        Des5 = intent.getStringExtra("Des5");
        Des6 = intent.getStringExtra("Des6");
        Des7 = intent.getStringExtra("Des7");
        Des8 = intent.getStringExtra("Des8");
        textView.setText("Đồ thị: " + Title);
        pieChartpie.setUsePercentValues(true);
        pieChartpie.setCenterText(generateCenterSpannableText());
        pieChartpie.setExtraOffsets(20.f, 0.f, 20.f, 0.f);
        pieChartpie.setDrawHoleEnabled(true);
        pieChartpie.setHoleColor(Color.WHITE);
        pieChartpie.setTransparentCircleColor(Color.WHITE);
        pieChartpie.setTransparentCircleAlpha(110);
        pieChartpie.setHoleRadius(52f);
        pieChartpie.setTransparentCircleRadius(55f);
        pieChartpie.setDrawCenterText(true);
        setData8(8, 100);
        pieChartpie.setData(data8);
        pieChartpie.setVisibility(View.VISIBLE);
    }
    private SpannableString generateCenterSpannableText() {
        SpannableString s = new SpannableString("PieChartAndroid");
        s.setSpan(new RelativeSizeSpan(1.5f), 0, 15, 0);
        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 15, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 15, s.length(), 0);
        return s;
    }
    private void setData8(int count, float range) {
        String[] mParties = new String[]{Des1, Des2, Des3,Des4,Des5,Des6,Des7,Des8};
        float mult = range;
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        double tong2 = amount1 + amount2 + amount3 + amount4 +amount5+amount6+amount7+amount8;
        double[] yData2 = {amount1, amount2, amount3, amount4, amount5,amount6,amount7,amount8};
        for (int i = 0; i < count; i++) {
            yEntrys.add(new PieEntry((float) (yData2[i] / tong2) * 100, mParties[i]));
        }
        PieDataSet dataSet = new PieDataSet(yEntrys, null);
        dataSet.setSliceSpace(3f);
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.MAGENTA);
        colors.add(Color.YELLOW);
        colors.add(ColorTemplate.getHoloBlue());
        colors.add(Color.TRANSPARENT);
        colors.add(Color.CYAN);
        colors.add(Color.RED);
        dataSet.setColors(colors);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        data8 = new PieData(dataSet);
        data8.setValueFormatter(new PercentFormatter());
        data8.setValueTextSize(13f);
        pieChartpie.invalidate();
        Legend l = pieChartpie.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setEnabled(true);
        l.setTextSize(16);
    }
}
