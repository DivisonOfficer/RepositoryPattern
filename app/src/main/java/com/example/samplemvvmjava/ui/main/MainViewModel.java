package com.example.samplemvvmjava.ui.main;

import com.example.samplemvvmjava.global.ResourceProvider;
import com.example.samplemvvmjava.model.MovieData;
import com.example.samplemvvmjava.storage.MovieStorage;
import com.example.samplemvvmjava.ui.base.ActivityConnect;
import com.example.samplemvvmjava.ui.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ActivityRetainedScoped;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;


@ActivityRetainedScoped
public class MainViewModel extends BaseViewModel {

    private final MovieStorage movieStorage;
    private final ActivityConnect connect;

    public final MovieListAdapter adapter = new MovieListAdapter();




    @Inject public MainViewModel(
            ResourceProvider resourceProvider,
            MovieStorage movieStorage,
            ActivityConnect connect
    ) {
        super(resourceProvider);
        this.movieStorage = movieStorage;
        this.connect = connect;

        Disposable movieDisposable = movieStorage
                .movieDataListSubject
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(adapter::setMovieList);
    }


    public void onSearchText(String text){

        movieStorage.getMovieListResult(text);
    }

    public void onBackPressed(){
        connect.finishPage();
    }


}
