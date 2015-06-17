package escobar.gabriel.engsoftware;

import java.util.*;
import java.io.*;
import java.text.DateFormat;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Paint.Align;

import org.achartengine.*;
import org.achartengine.chart.*;
import org.achartengine.model.*;
import org.achartengine.renderer.*;
import org.achartengine.tools.*;
import org.json.*;
/**
 * Created by Gabriel on 15/06/2015.
 */
public class Grafico  {

    int[] firstData={23,145,67,78,86,190,46,78,167,164};
    int[] secondData={83,45,168,138,67,150,64,87,144,188};


        /*public void getBarChart(){
            XYMultipleSeriesRenderer barChartRenderer = getBarChartRenderer();
            setBarChartSettings(barChartRenderer);
            Intent intent =(Intent)ChartFactory.getBarChartIntent(this, getBarDemoDataset(), barChartRenderer, BarChart.Type.DEFAULT);
            startActivity(intent);
        }*/


        private XYMultipleSeriesRenderer getBarChartRenderer() {
            XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
            renderer.setAxisTitleTextSize(20);
            renderer.setChartTitleTextSize(18);
            renderer.setLabelsTextSize(18);
            renderer.setLegendTextSize(18);
            renderer.setMargins(new int[]{20, 30, 15, 0});
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(Color.BLUE);
            renderer.addSeriesRenderer(r);
            r = new SimpleSeriesRenderer();
            r.setColor(Color.GREEN);
            renderer.addSeriesRenderer(r);
            return renderer;
        }

        private XYMultipleSeriesDataset getBarDemoDataset() {
            XYMultipleSeriesDataset barChartDataset = new XYMultipleSeriesDataset();
            CategorySeries firstSeries = new CategorySeries("Growth of Company1");
            for(int i=0;i<firstData.length;i++)
                firstSeries.add(firstData[i]);
            barChartDataset.addSeries(firstSeries.toXYSeries());

            CategorySeries secondSeries = new CategorySeries("Growth of Company2");
            for(int j=0;j<secondData.length;j++)
            secondSeries.add(secondData[j]);
            barChartDataset.addSeries(secondSeries.toXYSeries());
            return barChartDataset;
        }
        private void setBarChartSettings(XYMultipleSeriesRenderer renderer) {
            renderer.setChartTitle("Growth comparison company1 vs company2");
            renderer.setXTitle("No of Years in industry");
            renderer.setYTitle("Profit in millions");
            renderer.setXAxisMin(0.5);
            renderer.setXAxisMax(10.5);
            renderer.setYAxisMin(0);
            renderer.setYAxisMax(210);
        }
}
