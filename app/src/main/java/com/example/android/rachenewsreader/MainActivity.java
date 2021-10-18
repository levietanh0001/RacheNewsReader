package com.example.android.rachenewsreader;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.example.android.rachenewsreader.ViewPagerAdapter;
import com.example.android.rachenewsreader.fragment.HomeFragment;
import com.example.android.rachenewsreader.fragment.DashboardFragment;
import com.example.android.rachenewsreader.fragment.ScienceFragment;
import com.example.android.rachenewsreader.fragment.WorldFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
//import com.example.android.newsfeed.adapter.CategoryFragmentPagerAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.android.rachenewsreader.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.example.android.rachenewsreader.Constants;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;
    public int currentFragment = Constants.FRAGMENT_HOME;
    private TabLayout mTabLayout;
    private ViewPagerAdapter mViewPagerAdapter;
    private ViewPager2 mViewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        mViewPager2 = findViewById(R.id.view_pager_2);
        TabLayout mTabLayout = findViewById(R.id.sliding_tabs);
        mViewPagerAdapter = new ViewPagerAdapter(this);
        mViewPager2.setAdapter(mViewPagerAdapter);


        new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case Constants.FRAGMENT_DASHBOARD:
                        tab.setText(getString(R.string.dashboard));
                        break;
                    case Constants.FRAGMENT_HOME:
                        tab.setText(getString(R.string.home));
                        break;
                    case Constants.FRAGMENT_WORLD:
                        tab.setText(getString(R.string.world));
                        break;
                    case Constants.FRAGMENT_SCIENCE:
                        tab.setText(getString(R.string.science));
                        break;
                }
            }
        }).attach();
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        NavigationView navigationView = findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);


        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case Constants.FRAGMENT_HOME:
                        currentFragment = Constants.FRAGMENT_HOME;
                        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
                        break;
                    case Constants.FRAGMENT_WORLD:
                        currentFragment = Constants.FRAGMENT_WORLD;
                        navigationView.getMenu().findItem(R.id.nav_world).setChecked(true);
                        break;
                    case Constants.FRAGMENT_SCIENCE:
                        currentFragment = Constants.FRAGMENT_SCIENCE;
                        navigationView.getMenu().findItem(R.id.nav_science).setChecked(true);
                        break;
                    case Constants.FRAGMENT_DASHBOARD:
                        currentFragment = Constants.FRAGMENT_DASHBOARD;
                        navigationView.getMenu().findItem(R.id.nav_dashboard).setChecked(true);
                        break;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.i("FRAGMENTS", "switch between fragments on item click in nav drawer");
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            if (Constants.FRAGMENT_HOME != currentFragment) {
                mViewPager2.setCurrentItem(Constants.FRAGMENT_HOME);
                currentFragment = Constants.FRAGMENT_HOME;
            }
        }
        else if (id == R.id.nav_world) {
            if (Constants.FRAGMENT_WORLD != currentFragment) {
                mViewPager2.setCurrentItem(Constants.FRAGMENT_WORLD);
                currentFragment = Constants.FRAGMENT_WORLD;
            }
        }
        else if (id == R.id.nav_science) {
            if (Constants.FRAGMENT_SCIENCE != currentFragment) {
                mViewPager2.setCurrentItem(Constants.FRAGMENT_SCIENCE);
                currentFragment = Constants.FRAGMENT_SCIENCE;
            }
        }
        else if (id == R.id.nav_dashboard) {
            if (Constants.FRAGMENT_DASHBOARD != currentFragment) {
                mViewPager2.setCurrentItem(Constants.FRAGMENT_DASHBOARD);
                currentFragment = Constants.FRAGMENT_DASHBOARD;
            }
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}