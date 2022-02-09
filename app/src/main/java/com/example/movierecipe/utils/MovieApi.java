package com.example.movierecipe.utils;

import com.example.movierecipe.response.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {


    @GET("/3/movie/popular")
    Call<MovieResponse>  getPopMovies(
            @Query("api_key") String key,
            @Query("page") int page
    );

}
