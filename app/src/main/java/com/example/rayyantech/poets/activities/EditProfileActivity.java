package com.example.rayyantech.poetry_app_ui.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.rayyantech.poetry_app_ui.R;
import com.example.rayyantech.poetry_app_ui.databinding.ActivityEditProfileBinding;

import java.util.ArrayList;
import java.util.List;

public class EditProfileActivity extends AppCompatActivity {

    private static final int IMAGE_REQUEST_CODE = 100;
    ActivityEditProfileBinding activityEditProfileBinding;
    private Uri imageUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityEditProfileBinding = ActivityEditProfileBinding.inflate(getLayoutInflater());
        setContentView(activityEditProfileBinding.getRoot());
        setupUserProfile();
        setupSpinner();
    }

    public void setupUserProfile() {
        int userProfileImage = getIntent().getIntExtra("userProfileImage", 0);
        String userName = getIntent().getStringExtra("userName");
        String userLastname = getIntent().getStringExtra("userLastname");
        String userPhone = getIntent().getStringExtra("userPhone");
        if (userProfileImage != 0) {
            activityEditProfileBinding.actEditProfileImageViewProfile.setImageResource(userProfileImage);
            activityEditProfileBinding.actEditProfileImageViewCamera.setVisibility(View.GONE);
        }
        activityEditProfileBinding.actEditProfileEditTextUserName.setText(userName);
        activityEditProfileBinding.actEditProfileEditTextUserLastname.setText(userLastname);
        activityEditProfileBinding.actEditProfileEditTextPhoneNumber.setText(userPhone);
    }

    public void setupSpinner() {
        List<String> spinnerList = new ArrayList<>();
        spinnerList.add("نوعیت کاربر را انتخاب نمایید...");
        spinnerList.add("شاعر");
        spinnerList.add("شعر دوست");
        spinnerList.add("نمیخواهم مشخص کنم");
        activityEditProfileBinding.actEditProfileSpinner.setAdapter(new ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item, spinnerList));
    }

    public void getImageFromStorage(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK && data.getData() != null) {
            activityEditProfileBinding.actEditProfileImageViewProfile.setImageURI(data.getData());
            activityEditProfileBinding.actEditProfileImageViewCamera.setVisibility(View.INVISIBLE);
            imageUri = data.getData();
        }
    }

    public void goBack(View view) {
        finish();
    }

    public void editProfile(View view) {

    }
}