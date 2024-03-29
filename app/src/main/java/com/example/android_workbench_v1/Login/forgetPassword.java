package com.example.android_workbench_v1.Login;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.android_workbench_v1.R;

public class forgetPassword extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.forgetpassword);

        /*设置“返回”的点击事件----------------------------------------3.29 21：14  by smr */

        ImageView back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(forgetPassword.this,"登陆主界面");
                  startActivity(intent);*/
                /*设置点击“返回时”从当前界面返回到登陆主界面*/
                /*等界面全部绘制好便可把注释语句内的对应内容填充完毕*/


            }
        });
    }
}
