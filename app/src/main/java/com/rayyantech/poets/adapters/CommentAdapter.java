package com.rayyantech.poets.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.rayyantech.poets.R;
import com.rayyantech.poets.models.CommentModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    List<CommentModel> commentModelList;
    Context context;

    public CommentAdapter(List<CommentModel> commentModelList, Context context) {
        this.commentModelList = commentModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_comment, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CommentModel commentModel = commentModelList.get(position);
        holder.circleImageView.setImageResource(Integer.parseInt(commentModel.getUserProfileImageUri()));
        holder.name.setText(commentModel.getTextUserName());
        holder.time.setText(commentModel.getTextCommentTime());
        holder.text.setText(commentModel.getTextUserComment());
        if (position == commentModelList.size() - 1) {
            holder.view.setVisibility(View.GONE);
        }
        if (!commentModel.getUserProfileImageUri().equals("")) {
            holder.imageViewSimpleProfile.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return commentModelList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView circleImageView;
        AppCompatTextView name, time, text;
        AppCompatImageView imageViewSimpleProfile;
        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.layout_comment_image_view_profile);
            imageViewSimpleProfile = itemView.findViewById(R.id.layout_comment_image_view_simple_profile);
            name = itemView.findViewById(R.id.layout_comment_text_view_name);
            time = itemView.findViewById(R.id.layout_comment_text_view_time);
            text = itemView.findViewById(R.id.layout_comment_text_view_comment);
            view = itemView.findViewById(R.id.layout_comment_view_line);
        }
    }
}
