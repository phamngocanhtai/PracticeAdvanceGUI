package com.example.practiceadvancegui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity9 extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        viewPager = findViewById(R.id.viewpager9);
        mainAdapter = new MainAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(mainAdapter);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Home").setIcon(R.drawable.ic_baseline_home_24);
        tabLayout.getTabAt(1).setText("Dashboard").setIcon(R.drawable.ic_baseline_dashboard_24);
        tabLayout.getTabAt(2).setText("Profile").setIcon(R.drawable.ic_baseline_copyright_24);
    }
}