package com.rayyantech.poets.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.rayyantech.poets.R;
import com.rayyantech.poets.adapters.CommentAdapter;
import com.rayyantech.poets.databinding.ActivityCommentBinding;
import com.rayyantech.poets.models.CommentModel;
import com.rayyantech.poets.models.CriticismModel;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity {

    private ActivityCommentBinding activityCommentBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCommentBinding = ActivityCommentBinding.inflate(getLayoutInflater());
        setContentView(activityCommentBinding.getRoot());
        setupPostInformation();
        setupRecyclerView();
    }

    public void setupPostInformation() {
        // add post information the clicked one below
        Bundle bundle = getIntent().getExtras();
        String postUserName = bundle.getString("userFullname");
        String postTime = bundle.getString("postTime");
        String postContext = bundle.getString("postContext");
        if (!bundle.getString("userProfileImage").equals("")) {
            activityCommentBinding.actCommentImageViewProfile
                    .setImageResource(Integer.parseInt(bundle.getString("userProfileImage")));
            activityCommentBinding.actCommentImageViewSimpleProfile.setVisibility(View.GONE);
        }
        if (!bundle.getString("postImage").equals("")) {
            activityCommentBinding.actCommentImageViewPostImage
                    .setImageResource(Integer.parseInt(bundle.getString("postImage")));
            activityCommentBinding.actCommentImageViewPostImage.setVisibility(View.VISIBLE);
        }
        activityCommentBinding.actCommentTextViewText.setText(postContext);
        activityCommentBinding.actCommentTextViewName.setText(postUserName);
        activityCommentBinding.actCommentTextViewTime.setText(postTime);

    }

    public void setupRecyclerView() {
        activityCommentBinding.actCommentRecyclerViewComments.setHasFixedSize(true);
        activityCommentBinding.actCommentRecyclerViewComments.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        List<CommentModel> commentModelList = new ArrayList<>();
        // add comments of users below
        commentModelList.add(new CommentModel(R.drawable.simple_profile_image + "", getString(R.string.text_name_example),
                getString(R.string.text_time_example), getString(R.string.text_example)));
        commentModelList.add(new CommentModel(R.drawable.simple_profile_image + "", getString(R.string.text_name_example),
                getString(R.string.text_time_example), getString(R.string.text_example)));


        if (commentModelList.size() != 0) {
            activityCommentBinding.actCommentLayoutEmpty.setVisibility(View.GONE);
        }
        CommentAdapter commentAdapter = new CommentAdapter(commentModelList, this);
        activityCommentBinding.actCommentRecyclerViewComments.setAdapter(commentAdapter);
    }

    public void goToHome(View view) {
        finish();
    }
}