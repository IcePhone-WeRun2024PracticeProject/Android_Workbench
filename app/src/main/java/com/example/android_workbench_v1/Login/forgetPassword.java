//账号申诉界面
package com.example.android_workbench_v1.Login;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.android_workbench_v1.R;

public class forgetPassword extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.forgetpassword);

        /*设置“返回”的点击事件 */

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(forgetPassword.this,"登陆主界面");
                  startActivity(intent);*/

            }
        });
        //账号输入限制
        EditText editText = findViewById(R.id.editText1);
        editText.setFilters(new InputFilter[]{
                (source, start, end, dest, dstart, dend)-> {
                    for (int i = 0; i < source.length(); i++) {
                        if (Character.toString(source.charAt(i)).matches("[\\u4e00-\\u9fa5]+")&& source.toString().matches("^[^a-zA-Z0-9_].*")) {
                            // 发现中文字符，返回空字符串，阻止输入
                            return "";
                        }
                    }
                    // 如果没有中文字符，则允许输入
                    return source;
                }
        });

        //密码输入限制
        EditText passwordEditText1 = findViewById(R.id.editText2);
        passwordEditText1.setTransformationMethod(PasswordTransformationMethod.getInstance());

        InputFilter[] passwordFilters1 = new InputFilter[1];
        passwordFilters1[0] = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (Character.toString(source.charAt(start)).matches("[\\u4e00-\\u9fa5]+") && !source.toString().matches("^[^a-zA-Z0-9_].*")) {
                    return source;
                }
                return "";
            }
        };
        passwordEditText1.setFilters(passwordFilters1);
        //密码确认
        EditText passwordEditText2 = findViewById(R.id.editText3);
        passwordEditText2.setTransformationMethod(PasswordTransformationMethod.getInstance());

        InputFilter[] passwordFilters2 = new InputFilter[1];
        passwordFilters2[0] = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (Character.toString(source.charAt(start)).matches("[\\u4e00-\\u9fa5]+") && !source.toString().matches("^[^a-zA-Z0-9_].*")) {
                    return source;
                }
                return "";
            }
        };
        passwordEditText2.setFilters(passwordFilters2);




    }
}
