package com.rayyantech.poets.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.rayyantech.poets.R;
import com.rayyantech.poets.adapters.FragementAdapter;
import com.rayyantech.poets.databinding.ActivityHomeBinding;
import com.rayyantech.poets.fragments.FragmentPoemFight;
import com.rayyantech.poets.fragments.FragmentHome;
import com.rayyantech.poets.fragments.FragmentUsers;
import com.rayyantech.poets.fragments.FragmentUserProfile;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding activityHomeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(activityHomeBinding.getRoot());
        getSharedPreferences("Poets", MODE_PRIVATE).edit().putBoolean("firstTimeSignIn", false).apply();
        setupChipNavigationBarListener();
        setupNavigationView();
        setupViewPager();
    }

    public void setupViewPager() {
        FragementAdapter fragementAdapter = new FragementAdapter(getSupportFragmentManager());
        fragementAdapter.addFragment(new FragmentHome());
        fragementAdapter.addFragment(new FragmentPoemFight());
        fragementAdapter.addFragment(new FragmentUsers());
        fragementAdapter.addFragment(new FragmentUserProfile());
        activityHomeBinding.actHomeViewPager.setAdapter(fragementAdapter);
        activityHomeBinding.actHomeViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        activityHomeBinding.actHomeChipNavigationBar.setItemSelected(R.id.menu_chip_navigation_bar_home,
                                true);
                        break;
                    case 1:
                        activityHomeBinding.actHomeChipNavigationBar.setItemSelected(R.id.menu_chip_navigation_bar_fight,
                                true);
                        break;
                    case 2:
                        activityHomeBinding.actHomeChipNavigationBar.setItemSelected(R.id.menu_chip_navigation_bar_poems,
                                true);
                        break;
                    case 3:
                        activityHomeBinding.actHomeChipNavigationBar.setItemSelected(R.id.menu_chip_navigation_bar_user_profile,
                                true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    public void setupNavigationView() {
        activityHomeBinding.actHomeNavigationView.setCheckedItem(R.id.menu_navigation_view_home);
        activityHomeBinding.actHomeNavigationView.bringToFront();
        activityHomeBinding.actHomeNavigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_navigation_view_home:
                    activityHomeBinding.actHomeDrawerLayout.closeDrawer(GravityCompat.START);
                    activityHomeBinding.actHomeChipNavigationBar.setItemSelected(R.id.menu_chip_navigation_bar_home, false);
                    break;
                case R.id.menu_navigation_view_invite_friend:
                    break;
                case R.id.menu_navigation_view_share:
                    break;
                case R.id.menu_navigation_view_contact_us:
                    startActivity(new Intent(this, ContactUsActivity.class));
                    break;
                case R.id.menu_navigation_view_logout:
                    break;
            }
            return true;
        });
    }

    int j = 0;

    @SuppressLint("NonConstantResourceId")
    public void setupChipNavigationBarListener() {
        activityHomeBinding.actHomeChipNavigationBar.setItemSelected(R.id.menu_chip_navigation_bar_home, true);
        activityHomeBinding.actHomeChipNavigationBar.setOnItemSelectedListener(i -> {
            switch (i) {
                case R.id.menu_chip_navigation_bar_navigation_view:
                    activityHomeBinding.actHomeDrawerLayout.openDrawer(GravityCompat.START);
                    activityHomeBinding.actHomeChipNavigationBar.setItemSelected(j, true);
                    break;
                case R.id.menu_chip_navigation_bar_home:
                    activityHomeBinding.actHomeViewPager.setCurrentItem(0);
                    j = activityHomeBinding.actHomeChipNavigationBar.getSelectedItemId();
                    break;
                case R.id.menu_chip_navigation_bar_fight:
                    activityHomeBinding.actHomeViewPager.setCurrentItem(1);
                    j = activityHomeBinding.actHomeChipNavigationBar.getSelectedItemId();
                    break;
                case R.id.menu_chip_navigation_bar_poems:
                    activityHomeBinding.actHomeViewPager.setCurrentItem(2);
                    j = activityHomeBinding.actHomeChipNavigationBar.getSelectedItemId();
                    break;
                case R.id.menu_chip_navigation_bar_user_profile:
                    activityHomeBinding.actHomeViewPager.setCurrentItem(3);
                    j = activityHomeBinding.actHomeChipNavigationBar.getSelectedItemId();
                    break;
            }
        });
    }
}