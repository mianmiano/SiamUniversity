package com.example.pein.siamuniversity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class StudentLogininActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_loginin);
        WebView myWebView = (WebView) findViewById(R.id.webView4);
        myWebView.loadUrl("http://www.inter.siam.edu/");
    }
}
