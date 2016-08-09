package com.example.pein.siamuniversity;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class SchoolinActivity extends AppCompatActivity {
    TextView tschool_id,tschool_status,tschool_grade,tschool_profession,tschool_name,tschool_namepin,tschool_gender,tschool_birth,tschool_idnumber
            ,tschool_pronumber,tschool_score,tschool_school,tschool_address,tschool_contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schoolin);
        // 接收前一屏穿过来的Intent
        Intent intent=getIntent();
        // 取其中的值
        String value = intent.getStringExtra("val");
        Log.i("error",value);
        if(value.equals("{}")){
            Toast tst = Toast.makeText(this, "姓名或证件号错误", Toast.LENGTH_SHORT);
            tst.show();
            finish();
        }
        //tschool_gender,tschool_birth,tschool_idnumber
       // ,tschool_pronumber,tschool_score,tschool_school,tschool_address,tschool_contact;
        tschool_id=(TextView)findViewById(R.id.textViewschool_1);
        tschool_status=(TextView)findViewById(R.id.textViewschool_2);
        tschool_grade=(TextView)findViewById(R.id.textViewschool_3);
        tschool_profession=(TextView)findViewById(R.id.textViewschool_4);
        tschool_name=(TextView)findViewById(R.id.textViewschool_5);
        tschool_namepin=(TextView)findViewById(R.id.textViewschool_6);
        tschool_gender=(TextView)findViewById(R.id.textViewschool_7);
        tschool_birth=(TextView)findViewById(R.id.textViewschool_8);
        tschool_idnumber=(TextView)findViewById(R.id.textViewschool_9);
        tschool_pronumber=(TextView)findViewById(R.id.textViewschool_10);
        tschool_score=(TextView)findViewById(R.id.textViewschool_11);
        tschool_school=(TextView)findViewById(R.id.textViewschool_12);
        tschool_address=(TextView)findViewById(R.id.textViewschool_13);
        tschool_contact=(TextView)findViewById(R.id.textViewschool_14);
        Map map=dosomething.getMapFromJsonObjStr(value);
        if(map.get("id")==null){

        }else {
            tschool_id.setText( map.get("id").toString());


            if ("0".equals(map.get("status").toString())) {
                tschool_status.setText("等待审核");
            } else if ("1".equals(map.get("status").toString())) {
                tschool_status.setText("初步审核通过");
            } else if ("2".equals(map.get("status").toString())) {
                tschool_status.setText("已正式录取");
            } else if ("10".equals(map.get("status").toString())) {
                tschool_status.setText("审核不通过");
            }


            tschool_grade.setText(map.get("grade").toString());
            tschool_profession.setText( map.get("profession").toString());
            tschool_name.setText(map.get("grade").toString());
            tschool_namepin.setText( map.get("first_name_pinyin").toString() + map.get("last_name_pinyin").toString());
            tschool_gender.setText("" + map.get("gender"));
            tschool_birth.setText("" + map.get("birthday"));
            tschool_idnumber.setText("" + map.get("id_number"));
            tschool_pronumber.setText("" + map.get("passport_number"));
            tschool_score.setText("" + map.get("college_entrance_score"));
            tschool_school.setText("" + map.get("graduated_school"));
            tschool_address.setText("" + map.get("province") + map.get("city") + map.get("area"));
            tschool_contact.setText("" + map.get("phone_no"));
        }
        /*500234199210024742    p1132000002
        Map map=dosomething.getMapFromJsonObjStr(s);
        System.out.println(map.get("id"));
        System.out.println(map.get("grade"));
        System.out.println(map.get("profession"));
        else if(map.get("status".equals("1")){
            tschool_status.setText("审核状态（status）：初步审核通过");
        }else if{

        }
        System.out.println(map.get("name"));
        System.out.println(map.get("first_name_pinyin"));
        System.out.println(map.get("last_name_pinyin"));
        System.out.println(map.get("gender"));
        System.out.println(map.get("birthday"));
        System.out.println(map.get("id_number"));
        System.out.println(map.get("passport_number"));
        System.out.println(map.get("college_entrance_score"));
        System.out.println(map.get("graduated_school"));
        System.out.println(map.get("province"));
        System.out.println(map.get("city"));
        System.out.println(map.get("area"));
        System.out.println(map.get("street"));
        System.out.println(map.get("phone_no"));
        System.out.println(map.get("status"));*/

    }


}
