package br.ufms.gerenciadordedespesas;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;


public class AnalisarFinancas extends ActionBarActivity {

    int[] firstData={23,145,67,78,86,190,46,78,167,164};
    int[] secondData={83,45,168,138,67,150,64,87,144,188};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analisar_financas2);
    }

    public void analiseAnual(View v){
       getBarChart();
    }

    public void volta(View v){
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_analisar_financas, menu);
        return true;
    }
    public void getBarChart(){
        XYMultipleSeriesRenderer barChartRenderer = getBarChartRenderer();
        setBarChartSettings(barChartRenderer);
        Intent intent =(Intent) ChartFactory.getBarChartIntent(this, getBarDemoDataset(), barChartRenderer, BarChart.Type.DEFAULT);
        startActivity(intent);
    }

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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
