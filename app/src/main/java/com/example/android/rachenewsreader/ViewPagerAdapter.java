package com.example.android.rachenewsreader;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.android.rachenewsreader.fragment.DashboardFragment;
import com.example.android.rachenewsreader.fragment.HomeFragment;
import com.example.android.rachenewsreader.fragment.ScienceFragment;
import com.example.android.rachenewsreader.fragment.SportsFragment;

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
            case Constants.FRAGMENT_SPORTS:
                return new SportsFragment();
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
