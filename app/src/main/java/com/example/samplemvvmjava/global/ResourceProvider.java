package com.example.samplemvvmjava.global;


import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.hilt.android.qualifiers.ApplicationContext;

@Singleton
public class ResourceProvider {



    private final Context context;

    @Inject
    public ResourceProvider(@ApplicationContext Context context){
        this.context = context;
    }



    public String getString(int resourceId){
        return context.getString(resourceId);
    }



}
