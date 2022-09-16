package com.rayyantech.poets.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rayyantech.poets.R;
import com.rayyantech.poets.databinding.ActivityPoemProfileBinding;

public class PoemProfileActivity extends AppCompatActivity {

    ActivityPoemProfileBinding activityPoemProfileBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPoemProfileBinding = ActivityPoemProfileBinding.inflate(getLayoutInflater());
        setContentView(activityPoemProfileBinding.getRoot());
        setupPoemProfile();
    }

    public void setupPoemProfile() {
        // add likesPoem information that clicked below
        Bundle bundle = getIntent().getExtras();
        String userProfileImage = bundle.getString("userProfileImage", "");
        String userFullname = bundle.getString("userFullname");
        String userPhone = bundle.getString("userPhone");
        activityPoemProfileBinding.actPoemProfileImageViewProfile.setImageResource(Integer.parseInt(userProfileImage));
        if (!userProfileImage.equals("")) {
            activityPoemProfileBinding.actPoemProfileImageViewSimpleProfile.setVisibility(View.GONE);
        }
        activityPoemProfileBinding.actPoemProfileTextViewUserName.setText(userFullname);
        activityPoemProfileBinding.actPoemProfileTextViewUserPhoneNumber.setText(userPhone);
        activityPoemProfileBinding.actPoemProfileTextViewFriends.setText(getString(R.string.text_friends_count));
        activityPoemProfileBinding.actPoemProfileTextViewPoets.setText(getString(R.string.text_poets_count));
        activityPoemProfileBinding.actPoemProfileTextViewPosts.setText(getString(R.string.text_posts_count));
    }

    public void goBack(View view) {
        finish();
    }
}