package com.example.practiceadvancegui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity10 extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        bottomNavigationView = findViewById(R.id.bottomNAV);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                ShowFragment(item.getItemId());
                return true;
            }
        });
        ShowFragment(R.id.mnuHome);
    }

    private void ShowFragment(int itemId) {
        Fragment fragment = null;
        switch (itemId)
        {
            case R.id.mnuHome:
                fragment = new HomeFragment(); break;
            case R.id.mnuDashboard:
                fragment = new DashboardFragment(); break;
            case R.id.mnuProfile:
                fragment = new ProfileFragment(); break;
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content,fragment);
        ft.commit();
    }
    }