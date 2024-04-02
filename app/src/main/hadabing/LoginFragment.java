package com.example.hadabing;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText accountLogin = view.findViewById(R.id.account_login);
        InputFilter filter_login = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (dstart == 0 && source.length() > 0 && !Character.isLetterOrDigit(source.charAt(0))) {
                    // 如果输入的第一个字符是特殊符号，则禁止输入
                    return "";
                }
                return source; // 允许输入
            }

        };
        accountLogin.setFilters(new InputFilter[]{filter_login});

        EditText passwordLogin = view.findViewById(R.id.password_login);
        InputFilter filter_password = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (dstart == 0 && source.length() > 0 && !Character.isLetterOrDigit(source.charAt(0))) {
                    // 如果输入的第一个字符是特殊符号，则禁止输入
                    return "";
                }
                return source; // 允许输入
            }

        };
        passwordLogin.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        passwordLogin.setFilters(new InputFilter[]{filter_password});

        Button loginButton = view.findViewById(R.id.register);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountLogin.getText().toString();
                String password = passwordLogin.getText().toString();

                // 检查输入是否合法
                if (isValidInput(account, password)) {
                    // 登录成功，跳转至空白的 Activity
                    Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), BlankActivity.class);
                    startActivity(intent);
                } else {
                    // 输入不合法，弹出提示
                    Toast.makeText(getActivity(), "请正确输入", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // 检查输入是否合法的方法
    private boolean isValidInput(String account, String password) {
        // 账户和密码不为空且满足指定条件
        return account.equals("zhanghu") && password.equals("123");
    }
}

