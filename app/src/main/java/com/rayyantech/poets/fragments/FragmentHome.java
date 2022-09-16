package com.rayyantech.poets.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.rayyantech.poets.R;
import com.rayyantech.poets.activities.NewPostActivity;
import com.rayyantech.poets.adapters.FragmentHomeItemAdapter;
import com.rayyantech.poets.databinding.FragmentHomeBinding;
import com.rayyantech.poets.models.FragmentHomeItemModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment {

    private FragmentHomeBinding fragmentHomeBinding;
    private final List<FragmentHomeItemModel> fragmentHomeItemModelList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false);
        fragmentHomeBinding.fragmentHomeRecyclerViewPosts.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false));
        fragmentHomeBinding.fragmentHomeRecyclerViewPosts.setHasFixedSize(true);
        FragmentHomeItemAdapter fragmentHomeItemAdapter = new FragmentHomeItemAdapter(fragmentHomeItemModelList, getContext());
        fragmentHomeBinding.fragmentHomeRecyclerViewPosts.setAdapter(fragmentHomeItemAdapter);
        fragmentHomeItemModelList.clear();
        // add posts below
        fragmentHomeItemModelList.add(new FragmentHomeItemModel(R.drawable.simple_profile_image + "", "",
                getResources().getString(R.string.text_name_example), getResources().getString(R.string.text_time_example),
                getResources().getString(R.string.text_example), getString(R.string.text_example_phone)));
        fragmentHomeItemModelList.add(new FragmentHomeItemModel("",
                R.drawable.background_shrlock_holmes_4 + "",
                getString(R.string.text_name_example), getString(R.string.text_time_example),
                "تقلید از رسم و رواج و شکل ظاهری کفار یا به اصطلاح عام تحت تاثیر قرار گرفتن فرهنگ کفار است.",
                getString(R.string.text_example_phone)));


        if (fragmentHomeItemModelList.size() != 0) {
            fragmentHomeBinding.fragmentHomeLayoutEmpty.setVisibility(View.GONE);
        }
        fragmentHomeItemAdapter.notifyDataSetChanged();
        fragmentHomeBinding.fragmentHomeButtonNewPost.setOnClickListener(v ->
                startActivity(new Intent(getContext(), NewPostActivity.class)));
        return fragmentHomeBinding.getRoot();
    }
}
