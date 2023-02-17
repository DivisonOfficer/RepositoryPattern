package com.example.samplemvvmjava.ui.main;

import com.example.samplemvvmjava.global.ResourceProvider;
import com.example.samplemvvmjava.storage.MovieStorage;
import com.example.samplemvvmjava.ui.base.BaseViewModel;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ActivityRetainedScoped;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;


@ActivityRetainedScoped
public class MainViewModel extends BaseViewModel {

    private final MovieStorage movieStorage;


    public final MovieListAdapter adapter = new MovieListAdapter();




    @Inject public MainViewModel(
            ResourceProvider resourceProvider,
            MovieStorage movieStorage
    ) {
        super(resourceProvider);
        this.movieStorage = movieStorage;


        Disposable movieDisposable = movieStorage
                .movieDataListSubject
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(adapter::setMovieList);


    }


    public void onSearchText(String text){

        movieStorage.getMovieListResult(text);
    }


}
