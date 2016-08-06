package com.example.pein.siamuniversity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.os.Handler;

public class SchoolActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener{
    Button btn_schoolLogin;
    Spinner spinProvince;
    EditText editText_name,editText_id;
    int type=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school);

        btn_schoolLogin=(Button)findViewById(R.id.btn_schollLogin);
        btn_schoolLogin.setOnClickListener(this);
        editText_name=(EditText)findViewById(R.id.editText_name);
        editText_id=(EditText)findViewById(R.id.editText_id);
        //获取Spinner
        spinProvince=(Spinner)super.findViewById(R.id.spinner);
        //注册OnItemSelected事件
        spinProvince.setOnItemSelectedListener(this);


    }

    @Override
    public void onClick(View view) {
       // Intent intent = new Intent();
       // intent.setClass(SchoolActivity.this, SchoolinActivity.class);
        //SchoolActivity.this.startActivity(intent);


        Thread thread=new Thread(new Runnable()
        {
            String name=editText_name.getText().toString();
            String id=editText_id.getText().toString();

            @Override
            public void run()
            {
                // TODO Auto-generated method stub
                Message message=new Message();
                if(type==1){
                    String paramter="USER="+name
                            +"&id_number="+id	;
                    String s = dosomething.sendGet("http://www.siam-check.com/front/search-baoming-json", paramter);
                    message.obj = s;
                    message.what=1;

                }else if(type==2){
                    String paramter2="USER="+name
                            +"&passport_number="+id	;
                    String s2 = dosomething.sendGet("http://www.siam-check.com/front/search-baoming-json", paramter2);
                    message.obj = s2;
                    message.what=2;
                }
                mHandler.sendMessage(message);
            }
        });
        thread.start();

    }


    //主线程
    public Handler mHandler=new Handler()
    {
        public void handleMessage(Message msg)
        {
            Intent intent;
            switch(msg.what)
            {
                case 1:
                    String str=(String)msg.obj;
                    intent = new Intent();
                    //设置传递的参数
                    intent.putExtra("val", str);
                    //从Activity MainActivity跳转到Activity OActivity
                    intent.setClass(SchoolActivity.this, SchoolinActivity.class);
                    //启动intent的Activity
                    SchoolActivity.this.startActivity(intent);
                    break;
                case 2:
                    String str2=(String)msg.obj;
                    intent = new Intent();
                    //设置传递的参数
                    intent.putExtra("val", str2);
                    //从Activity MainActivity跳转到Activity OActivity
                    intent.setClass(SchoolActivity.this, SchoolinActivity.class);
                    //启动intent的Activity
                    SchoolActivity.this.startActivity(intent);
                    break;
            }
            super.handleMessage(msg);
        }
    };

    public void onItemSelected(AdapterView<?> adapter,View view,int position,long id) {
        String sInfo=adapter.getItemAtPosition(position).toString();

        if(sInfo.equals("身份证")){
            type=1;
        }else{
            type=2;
        }
        //Toast.makeText(this, type+"", Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        String sInfo="请选择身份证或者护照号！";
        Toast.makeText(this,sInfo, Toast.LENGTH_LONG).show();
    }

}

