package com.example.practiceadvancegui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MainAdapter extends FragmentStatePagerAdapter {

    public MainAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new HomeFragment();
            case 1: return new DashboardFragment();
            case 2: return new ProfileFragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
