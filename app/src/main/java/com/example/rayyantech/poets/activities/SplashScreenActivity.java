package com.example.rayyantech.poetry_app_ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.rayyantech.poetry_app_ui.R;
import com.example.rayyantech.poetry_app_ui.databinding.ActivitySplashScreenBinding;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashScreenBinding activitySplashScreenBinding = ActivitySplashScreenBinding
                .inflate(getLayoutInflater());
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryLight));
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryLight));
        setContentView(activitySplashScreenBinding.getRoot());
        new Handler().postDelayed(() -> {
            if (getSharedPreferences("Poets", MODE_PRIVATE).getBoolean("firstTimeOnBoard", true)) {
                startActivity(new Intent(this, OnBoardingActivity.class));
            } else if (getSharedPreferences("Poets", MODE_PRIVATE).getBoolean("firstTimeSignIn", true)){
                startActivity(new Intent(this, SignInActivity.class));
            } else {
                startActivity(new Intent(this, HomeActivity.class));
            }
            finish();
        }, 3000);
    }

    @Override
    public void onBackPressed() {
    }
}