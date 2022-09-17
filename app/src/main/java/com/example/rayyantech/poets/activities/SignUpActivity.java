package com.example.rayyantech.poetry_app_ui.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.rayyantech.poetry_app_ui.R;
import com.example.rayyantech.poetry_app_ui.databinding.ActivitySignUpBinding;

import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends AppCompatActivity {

    private static final int IMAGE_REQUEST_CODE = 100;
    private ActivitySignUpBinding activitySignUpBinding;
    private long currentTimeMillis;
    private Uri imageUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySignUpBinding = ActivitySignUpBinding.inflate(getLayoutInflater());
        getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryLight));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
        setupSpinner();
        setContentView(activitySignUpBinding.getRoot());
    }

    public void setupSpinner() {
        List<String> spinnerList = new ArrayList<>();
        spinnerList.add("نوعیت کاربر را انتخاب نمایید...");
        spinnerList.add("شاعر");
        spinnerList.add("شعر دوست");
        spinnerList.add("نمیخواهم مشخص کنم");
        activitySignUpBinding.actSignUpSpinner.setAdapter(new ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item, spinnerList));
    }

    public void signUp(View view) {
        // get all information of user below and create an account for it


        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    public void getImageFromStorage(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_REQUEST_CODE);
    }

    public void goBack(View view) {
        startActivity(new Intent(this, SignInActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK && data.getData() != null) {
            activitySignUpBinding.actSignUpImageViewProfile.setImageURI(data.getData());
            activitySignUpBinding.actSignUpImageViewCamera.setVisibility(View.INVISIBLE);
            imageUri = data.getData();
        }
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