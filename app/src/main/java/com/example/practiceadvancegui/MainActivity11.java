package com.example.practiceadvancegui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity11 extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    TextView txtHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);

        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar11);
        navigationView = findViewById(R.id.navView);

        setSupportActionBar(toolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity11.this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                ShowFragment(item.getItemId());
                return true;
            }
        });
        ShowFragment(R.id.mnuHome);

        View headerView = navigationView.getHeaderView(0);
        txtHeader = headerView.findViewById(R.id.txtAccount);
        txtHeader.setText("abce@exam.com");
    }

    private void ShowFragment(int itemId) {
        Fragment fragment = null;
        switch (itemId)
        {
            case R.id.mnuHome:
                fragment = new HomeFragment();
                toolbar.setTitle("Home");
                break;

            case R.id.mnuDashboard:
                fragment = new DashboardFragment();
                toolbar.setTitle("Dashboard");
                break;

            case R.id.mnuProfile:
                fragment = new ProfileFragment();
                toolbar.setTitle("Profile");
                break;
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content,fragment);
        ft.commit();
        drawerLayout.closeDrawers();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        actionBarDrawerToggle.syncState();
    }
}