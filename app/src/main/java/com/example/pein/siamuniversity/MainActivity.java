package com.example.pein.siamuniversity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_aboutUs,btn_academics,btn_admission,btn_studentVoice,btn_news,
            btn_sports,btn_gallery,btn_socialMedia,btn_library,btn_studentLogin,
            btn_calendar,btn_video,
            btn_suStaffs,btn_awards,btn_maps,btn_contactUs,btn_school;
    Intent intent;
    Toast tst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化button
        btn_aboutUs=(Button) findViewById(R.id.button_aboutUs);
        btn_academics=(Button) findViewById(R.id.button_academics);
        btn_admission=(Button) findViewById(R.id.button_admission);
        btn_studentVoice=(Button) findViewById(R.id.button_studentVoice);
        btn_news=(Button) findViewById(R.id.button_news);
        btn_sports=(Button) findViewById(R.id.button_sports);
        btn_gallery=(Button) findViewById(R.id.button_gallery);
        btn_library=(Button) findViewById(R.id.button_library);
        btn_studentLogin=(Button) findViewById(R.id.button_studentLogin);
        btn_calendar=(Button) findViewById(R.id.button_calendar);
        btn_video=(Button) findViewById(R.id.button_video);
        btn_suStaffs=(Button) findViewById(R.id.button_suStaffs);
        btn_awards=(Button) findViewById(R.id.button_awards);
        btn_maps=(Button) findViewById(R.id.button_maps);
        btn_contactUs=(Button) findViewById(R.id.button_contactUs);
        btn_school=(Button) findViewById(R.id.button_school);
        btn_socialMedia=(Button) findViewById(R.id.button_socialMedia);

        //button添加监听
        btn_aboutUs.setOnClickListener(this);
        btn_academics.setOnClickListener(this);
        btn_admission.setOnClickListener(this);
        btn_studentVoice.setOnClickListener(this);
        btn_news.setOnClickListener(this);
        btn_sports.setOnClickListener(this);
        btn_gallery.setOnClickListener(this);
        btn_socialMedia.setOnClickListener(this);
        btn_library.setOnClickListener(this);
        btn_studentLogin.setOnClickListener(this);
        btn_calendar.setOnClickListener(this);
        btn_video.setOnClickListener(this);
        btn_suStaffs.setOnClickListener(this);
        btn_awards.setOnClickListener(this);
        btn_maps.setOnClickListener(this);
        btn_contactUs.setOnClickListener(this);
        btn_school.setOnClickListener(this);

    }
    public void onClick(View v) {
        // TODO Auto-generated method stubllllll
        switch (v.getId()) {
            case R.id.button_aboutUs:
                intent = new Intent();
                intent.setClass(MainActivity.this, AboutusActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            case R.id.button_academics:
                tst = Toast.makeText(this, "22222222", Toast.LENGTH_SHORT);
                tst.show();
                break;
            case R.id.button_admission:
                intent = new Intent();
                intent.setClass(MainActivity.this, AdmissionActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            case R.id.button_studentVoice:
                tst = Toast.makeText(this, "444444", Toast.LENGTH_SHORT);
                tst.show();
                break;
            case R.id.button_news:
                intent = new Intent();
                intent.setClass(MainActivity.this, NewsActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            case R.id.button_sports:
                tst = Toast.makeText(this, "666666", Toast.LENGTH_SHORT);
                tst.show();
                break;
            case R.id.button_gallery:
                intent = new Intent();
                intent.setClass(MainActivity.this, GalleryActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            case R.id.button_socialMedia:
                intent = new Intent();
                intent.setClass(MainActivity.this, SocialMediaActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            case R.id.button_library:
                intent = new Intent();
                intent.setClass(MainActivity.this,LibraryActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            case R.id.button_studentLogin:
                tst = Toast.makeText(this, "10", Toast.LENGTH_SHORT);
                tst.show();
                break;
            case R.id.button_calendar:
                intent = new Intent();
                intent.setClass(MainActivity.this,CalenderActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            case R.id.button_video:
                intent = new Intent();
                intent.setClass(MainActivity.this, VideoActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            case R.id.button_suStaffs:
                tst = Toast.makeText(this, "13", Toast.LENGTH_SHORT);
                tst.show();
                break;
            case R.id.button_awards:
                intent = new Intent();
                intent.setClass(MainActivity.this, AwardsActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            case R.id.button_maps:
                tst = Toast.makeText(this, "15", Toast.LENGTH_SHORT);
                tst.show();
                break;
            case R.id.button_contactUs:
                intent = new Intent();
                intent.setClass(MainActivity.this, ContactUsActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            case R.id.button_school:
                intent = new Intent();
                intent.setClass(MainActivity.this,SchoolActivity.class);
                MainActivity.this.startActivity(intent);
                break;
        }
    }



}
