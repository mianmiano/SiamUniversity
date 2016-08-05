package com.example.pein.siamuniversity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdmissionActivity extends AppCompatActivity {

    ListView myListView;
    List<String> itemString=new ArrayList<String>();
    List <Object> itemImage=new ArrayList<Object>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission);

        ArrayList<HashMap<String, Object>> listItem =new ArrayList<HashMap<String, Object>>();
        myListView = (ListView) findViewById(R.id.listView_admission);

        HashMap <String, Object> itemMap =new HashMap <String,Object>();
        itemMap.put("itemString","When to Apply");
        itemMap.put("itemImage2",R.drawable.aboutus2);
        listItem.add(itemMap);

        itemMap =new HashMap <String,Object>();
        itemMap.put("itemString","Academic Qualifications" );
        itemMap.put("itemImage2",R.drawable.aboutus2);
        listItem.add(itemMap);

        itemMap =new HashMap <String,Object>();
        itemMap.put("itemString","English Profeciency" );
        itemMap.put("itemImage2",R.drawable.aboutus2);
        listItem.add(itemMap);

        itemMap =new HashMap <String,Object>();
        itemMap.put("itemString","Admission Procedure" );
        itemMap.put("itemImage2",R.drawable.aboutus2);
        listItem.add(itemMap);

        itemMap =new HashMap <String,Object>();
        itemMap.put("itemString","Apply from Abroad" );
        itemMap.put("itemImage2",R.drawable.aboutus2);
        listItem.add(itemMap);

        itemMap =new HashMap <String,Object>();
        itemMap.put("itemString","Application Requirements" );
        itemMap.put("itemImage2",R.drawable.aboutus2);
        listItem.add(itemMap);

        itemMap =new HashMap <String,Object>();
        itemMap.put("itemString","Visa Support" );
        itemMap.put("itemImage2",R.drawable.aboutus2);
        listItem.add(itemMap);

        itemMap =new HashMap <String,Object>();
        itemMap.put("itemString","Admission Form" );
        itemMap.put("itemImage2",R.drawable.aboutus2);
        listItem.add(itemMap);

        SimpleAdapter mySimpleAdapter = new SimpleAdapter(this,listItem,R.layout.aboutusitemlayout, new String[] {  "itemString" ,"itemImage2"},
                new int[] { R.id.textView_admissionItem,R.id.imageView_admissionItem2 });

        myListView.setAdapter(mySimpleAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){
                Intent one=null;
                switch (arg2){
                    case 0:one=new Intent(AdmissionActivity.this,Aboutus_HistoryActivity.class);
                        break;
                    case 1:one=new Intent(AdmissionActivity.this,Aboutus_MessageFromThePresidentActivity.class);
                        break;
                    case 2:one=new Intent(AdmissionActivity.this,Aboutus_MissionAndVisionActivity.class);
                        break;
                    case 3:one=new Intent(AdmissionActivity.this,Aboutus_StrategiesActivity.class);
                        break;
                    case 4:one=new Intent(AdmissionActivity.this,Aboutus_InternationalColleborationsActivity.class);
                        break;
                    case 5:one=new Intent(AdmissionActivity.this,Aboutus_SdudentConductPolicyActivity.class);
                        break;
                    case 6:one=new Intent(AdmissionActivity.this,Aboutus_GradingSystemActivity.class);
                        break;
                    case 7:one=new Intent(AdmissionActivity.this,Aboutus_HonorSystemActivity.class);
                        break;
                }
                startActivity(one);
            }
        });
    }
}
