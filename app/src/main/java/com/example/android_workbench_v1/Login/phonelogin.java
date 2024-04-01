//手机号登陆界面
package com.example.android_workbench_v1.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.android_workbench_v1.R;

public class phonelogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phonelogin);
        //”返回键“功能实现
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             /* Intent intent1 =new Intent(phonelogin.this,"登录主界面")
                startActivity(intent);*/

            }
        });









        //”登录健”功能实现
        Button log = findViewById(R.id.bt2);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(phonelogin.this,mainPage.class);
            }
        });

    }




}
