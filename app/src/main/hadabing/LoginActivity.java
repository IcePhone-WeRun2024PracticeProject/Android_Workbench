package com.example.hadabing;
import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.example.hadabing.LoginFragment;


public class LoginActivity extends AppCompatActivity{


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        // 创建适配器
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // 添加片段到适配器
        adapter.addFragment(new LoginFragment(), "登录");
        adapter.addFragment(new RegisterFragment(), "注册");

        // 设置适配器
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        // 设置自定义标签布局
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.getTabAt(0).setCustomView(R.layout.custom_tab_item);
        tabLayout.getTabAt(1).setCustomView(R.layout.custom_tab_item);
    }
}
