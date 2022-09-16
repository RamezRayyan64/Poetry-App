package com.rayyantech.poets.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.rayyantech.poets.databinding.ActivityContactUsBinding;

public class ContactUsActivity extends AppCompatActivity {

    ActivityContactUsBinding activityContactUsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityContactUsBinding = ActivityContactUsBinding.inflate(getLayoutInflater());
        setContentView(activityContactUsBinding.getRoot());
    }

    public void goToHome(View view) {
        finish();
    }
}