package com.example.samplemvvmjava.storage;


import android.util.Log;

import com.example.samplemvvmjava.model.MovieData;
import com.example.samplemvvmjava.remote.MovieRepository;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

@Singleton
public class MovieStorage {

    @Inject
    MovieRepository repository;


    public BehaviorSubject<List<MovieData>> movieDataListSubject = BehaviorSubject.create();



    @Inject public MovieStorage(){

    }

    private final CompositeDisposable disposable = new CompositeDisposable();

    public void getMovieListResult(String movieName){

        Disposable disposable =
        repository.fetchMovieList(movieName).subscribe(
            response ->{
                if(response.getMovieListResult().moveList!= null)
                    movieDataListSubject.onNext(response.getMovieListResult().moveList);
                else{
                    Log.e(getClass().getName(),"Null List");
                }
            }, Throwable::printStackTrace
        );

        this.disposable.add(disposable);
    }



}
