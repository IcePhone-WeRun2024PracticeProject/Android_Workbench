//账号申诉界面
package com.example.android_workbench_v1.Login;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.example.android_workbench_v1.R;

public class ForgetPassword extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);

        /*设置“返回”的点击事件 */

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgetPassword.this, LoginActivity.class);
                startActivity(intent);

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
        EditText passwordLogin = findViewById(R.id.editText2);
        InputFilter filter_password = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (Character.toString(source.charAt(start)).matches("[\\u4e00-\\u9fa5]+") && !source.toString().matches("^[^a-zA-Z0-9_].*"))
                {
                    return " ";
                }
                return source;
            }

        };
        passwordLogin.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        passwordLogin.setFilters(new InputFilter[]{filter_password});


        //密码输入限制
        EditText passwordLogin2 = findViewById(R.id.editText3);
        InputFilter filter_password2 = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (Character.toString(source.charAt(start)).matches("[\\u4e00-\\u9fa5]+") && !source.toString().matches("^[^a-zA-Z0-9_].*"))
                {
                    return " ";
                }
                return source;

            }

        };
        passwordLogin2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        passwordLogin2.setFilters(new InputFilter[]{filter_password2});




        //手机号输入格式
        EditText phoneNumberEditText = findViewById(R.id.editText4);
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


        //验证码数据格式
        EditText testNumberEditText = findViewById(R.id.editText5);
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
