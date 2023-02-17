package com.example.samplemvvmjava.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieListResult {

    @SerializedName("movieList")
    public List<MovieData> moveList;


}
