package com.example.pein.siamuniversity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class StudentLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        WebView myWebView = (WebView) findViewById(R.id.webView_studentLogin);
        myWebView.loadUrl("http://home.sis.siam.edu/registrar/home.asp?lang=2");
    }
}
