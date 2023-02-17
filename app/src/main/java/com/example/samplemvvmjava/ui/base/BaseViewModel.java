package com.example.samplemvvmjava.ui.base;

import androidx.lifecycle.ViewModel;

import com.example.samplemvvmjava.global.ResourceProvider;

public abstract class BaseViewModel extends ViewModel {


    protected ResourceProvider resourceProvider;

    public BaseViewModel(ResourceProvider resourceProvider){
        this.resourceProvider = resourceProvider;
    }
}
