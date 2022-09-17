package com.example.rayyantech.poetry_app_ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rayyantech.poetry_app_ui.R;
import com.example.rayyantech.poetry_app_ui.activities.EditProfileActivity;
import com.example.rayyantech.poetry_app_ui.databinding.FragmentUserProfileBinding;

public class FragmentUserProfile extends Fragment {

    private FragmentUserProfileBinding fragmentUserProfileBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentUserProfileBinding = FragmentUserProfileBinding.inflate(inflater, container, false);
        // add userProfile information below
        int userProfileImage = R.drawable.simple_profile_image;
        String userName = getString(R.string.text_name_example).split(" ")[0];
        String userLastname = getString(R.string.text_name_example).split(" ")[1];
        String userPhone = getString(R.string.text_example_phone);
        fragmentUserProfileBinding.fragmentProfileImageViewProfile.setImageResource(userProfileImage);
        fragmentUserProfileBinding.fragmentProfileImageViewSimpleProfile.setVisibility(View.GONE);
        fragmentUserProfileBinding.fragmentProfileTextViewUserName.setText(getString(R.string.text_name_example));
        fragmentUserProfileBinding.fragmentProfileTextViewUserPhoneNumber.setText(userPhone);
        fragmentUserProfileBinding.fragmentUserProfileTextViewPoets.setText(getResources().getText(R.string.text_poets_count));
        fragmentUserProfileBinding.fragmentUserProfileTextViewFriends.setText(getResources().getText(R.string.text_friends_count));
        fragmentUserProfileBinding.fragmentUserProfileTextViewPosts.setText(getResources().getText(R.string.text_posts_count));
        fragmentUserProfileBinding.fragmentProfileButtonEdit.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), EditProfileActivity.class)
                    .putExtra("userProfileImage", userProfileImage)
                    .putExtra("userName", userName)
                    .putExtra("userLastname", userLastname)
                    .putExtra("userPhone", userPhone));
        });
        return fragmentUserProfileBinding.getRoot();
    }
}
