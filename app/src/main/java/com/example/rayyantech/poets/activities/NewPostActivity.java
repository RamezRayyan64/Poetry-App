package com.example.rayyantech.poetry_app_ui.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.rayyantech.poetry_app_ui.R;
import com.example.rayyantech.poetry_app_ui.databinding.ActivityNewPostBinding;

import java.util.ArrayList;
import java.util.List;

public class NewPostActivity extends AppCompatActivity {

    private ActivityNewPostBinding activityNewPostBinding;
    private final int REQUEST_CODE_IMAGE = 100;
    private Uri postImage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityNewPostBinding = ActivityNewPostBinding.inflate(getLayoutInflater());
        setContentView(activityNewPostBinding.getRoot());
        setupCurrentUserInfo();
        setupSpinner();
        getImageFromDevice();
    }

    public void setupCurrentUserInfo() {
        activityNewPostBinding.actNewPostImageViewProfileImage.setImageResource(R.drawable.simple_profile_image);
        activityNewPostBinding.layoutUsersLeftImageViewSimpleProfile.setVisibility(View.GONE);
        activityNewPostBinding.actNewPostTextViewName.setText(getString(R.string.text_name_example));
    }

    public void getImageFromDevice() {
        activityNewPostBinding.actNewPostLayoutImage.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(intent, REQUEST_CODE_IMAGE);
        });
    }

    public void setupSpinner() {
        List<String> spinnerList = new ArrayList<>();
        spinnerList.add("نوعیت پست را انتخاب نمایید...");
        spinnerList.add("عمومی");
        spinnerList.add("دوستان");
        spinnerList.add("خصوصی");
        activityNewPostBinding.actNewPostSpinner.setAdapter(new ArrayAdapter(this,
                R.layout.support_simple_spinner_dropdown_item, spinnerList));
    }

    public void addPost(View view) {
        // get post information below and add to server or database or ...

    }

    public void goToHome(View view) {
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_IMAGE && resultCode == RESULT_OK && data.getData() != null) {
            activityNewPostBinding.actNewPostImageViewPostImage.setImageURI(data.getData());
            activityNewPostBinding.actNewPostImageViewPostImage.setVisibility(View.VISIBLE);
            postImage = data.getData();
        }
    }
}