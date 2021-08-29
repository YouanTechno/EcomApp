package com.example.ecomapp.ui.home;

import android.graphics.LinearGradient;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private LinearGradient gradient1;


    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
        //gradient1 = new ViewModelProvider(this).get(LinearGradient.class));
    }

    public LiveData<String> getText() {
        return mText;
    }
}