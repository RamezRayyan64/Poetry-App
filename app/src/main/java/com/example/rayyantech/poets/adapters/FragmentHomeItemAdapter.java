package com.example.rayyantech.poetry_app_ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rayyantech.poetry_app_ui.R;
import com.example.rayyantech.poetry_app_ui.activities.CommentActivity;
import com.example.rayyantech.poetry_app_ui.activities.CriticismActivity;
import com.example.rayyantech.poetry_app_ui.activities.PoemProfileActivity;
import com.example.rayyantech.poetry_app_ui.models.FragmentHomeItemModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentHomeItemAdapter extends RecyclerView.Adapter<FragmentHomeItemAdapter.ViewHolder> {

    private final List<FragmentHomeItemModel> fragmentHomeItemModelList;
    private final Context context;
    private boolean isMore = false;

    public FragmentHomeItemAdapter(List<FragmentHomeItemModel> fragmentHomeItemModelList, Context context) {
        this.fragmentHomeItemModelList = fragmentHomeItemModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_fragment_home_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FragmentHomeItemModel fragmentHomeItemModel = fragmentHomeItemModelList.get(position);
        if (!fragmentHomeItemModel.getUserProfileImageUri().equals("")) {
            holder.circleImageView.setImageResource(Integer.parseInt(fragmentHomeItemModel.getUserProfileImageUri()));
        }
        holder.userName.setText(fragmentHomeItemModel.getTextUserName());
        holder.userText.setText(fragmentHomeItemModel.getTextPostContext());
        holder.userText.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {

            @Override
            public boolean onPreDraw() {
                holder.userText.getViewTreeObserver().removeOnPreDrawListener(this);
                int lineCount = holder.userText.getLineCount();
                holder.userText.setMaxLines(2);
                if (lineCount > 2) {
                    holder.textMore.setOnClickListener(e -> {
                        if (!isMore) {
                            holder.userText.setMaxLines(lineCount);
                            holder.textMore.setText("کمتر");
                            isMore = true;
                        } else {
                            holder.userText.setMaxLines(2);
                            holder.textMore.setText("... بیشتر");
                            isMore = false;
                        }
                    });
                } else {
                    holder.textMore.setVisibility(View.GONE);
                }
                return true;
            }
        });
        holder.textViewTime.setText(fragmentHomeItemModel.getTextPostTime());
        if (!fragmentHomeItemModel.getPostImageUri().equals("")) {
            holder.postImage.setVisibility(View.VISIBLE);
            holder.postImage.setImageResource(Integer.parseInt(fragmentHomeItemModel.getPostImageUri()));
        }
        if (!fragmentHomeItemModel.getUserProfileImageUri().equals("")) {
            holder.imageViewSimpleProfile.setVisibility(View.GONE);
        }
        Bundle bundle = new Bundle();
        bundle.putString("userProfileImage", fragmentHomeItemModel.getUserProfileImageUri());
        bundle.putString("postImage", fragmentHomeItemModel.getPostImageUri());
        bundle.putString("userFullname", fragmentHomeItemModel.getTextUserName());
        bundle.putString("postTime", fragmentHomeItemModel.getTextPostTime());
        bundle.putString("postContext", fragmentHomeItemModel.getTextPostContext());
        bundle.putString("userPhone", fragmentHomeItemModel.getTextUserPhone());
        holder.buttonComment.setOnClickListener(v -> {
            context.startActivity(new Intent(context.getApplicationContext(), CommentActivity.class)
                    .putExtras(bundle));
        });
        holder.buttonCriticism.setOnClickListener(v -> {
            context.startActivity(new Intent(context.getApplicationContext(), CriticismActivity.class)
                    .putExtras(bundle));
        });
        holder.circleImageView.setOnClickListener(v -> {
            context.startActivity(new Intent(context, PoemProfileActivity.class)
            .putExtras(bundle));
        });
        holder.buttonMenu.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(context, v);
            popupMenu.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case R.id.popup_menu_fragment_home_item_first_option:
                        Toast.makeText(context, "گزینه اول", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            });
            popupMenu.inflate(R.menu.menu_popup_menu_fragment_home_item);
            popupMenu.show();
        });
    }

    @Override
    public int getItemCount() {
        return fragmentHomeItemModelList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView circleImageView;
        AppCompatTextView userName, userText, textMore, textViewTime;
        AppCompatImageView postImage, imageViewSimpleProfile, buttonMenu;
        AppCompatButton buttonLike, buttonComment, buttonCriticism;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.layout_fragment_home_item_image_view_profile);
            imageViewSimpleProfile = itemView.findViewById(R.id.layout_fragment_home_item_image_view_simple_profile);
            userName = itemView.findViewById(R.id.layout_fragment_home_item_text_view_name);
            userText = itemView.findViewById(R.id.layout_fragment_home_item_text_view_text);
            textViewTime = itemView.findViewById(R.id.layout_fragment_home_item_text_view_time);
            textMore = itemView.findViewById(R.id.layout_fragment_home_item_text_view_more);
            postImage = itemView.findViewById(R.id.layout_fragment_home_item_image_view_post);
            buttonLike = itemView.findViewById(R.id.layout_fragment_home_item_button_like);
            buttonComment = itemView.findViewById(R.id.layout_fragment_home_item_button_comment);
            buttonCriticism = itemView.findViewById(R.id.layout_fragment_home_item_button_criticism);
            buttonMenu = itemView.findViewById(R.id.layout_fragment_home_item_button_menu);
        }
    }
}
