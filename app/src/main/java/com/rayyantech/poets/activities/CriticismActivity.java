package com.rayyantech.poets.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.rayyantech.poets.R;
import com.rayyantech.poets.adapters.CommentAdapter;
import com.rayyantech.poets.adapters.CriticismAdapter;
import com.rayyantech.poets.databinding.ActivityCriticismBinding;
import com.rayyantech.poets.models.CommentModel;
import com.rayyantech.poets.models.CriticismModel;

import java.util.ArrayList;
import java.util.List;

public class CriticismActivity extends AppCompatActivity {

    private ActivityCriticismBinding activityCriticismBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCriticismBinding = ActivityCriticismBinding.inflate(getLayoutInflater());
        setContentView(activityCriticismBinding.getRoot());
        setupRecyclerView();
        setupPostInformation();
    }

    public void setupPostInformation() {
        // add post information the clicked one below
        Bundle bundle = getIntent().getExtras();
        if (!bundle.getString("userProfileImage").equals("")) {
            activityCriticismBinding.actCriticismImageViewProfile
                    .setImageResource(Integer.parseInt(bundle.getString("userProfileImage")));
            activityCriticismBinding.actCriticismImageViewSimpleProfile.setVisibility(View.GONE);
        }
        if (!bundle.getString("postImage").equals("")) {
            activityCriticismBinding.actCriticismImageViewPostImage
                    .setImageResource(Integer.parseInt(bundle.getString("postImage")));
            activityCriticismBinding.actCriticismImageViewPostImage.setVisibility(View.VISIBLE);
        }
        String postUserName = bundle.getString("userFullname");
        String postTime = bundle.getString("postTime");
        String postContext = bundle.getString("postContext");
        activityCriticismBinding.actCriticismTextViewText.setText(postContext);
        activityCriticismBinding.actCriticismTextViewName.setText(postUserName);
        activityCriticismBinding.actCriticismTextViewTime.setText(postTime);

    }

    public void setupRecyclerView() {
        activityCriticismBinding.actCriticismRecyclerViewCriticism.setHasFixedSize(true);
        activityCriticismBinding.actCriticismRecyclerViewCriticism.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        List<CriticismModel> criticismModelList = new ArrayList<>();
        // add comments of users below
        criticismModelList.add(new CriticismModel(R.drawable.simple_profile_image + "", getString(R.string.text_name_example),
                getString(R.string.text_time_example), getString(R.string.text_example)));
        criticismModelList.add(new CriticismModel(R.drawable.simple_profile_image + "", getString(R.string.text_name_example),
                getString(R.string.text_time_example), getString(R.string.text_example)));

        if (criticismModelList.size() != 0) {
            activityCriticismBinding.actCriticismLayoutEmpty.setVisibility(View.GONE);
        }
        CriticismAdapter criticismAdapter = new CriticismAdapter(criticismModelList, this);
        activityCriticismBinding.actCriticismRecyclerViewCriticism.setAdapter(criticismAdapter);
    }

    public void goToHome(View view) {
        finish();
    }
}