package com.example.samplemvvmjava.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public abstract class BaseActivity extends AppCompatActivity {


    public <T extends  ViewDataBinding> T getBind(int layoutId){
        T bind = DataBindingUtil.setContentView(this, layoutId);
        bind.setLifecycleOwner(this);
        return bind;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onActivityStart();
    }



    public <T extends BaseViewModel> T injectViewModel(Class<T> tClass){
        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        return new ViewModelProvider((ViewModelStoreOwner) this, (ViewModelProvider.Factory) factory).get(tClass);
    }


    /**
     * 액티비티 시작에서 호출되는 함수
     */
    public abstract void onActivityStart();

}
