package com.example.movierecipe.response;

import com.example.movierecipe.model.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {

    @SerializedName("results")
    @Expose()
    private List<MovieModel> movies;

    public List<MovieModel> getMovies(){
        return movies;
    }
}
