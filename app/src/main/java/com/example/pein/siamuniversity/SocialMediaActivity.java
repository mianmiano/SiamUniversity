package com.example.pein.siamuniversity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class SocialMediaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);
        WebView myWebView = (WebView) findViewById(R.id.webView_socialMedia);
        myWebView.loadUrl("https://www.facebook.com/pages/มหาวิทยาลัยสยาม-Siam-University/565265553489622");
    }
}
