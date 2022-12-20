package com.example.study.ui.current_status;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class currentStatusViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public currentStatusViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Current Status");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
