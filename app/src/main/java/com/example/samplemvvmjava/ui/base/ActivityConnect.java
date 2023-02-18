package com.example.samplemvvmjava.ui.base;


import android.content.Intent;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ActivityConnect {

    private BaseActivity activity;

    @Inject public ActivityConnect(){

    }

    void registerActivity(BaseActivity activity){
        this.activity = activity;
    }


    public void finishPage(){
        activity.finish();
    }

    public <T extends BaseActivity> void startActivity(Class<T> tClass){
        activity.startActivity(tClass);

    }

}
