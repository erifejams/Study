package com.example.study.ui.current_status;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.study.databinding.FragmentCurrentStatusBinding;
import com.example.study.databinding.FragmentHomeBinding;
import com.example.study.ui.home.HomeViewModel;

public class currentStatusFragment extends Fragment {

    private FragmentCurrentStatusBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        currentStatusViewModel currentStatusViewModel =
                new ViewModelProvider(this).get(currentStatusViewModel.class);

        binding = FragmentCurrentStatusBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.currentStatusTitle;
        currentStatusViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
