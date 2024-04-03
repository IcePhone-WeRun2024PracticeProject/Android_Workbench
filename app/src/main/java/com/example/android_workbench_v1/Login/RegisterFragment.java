package com.example.android_workbench_v1.Login;



import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.android_workbench_v1.R;

//import com.example.hadabing.R;

public class RegisterFragment extends Fragment {

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_register, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText accountRegister = view.findViewById(R.id.account_register);
        InputFilter filter_register_account = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (dstart == 0 && source.length() > 0 && !Character.isLetterOrDigit(source.charAt(0))) {
                    // 如果输入的第一个字符是特殊符号，则禁止输入
                    return "";
                }
                return source; // 允许输入
            }

        };
        accountRegister.setFilters(new InputFilter[]{filter_register_account});

        EditText passwordRegister = view.findViewById(R.id.password_register);
        InputFilter filter_register_password = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (dstart == 0 && source.length() > 0 && !Character.isLetterOrDigit(source.charAt(0))) {
                    // 如果输入的第一个字符是特殊符号，则禁止输入
                    return "";
                }
                return source; // 允许输入
            }

        };
        passwordRegister.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        passwordRegister.setFilters(new InputFilter[]{filter_register_password});

        EditText phoneNumberEditText = view.findViewById(R.id.phonenumber);
        phoneNumberEditText.setInputType(InputType.TYPE_CLASS_NUMBER); // 设置输入类型为数字

        InputFilter[] filter_phonenumber = new InputFilter[2];
        filter_phonenumber[0] = new InputFilter.LengthFilter(11); // 设置位数限制为11位
        filter_phonenumber[1] = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end,     Spanned dest, int dstart, int dend) {
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

        EditText testNumberEditText = view.findViewById(R.id.test);
        testNumberEditText.setInputType(InputType.TYPE_CLASS_NUMBER); // 设置输入类型为数字

        InputFilter[] filter_test = new InputFilter[2];
        filter_test[0] = new InputFilter.LengthFilter(6); // 设置位数限制为6位
        filter_test[1] = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end,     Spanned dest, int dstart, int dend) {
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