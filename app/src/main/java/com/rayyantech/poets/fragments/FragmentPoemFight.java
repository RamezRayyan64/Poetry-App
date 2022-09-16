package com.rayyantech.poets.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.rayyantech.poets.databinding.FragemntPoemFightBinding;

public class FragmentPoemFight extends Fragment {

    private FragemntPoemFightBinding fragemntPoemFightBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragemntPoemFightBinding = FragemntPoemFightBinding.inflate(inflater, container, false);
        return fragemntPoemFightBinding.getRoot();
    }
}
