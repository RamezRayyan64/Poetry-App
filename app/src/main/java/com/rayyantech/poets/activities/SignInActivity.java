package com.rayyantech.poets.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rayyantech.poets.R;
import com.rayyantech.poets.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {

    private ActivitySignInBinding activitySignInBinding;
    private long currentTimeMillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySignInBinding = ActivitySignInBinding.inflate(getLayoutInflater());
        getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryLight));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        setContentView(activitySignInBinding.getRoot());
        getSharedPreferences("Poets", MODE_PRIVATE).edit().putBoolean("firstTimeOnBoard", false).apply();
    }

    public void signIn(View view) {
        // get should get user name and phone below


        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    public void signInAsGuest(View view) {
        // sign in user as guest below


    }

    public void createNewAccount(View view) {
        startActivity(new Intent(this, SignUpActivity.class));
        finish();
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