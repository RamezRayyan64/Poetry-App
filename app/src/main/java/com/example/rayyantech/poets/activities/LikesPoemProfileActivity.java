package com.example.rayyantech.poetry_app_ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.rayyantech.poetry_app_ui.R;
import com.example.rayyantech.poetry_app_ui.databinding.ActivityLikesPoemProfileBinding;

public class LikesPoemProfileActivity extends AppCompatActivity {

    ActivityLikesPoemProfileBinding activityLikesPoemProfileBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLikesPoemProfileBinding = ActivityLikesPoemProfileBinding.inflate(getLayoutInflater());
        setContentView(activityLikesPoemProfileBinding.getRoot());
        setupLikesPoemProfile();
    }

    public void setupLikesPoemProfile() {
        // add likesPoem information that clicked below
        Bundle bundle = getIntent().getExtras();
        String userProfileImage = bundle.getString("userProfileImage", "");
        String userFullname = bundle.getString("userFullname");
        String userPhone = bundle.getString("userPhone");
        activityLikesPoemProfileBinding.actLikePoemProfileImageViewProfile.setImageResource(Integer.parseInt(userProfileImage));
        if (!userProfileImage.equals("")) {
            activityLikesPoemProfileBinding.actLikePoemProfileImageViewSimpleProfile.setVisibility(View.GONE);
        }
        activityLikesPoemProfileBinding.actLikePoemProfileTextViewUserName.setText(userFullname);
        activityLikesPoemProfileBinding.actLikePoemProfileTextViewUserPhoneNumber.setText(userPhone);
        activityLikesPoemProfileBinding.actLikePoemProfileTextViewFriends.setText(getString(R.string.text_friends_count));
        activityLikesPoemProfileBinding.actLikePoemProfileTextViewPoets.setText(getString(R.string.text_poets_count));
    }

    public void goBack(View view) {
        finish();
    }
}