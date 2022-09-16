package com.rayyantech.poets.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.rayyantech.poets.R;
import com.rayyantech.poets.activities.PoemProfileActivity;
import com.rayyantech.poets.models.UsersInfoModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentPoemsItemAdapter extends RecyclerView.Adapter {

    List<UsersInfoModel> usersInfoModelList;
    Context context;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    public FragmentPoemsItemAdapter(List<UsersInfoModel> usersInfoModelList, Context context) {
        this.usersInfoModelList = usersInfoModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == LEFT) {
            return new ViewHolderLeft(LayoutInflater.from(context).inflate(R.layout.layout_users_left, parent, false));
        } else {
            return new ViewHolderRight(LayoutInflater.from(context).inflate(R.layout.layout_users_right, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        UsersInfoModel usersInfoModel = usersInfoModelList.get(position);
        Bundle bundle = new Bundle();
        bundle.putString("userProfileImage", usersInfoModel.getUserProfileImageUri());
        bundle.putString("userFullname", usersInfoModel.getTextUsername());
        bundle.putString("userPhone", usersInfoModel.getTextUserPhone());
        if (holder.getClass() == ViewHolderLeft.class) {
            ((ViewHolderLeft) holder).circleImageView.setImageResource(Integer.parseInt(usersInfoModel.getUserProfileImageUri()));
            ((ViewHolderLeft) holder).userName.setText(usersInfoModel.getTextUsername());
            ((ViewHolderLeft) holder).userPhone.setText(usersInfoModel.getTextUserPhone());
            ((ViewHolderLeft) holder).itemView.setOnClickListener(v -> {
                context.startActivity(new Intent(context, PoemProfileActivity.class)
                        .putExtras(bundle));
            });
            if (usersInfoModel.getUserProfileImageUri() != null) {
                ((ViewHolderLeft) holder).imageViewSimpleProfile.setVisibility(View.GONE);
            }
            ((ViewHolderLeft) holder).popupMenu.setOnClickListener(v -> {
                PopupMenu popupMenu = new PopupMenu(context, v);
                popupMenu.setOnMenuItemClickListener(item -> {
                    switch (item.getItemId()) {
                        case R.id.popup_menu_fragment_users_item_first_option:
                            Toast.makeText(context, "گزینه اول", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    return true;
                });
                popupMenu.inflate(R.menu.menu_popup_menu_fragment_users_item);
                popupMenu.show();
            });
        } else {
            ((ViewHolderRight) holder).circleImageView.setImageResource(Integer.parseInt(usersInfoModel.getUserProfileImageUri()));
            ((ViewHolderRight) holder).userName.setText(usersInfoModel.getTextUsername());
            ((ViewHolderRight) holder).userPhone.setText(usersInfoModel.getTextUserPhone());
            ((ViewHolderRight) holder).itemView.setOnClickListener(v -> {
                context.startActivity(new Intent(context, PoemProfileActivity.class)
                        .putExtras(bundle));
            });
            if (usersInfoModel.getUserProfileImageUri() != null) {
                ((ViewHolderRight) holder).imageViewSimpleProfile.setVisibility(View.GONE);
            }
            ((ViewHolderRight) holder).popupMenu.setOnClickListener(v -> {
                PopupMenu popupMenu = new PopupMenu(context, v);
                popupMenu.setOnMenuItemClickListener(item -> {
                    switch (item.getItemId()) {
                        case R.id.popup_menu_fragment_users_item_first_option:
                            Toast.makeText(context, "گزینه اول", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    return true;
                });
                popupMenu.inflate(R.menu.menu_popup_menu_fragment_users_item);
                popupMenu.show();
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 != 0) {
            return LEFT;
        } else {
            return RIGHT;
        }
    }

    @Override
    public int getItemCount() {
        return usersInfoModelList.size();
    }

    static class ViewHolderLeft extends RecyclerView.ViewHolder {

        CircleImageView circleImageView;
        AppCompatTextView userName, userPhone;
        AppCompatImageView imageViewSimpleProfile, popupMenu;

        public ViewHolderLeft(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.layout_users_left_profile_image);
            userName = itemView.findViewById(R.id.layout_users_left_name);
            userPhone = itemView.findViewById(R.id.layout_users_left_phone);
            imageViewSimpleProfile = itemView.findViewById(R.id.layout_users_left_image_view_simple_profile);
            popupMenu = itemView.findViewById(R.id.layout_users_left_button_menu);
        }
    }

    static class ViewHolderRight extends RecyclerView.ViewHolder {

        CircleImageView circleImageView;
        AppCompatTextView userName, userPhone;
        AppCompatImageView imageViewSimpleProfile, popupMenu;

        public ViewHolderRight(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.layout_users_right_profile_image);
            userName = itemView.findViewById(R.id.layout_users_right_name);
            userPhone = itemView.findViewById(R.id.layout_users_right_phone);
            imageViewSimpleProfile = itemView.findViewById(R.id.layout_users_right_image_view_simple_profile);
            popupMenu = itemView.findViewById(R.id.layout_users_right_button_menu);
        }
    }
}
