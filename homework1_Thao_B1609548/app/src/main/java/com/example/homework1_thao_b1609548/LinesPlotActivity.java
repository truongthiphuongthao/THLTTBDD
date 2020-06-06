package com.example.homework1_thao_b1609548;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.androidplot.xy.CatmullRomInterpolator;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYGraphWidget;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;
import static java.lang.Float.parseFloat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;

public class LinesPlotActivity extends AppCompatActivity {
    private XYPlot plot;
    Float[] domainLabels;
    Float[] series1Numbers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lines_plot);
        plot = (XYPlot) findViewById(R.id.plot);
        Bundle receiveBundle = this.getIntent().getExtras();
        final ArrayList<String> numberx = receiveBundle.getStringArrayList("xLabels");
        final ArrayList<String> numbery = receiveBundle.getStringArrayList("yData");
        final Float[] domainLabels = new Float[numberx.size()];
        for (int i = 0; i < numberx.size(); i++) {
            domainLabels[i] = parseFloat(numberx.get(i));
        }
        final Float[] series1Numbers = new Float[numbery.size()];
        for (int i = 0; i < numbery.size(); i++) {
            series1Numbers[i] = parseFloat(numbery.get(i));
        }
        XYSeries series1 = new SimpleXYSeries(Arrays.<Float>asList(series1Numbers), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series1");
        LineAndPointFormatter series1Format = new LineAndPointFormatter(this, R.xml.line_point_formatter_with_labels);
        series1Format.setInterpolationParams(new CatmullRomInterpolator.Params(10, CatmullRomInterpolator.Type.Centripetal));
        plot.addSeries(series1, series1Format);
        plot.getGraph().getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).setFormat(new Format() {
            @Override
            public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
                int i = Math.round(((Number) obj).floatValue());
                return toAppendTo.append(domainLabels[i]);
            }
            @Override
            public Object parseObject(String source, ParsePosition pos) {
                return null;
            }
        });
    }
}


