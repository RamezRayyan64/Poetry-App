package com.example.rayyantech.poetry_app_ui.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.rayyantech.poetry_app_ui.R;
import com.example.rayyantech.poetry_app_ui.adapters.FragementAdapter;
import com.example.rayyantech.poetry_app_ui.databinding.FragmentUsersBinding;

public class FragmentUsers extends Fragment {

    private FragmentUsersBinding fragmentUsersBinding;

    @SuppressLint("NonConstantResourceId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentUsersBinding = FragmentUsersBinding.inflate(inflater, container, false);
        FragementAdapter fragementAdapter = new FragementAdapter(getChildFragmentManager());
        fragementAdapter.addFragment(new FragmentPoems());
        fragementAdapter.addFragment(new FragmentLikesPoems());
        fragmentUsersBinding.fragmentUsersViewPagerUsers.setAdapter(fragementAdapter);
        fragmentUsersBinding.fragmentUsersChipNavigationBar.setItemSelected(R.id.menu_chip_navigation_bar_poems_poems, true);
        fragmentUsersBinding.fragmentUsersViewPagerUsers.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        fragmentUsersBinding.fragmentUsersChipNavigationBar.setItemSelected(R.id.menu_chip_navigation_bar_poems_poems,
                                true);
                        break;
                    case 1:
                        fragmentUsersBinding.fragmentUsersChipNavigationBar.setItemSelected(R.id.menu_chip_navigation_bar_poems_like_poems,
                                true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        fragmentUsersBinding.fragmentUsersChipNavigationBar.setOnItemSelectedListener(i -> {
            switch (i) {
                case R.id.menu_chip_navigation_bar_poems_poems:
                    fragmentUsersBinding.fragmentUsersViewPagerUsers.setCurrentItem(0);
                    break;
                case R.id.menu_chip_navigation_bar_poems_like_poems:
                    fragmentUsersBinding.fragmentUsersViewPagerUsers.setCurrentItem(1);
                    break;
            }
        });
        return fragmentUsersBinding.getRoot();
    }
}
