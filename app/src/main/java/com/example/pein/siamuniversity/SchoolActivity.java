package com.example.pein.siamuniversity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
    Toast tst;
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

        if (!isNetworkAvailable(SchoolActivity.this))
        {
            Toast.makeText(getApplicationContext(), "当前无可用网络！无法登陆", Toast.LENGTH_LONG).show();
        }
        else if(
                editText_name.getText().toString().length()==0||editText_id.getText().toString().length()==0){
            Toast.makeText(this,"用户名或者证件号不能为空", Toast.LENGTH_LONG).show();
        }else {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    String name = editText_name.getText().toString();
                    String id = editText_id.getText().toString();

                    Message message = new Message();
                    if (type == 1) {
                        String paramter = "USER=" + name
                                + "&id_number=" + id;
                        String s = dosomething.sendGet("http://www.siam-check.com/front/search-baoming-json", paramter);
                        message.obj = s;
                        message.what = 1;

                    } else if (type == 2) {
                        String paramter2 = "USER=" + name
                                + "&passport_number=" + id;
                        String s2 = dosomething.sendGet("http://www.siam-check.com/front/search-baoming-json", paramter2);
                        message.obj = s2;
                        message.what = 2;
                    }
                    mHandler.sendMessage(message);
                }

            });
            thread.start();
        }
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

    public boolean isNetworkAvailable(Activity activity)
    {
        Context context = activity.getApplicationContext();
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null)
        {
            return false;
        }
        else
        {
            // 获取NetworkInfo对象
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();

            if (networkInfo != null && networkInfo.length > 0)
            {
                for (int i = 0; i < networkInfo.length; i++)
                {
                    System.out.println(i + "===状态===" + networkInfo[i].getState());
                    System.out.println(i + "===类型===" + networkInfo[i].getTypeName());
                    // 判断当前网络状态是否为连接状态
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }


}

