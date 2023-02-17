package com.example.samplemvvmjava.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.samplemvvmjava.R;
import com.example.samplemvvmjava.databinding.ActivityMainBinding;
import com.example.samplemvvmjava.ui.base.BaseActivity;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity {


    ActivityMainBinding binding;
    @Inject public MainViewModel viewModel;

    @Override
    public void onActivityStart() {
        binding = getBind(R.layout.activity_main);

        binding.setViewmodel(viewModel);



    }
}