package com.example.rayyantech.poetry_app_ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.rayyantech.poetry_app_ui.R;
import com.example.rayyantech.poetry_app_ui.adapters.FragmentPoemsItemAdapter;
import com.example.rayyantech.poetry_app_ui.databinding.FragmentPeomsBinding;
import com.example.rayyantech.poetry_app_ui.models.UsersInfoModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentPoems extends Fragment {

    private FragmentPeomsBinding fragmentPeomsBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentPeomsBinding = FragmentPeomsBinding.inflate(inflater, container, false);
        List<UsersInfoModel> usersInfoModelList = new ArrayList<>();
        // add poems information below
        usersInfoModelList.add(new UsersInfoModel(R.drawable.simple_profile_image + "", getString(R.string.text_name_example),
                getString(R.string.text_example_phone)));
        usersInfoModelList.add(new UsersInfoModel(R.drawable.simple_profile_image + "", getString(R.string.text_name_example),
                getString(R.string.text_example_phone)));

        if (usersInfoModelList.size() != 0) {
            fragmentPeomsBinding.fragmentPoemsLayoutEmpty.setVisibility(View.GONE);
        }
        FragmentPoemsItemAdapter fragmentPoemsItemAdapter = new FragmentPoemsItemAdapter(usersInfoModelList, getContext());
        fragmentPeomsBinding.fragmentPoemsRecyclerViewPoems.setHasFixedSize(true);
        fragmentPeomsBinding.fragmentPoemsRecyclerViewPoems.setLayoutManager(new GridLayoutManager(getContext(), 2));
        fragmentPeomsBinding.fragmentPoemsRecyclerViewPoems.setAdapter(fragmentPoemsItemAdapter);
        return fragmentPeomsBinding.getRoot();
    }
}
