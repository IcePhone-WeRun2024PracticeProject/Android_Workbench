//手机号登陆界面
package com.example.android_workbench_v1.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
             Intent intent1 =new Intent(phonelogin.this, LoginActivity.class);
                startActivity(intent1);

            }
        });






        //”登录健”功能实现
        Button log = findViewById(R.id.bt2);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(phonelogin.this,BlankActivity.class);
            }
        });

        EditText phoneNumberEditText = findViewById(R.id.editText1);
        phoneNumberEditText.setInputType(InputType.TYPE_CLASS_NUMBER); // 设置输入类型为数字

        InputFilter[] filter_phonenumber = new InputFilter[2];
        filter_phonenumber[0] = new InputFilter.LengthFilter(11); // 设置位数限制为11位
        filter_phonenumber[1] = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end,  Spanned dest, int dstart, int dend) {
                // 检查输入的字符是否为数字
                for (int i = start; i < end; i++) {
                    if (!Character.isDigit(source.charAt(i))) {
                        return ""; // 如果输入的字符不是数字，则禁止输入
                    }
                }
                return null; // 允许输入
            }
        };
        phoneNumberEditText.setFilters(filter_phonenumber);








        EditText testNumberEditText = findViewById(R.id.editText2);
        testNumberEditText.setInputType(InputType.TYPE_CLASS_NUMBER); // 设置输入类型为数字

        InputFilter[] filter_test = new InputFilter[2];
        filter_test[0] = new InputFilter.LengthFilter(6); // 设置位数限制为6位
        filter_test[1] = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                // 检查输入的字符是否为数字
                for (int i = start; i < end; i++) {
                    if (!Character.isDigit(source.charAt(i))) {
                        return ""; // 如果输入的字符不是数字，则禁止输入
                    }
                }
                return null; // 允许输入
            }
        };
        testNumberEditText.setFilters(filter_test);

    }




}
