package com.blossoming.propadometer;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class webb extends AppCompatActivity {


    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webb);



        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("link");

        webView = (WebView) findViewById(R.id.webb);
        webView.setWebViewClient(new WebViewClient());

        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl(url);



    }
    @Override
    public void onBackPressed() {
        if(webView.getVisibility() == View.VISIBLE && webView.canGoBack())
            webView.goBack();
        else {
            this.finish();
            super.onBackPressed();
        }
    }
}