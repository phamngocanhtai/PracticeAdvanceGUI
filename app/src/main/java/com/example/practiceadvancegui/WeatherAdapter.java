package com.example.practiceadvancegui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class WeatherAdapter extends FragmentStatePagerAdapter {

    public WeatherAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0: return WeatherFragment.newInstance(0);
            case 1: return WeatherFragment.newInstance(1);
            case 2: return WeatherFragment.newInstance(2);
            case 3: return WeatherFragment.newInstance(3);
            case 4: return WeatherFragment.newInstance(4);
            default: return null;
        }
            }

    @Override
    public int getCount() {
        return 5;
    }
}
