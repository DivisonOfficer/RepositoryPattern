package com.example.samplemvvmjava.remote;


import com.example.samplemvvmjava.model.MovieListResult;
import com.example.samplemvvmjava.model.MovieResponse;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MovieRepository {

    @Inject MovieRemoteSource movieRemoteSource;


    @Inject public MovieRepository(){


    }


    public Single<MovieResponse> fetchMovieList(String movieName){
        return movieRemoteSource.fetchMovieListResult(Module.API_KEY,movieName).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

    }



}
