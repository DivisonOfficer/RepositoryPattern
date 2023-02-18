package com.example.samplemvvmjava.ui.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.samplemvvmjava.R;
import com.example.samplemvvmjava.databinding.ViewHolderMovieBinding;
import com.example.samplemvvmjava.model.MovieData;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieViewHolder> {


    private List<MovieData> movieList = new ArrayList<>();


    void setMovieList(List<MovieData> list){
        movieList = list;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.view_holder_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(movieList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}


class MovieViewHolder extends RecyclerView.ViewHolder{

    private ViewHolderMovieBinding binding;

    public MovieViewHolder(@NonNull ViewHolderMovieBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }


    void bind(MovieData movieData){
        binding.setMovieData(movieData);


    }
}
