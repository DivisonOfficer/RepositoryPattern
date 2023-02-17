package com.example.samplemvvmjava.remote;

import com.example.samplemvvmjava.model.MovieListResult;
import com.example.samplemvvmjava.model.MovieResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieRemoteSource {


    @GET("webservice/rest/movie/searchMovieList.json")
    Single<MovieResponse> fetchMovieListResult(@Query("key") String key, @Query("movieNm") String movieName);
}
