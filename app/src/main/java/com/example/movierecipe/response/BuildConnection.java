package com.example.movierecipe.response;

import android.util.Log;

import com.example.movierecipe.model.MovieModel;
import com.example.movierecipe.request.RetrofitRequest;
import com.example.movierecipe.utils.Credentials;
import com.example.movierecipe.utils.MovieApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuildConnection {

    public static ArrayList<MovieModel> movieModelslist;

    public static void buildData()
    {
        movieModelslist = new ArrayList<>();
        MovieApi movieApi = RetrofitRequest.getMovieApi();

        Call<MovieResponse> responseCall = movieApi.getPopMovies(
                Credentials.API_KEY,
                1
        );

        responseCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                if (response.code() == 200)
                {
                    List<MovieModel> movies = new ArrayList<>(response.body().getMovies());

                    for (MovieModel movie :movies)
                    {
                        movieModelslist.add(movie);
                    }
                }
                else {
                    try {
                        Log.v("Tag" , "Error " + response.errorBody().string());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
    }

    public static ArrayList<MovieModel> getMovieModelslist() {
        return movieModelslist;
    }
}
