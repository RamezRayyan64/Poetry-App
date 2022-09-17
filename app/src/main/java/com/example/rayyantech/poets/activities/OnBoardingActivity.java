package com.example.rayyantech.poetry_app_ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.rayyantech.poetry_app_ui.R;
import com.example.rayyantech.poetry_app_ui.adapters.SliderAdapter;
import com.example.rayyantech.poetry_app_ui.databinding.ActivityOnBoardingBinding;

public class OnBoardingActivity extends AppCompatActivity {

    private ActivityOnBoardingBinding activityOnBoardingBinding;
    private SliderAdapter sliderAdapter;
    private boolean isButtonGetStartedVisible = false;
    private int getCurrentViewPagerItem;
    private long currentTimeMillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOnBoardingBinding = ActivityOnBoardingBinding.inflate(getLayoutInflater());
        getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryLight));
        setContentView(activityOnBoardingBinding.getRoot());
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        setupViewPagerSlider();
    }

    public void setupViewPagerSlider() {
        sliderAdapter = new SliderAdapter(this);
        activityOnBoardingBinding.actOnBoardingViewPagerSlider.setAdapter(sliderAdapter);
        activityOnBoardingBinding.actOnBoardingViewPagerSlider.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {
                    case 0:
                        if (activityOnBoardingBinding.actOnBoardingProgressBar.getProgress() != 25)
                            activityOnBoardingBinding.actOnBoardingProgressBar.setProgress(25);
                        break;
                    case 1:
                        if (activityOnBoardingBinding.actOnBoardingProgressBar.getProgress() != 50)
                            activityOnBoardingBinding.actOnBoardingProgressBar.setProgress(50);
                        break;
                    case 2:
                        if (activityOnBoardingBinding.actOnBoardingProgressBar.getProgress() != 75)
                            activityOnBoardingBinding.actOnBoardingProgressBar.setProgress(75);
                        break;
                    case 3:
                        if (activityOnBoardingBinding.actOnBoardingProgressBar.getProgress() != 100)
                            activityOnBoardingBinding.actOnBoardingProgressBar.setProgress(100);
                        if (activityOnBoardingBinding.actOnBoardingViewPagerSlider.getCurrentItem() ==
                                sliderAdapter.getCount() - 1 && !isButtonGetStartedVisible) {
                            activityOnBoardingBinding.actOnBoardingCardViewGetStarted.setVisibility(View.VISIBLE);
                            activityOnBoardingBinding.actOnBoardingCardViewGetStarted.setAnimation(
                                    AnimationUtils.loadAnimation(OnBoardingActivity.this,
                                            R.anim.anim_act_splash_screen_bottom_to_top));
                            isButtonGetStartedVisible = true;
                        }
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void skipOnBoardingSlider(View view) {
        startActivity(new Intent(this, SignInActivity.class));
        finish();
    }

    public void previousViewPagerItem(View view) {
        getCurrentViewPagerItem = activityOnBoardingBinding.actOnBoardingViewPagerSlider.getCurrentItem();
        activityOnBoardingBinding.actOnBoardingViewPagerSlider.setCurrentItem(getCurrentViewPagerItem - 1);
    }

    public void nextViewPagerItem(View view) {
        getCurrentViewPagerItem = activityOnBoardingBinding.actOnBoardingViewPagerSlider.getCurrentItem();
        activityOnBoardingBinding.actOnBoardingViewPagerSlider.setCurrentItem(getCurrentViewPagerItem + 1);
    }

    @Override
    public void onBackPressed() {
        if ((currentTimeMillis + 2000) > System.currentTimeMillis()) {
            finish();
        } else {
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        currentTimeMillis = System.currentTimeMillis();
    }
}