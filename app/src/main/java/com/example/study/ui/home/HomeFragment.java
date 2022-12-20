package com.example.study.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.study.R;
import com.example.study.databinding.FragmentHomeBinding;

// imports
import android.widget.Button;
import android.content.Intent;



public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.homeScreen;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }



    /*
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }*/
}