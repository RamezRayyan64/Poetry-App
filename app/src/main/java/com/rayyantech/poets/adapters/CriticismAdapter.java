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
import com.rayyantech.poets.models.CriticismModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CriticismAdapter extends RecyclerView.Adapter<CriticismAdapter.ViewHolder> {

    List<CriticismModel> criticismModelList;
    Context context;

    public CriticismAdapter(List<CriticismModel> criticismModelList, Context context) {
        this.criticismModelList = criticismModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_criticism, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CriticismModel criticismModel = criticismModelList.get(position);
        holder.imageViewProfile.setImageResource(Integer.parseInt(criticismModel.getUserProfileImageUri()));
        holder.textViewName.setText(criticismModel.getTextUserName());
        holder.textViewTime.setText(criticismModel.getTextCriticismTime());
        holder.textViewComment.setText(criticismModel.getTextUserCriticism());
        if (position == criticismModelList.size() - 1) {
            holder.viewLine.setVisibility(View.GONE);
        }
        if (!criticismModel.getUserProfileImageUri().equals("")) {
            holder.imageViewSimpleProfile.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return criticismModelList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imageViewProfile;
        AppCompatTextView textViewName, textViewTime, textViewComment;
        AppCompatImageView imageViewSimpleProfile;
        View viewLine;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewProfile = itemView.findViewById(R.id.layout_criticism_image_view_profile);
            imageViewSimpleProfile = itemView.findViewById(R.id.layout_criticism_image_view_simple_profile);
            textViewName = itemView.findViewById(R.id.layout_criticism_text_view_name);
            textViewTime = itemView.findViewById(R.id.layout_criticism_text_view_time);
            textViewComment = itemView.findViewById(R.id.layout_criticism_text_view_comment);
            viewLine = itemView.findViewById(R.id.layout_criticism_view_line);
        }
    }
}
