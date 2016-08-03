package com.example.pein.siamuniversity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        WebView myWebView = (WebView) findViewById(R.id.webView_video);
        myWebView.loadUrl("https://www.youtube.com/watch?v=omE8ez97wUs");
    }
}
