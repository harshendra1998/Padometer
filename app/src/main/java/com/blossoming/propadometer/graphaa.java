package com.blossoming.propadometer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

import static com.github.mikephil.charting.data.LineDataSet.Mode.HORIZONTAL_BEZIER;

public class graphaa extends AppCompatActivity {

    LineChart lineChart;

    SharedPreferences sharedPreferences;
    ArrayList valsComp2;
    int url,a,b=0;

    private InterstitialAd interstitialAd;
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph);

        lineChart =findViewById(R.id.graph2);

        sharedPreferences = this.getSharedPreferences("pref", Context.MODE_PRIVATE);
        //editor = sharedPreferences.edit();

        Bundle bundle = getIntent().getExtras();
        url = bundle.getInt("datano");
        valsComp2 = new ArrayList<>();

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getApplicationContext(),
                R.array.Range, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        a = 6;
                        //textt.setText("1");
                        break;
                    case 1:
                        a = 29;
                        //textt.setText("2");
                        break;
                    case 2:
                        a = 364;
                        //textt.setText("3");
                        break;
                }
                working();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        working();

        adView = new AdView(this, getResources().getString(R.string.Banner_id), AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);
        adView.setAdListener(new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                adView.loadAd();
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Ad loaded callback
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
            }
        });
        adView.loadAd();

    }

    public void working(){

        Log.d("Working","yess");
        if (valsComp2.size()!=0){
            valsComp2.clear();
        }
        if(a>url){
            b = 1;
        }
        else {
            b = url - a;
        }
        for(int i=b;i<=url;i++){
            String datapoint = "gCount_at_" + i;
            int Data_value = sharedPreferences.getInt(datapoint,0) ;
            valsComp2.add(new Entry(i,Data_value));
            //valsComp1.add(Data_value);
        }


        LineDataSet barDataSet = new LineDataSet(valsComp2, "Glasses Of Water");
        LineData barData = new LineData(barDataSet);

        barDataSet.setValueTextColor(this.getResources().getColor(R.color.white));
        barDataSet.setFillColor(Color.argb(51, 35, 137, 218));
        barDataSet.setDrawCircles(true);
        barDataSet.setDrawFilled(true);
        barDataSet.setDrawValues(true);
        barDataSet.setMode(HORIZONTAL_BEZIER);
        //barDataSet.setDrawCubic(true);
        barDataSet.setCubicIntensity(0.2f);
        lineChart.setData(barData);

        //lineChart.setDrawBarShadow(false);
        //lineChart.setDrawValueAboveBar(true);
        lineChart.setMaxVisibleValueCount(50);
        lineChart.setPinchZoom(false);
        lineChart.setDrawGridBackground(true);
        lineChart.animateXY(700,1000);
        lineChart.setBackgroundColor(this.getResources().getColor(R.color.transparent));
        lineChart.setNoDataTextColor(this.getResources().getColor(R.color.white));
        lineChart.setGridBackgroundColor(this.getResources().getColor(R.color.transparent));




        
        lineChart.invalidate();



        interstitialAd = new InterstitialAd(this, getResources().getString(R.string.Inter_id));
        interstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback
                graphaa.super.onBackPressed();
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
                // Show the ad
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
            }
        });
        interstitialAd.loadAd();

    }

    public void onBackPressed(){
        if(interstitialAd.isAdLoaded()){
            interstitialAd.show();
        }
        else{
            super.onBackPressed();
        }
    }
}
