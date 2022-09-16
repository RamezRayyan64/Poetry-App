package com.rayyantech.poets.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.rayyantech.poets.R;
import com.rayyantech.poets.adapters.FragmentLikesPoemItemAdapter;
import com.rayyantech.poets.databinding.FragmentLikesPeomsBinding;
import com.rayyantech.poets.models.UsersInfoModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentLikesPoems extends Fragment {

    private FragmentLikesPeomsBinding fragmentLikesPeomsBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentLikesPeomsBinding = FragmentLikesPeomsBinding.inflate(inflater, container, false);
        List<UsersInfoModel> usersInfoModelList = new ArrayList<>();
        // add likesPoems information below
        usersInfoModelList.add(new UsersInfoModel(R.drawable.simple_profile_image + "", getString(R.string.text_name_example),
                getString(R.string.text_example_phone)));
        usersInfoModelList.add(new UsersInfoModel(R.drawable.simple_profile_image + "", getString(R.string.text_name_example),
                getString(R.string.text_example_phone)));

        if (usersInfoModelList.size() != 0) {
            fragmentLikesPeomsBinding.fragmentLikesPoemsLayoutEmpty.setVisibility(View.GONE);
        }
        FragmentLikesPoemItemAdapter fragmentLikesPoemItemAdapter = new FragmentLikesPoemItemAdapter(usersInfoModelList, getContext());
        fragmentLikesPeomsBinding.fragmentLikesPoemsRecyclerViewLikesPoem.setHasFixedSize(true);
        fragmentLikesPeomsBinding.fragmentLikesPoemsRecyclerViewLikesPoem.setLayoutManager(new GridLayoutManager(getContext(), 2));
        fragmentLikesPeomsBinding.fragmentLikesPoemsRecyclerViewLikesPoem.setAdapter(fragmentLikesPoemItemAdapter);
        return fragmentLikesPeomsBinding.getRoot();
    }
}