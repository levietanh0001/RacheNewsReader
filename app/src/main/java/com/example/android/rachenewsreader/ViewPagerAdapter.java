package com.example.android.rachenewsreader;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.android.rachenewsreader.Constants;
import com.example.android.rachenewsreader.fragment.DashboardFragment;
import com.example.android.rachenewsreader.fragment.HomeFragment;
import com.example.android.rachenewsreader.fragment.ScienceFragment;
import com.example.android.rachenewsreader.fragment.WorldFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {


    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case Constants.FRAGMENT_HOME:
                return new HomeFragment();
            case Constants.FRAGMENT_WORLD:
                return new WorldFragment();
            case Constants.FRAGMENT_SCIENCE:
                return new ScienceFragment();
            case Constants.FRAGMENT_DASHBOARD:
                return new DashboardFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }


}
