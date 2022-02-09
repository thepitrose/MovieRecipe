package com.example.movierecipe.utils;

import android.util.Log;

import com.example.movierecipe.model.MovieModel;

import java.util.Comparator;

public class SortedArrayList implements Comparator<MovieModel>{


    @Override
    public int compare(MovieModel movieModel, MovieModel other) {

        if(movieModel.getVote_average() < other.getVote_average()){
            return 1;
        }

        if(movieModel.getVote_average() > other.getVote_average()){
            return -1;
        }

        return 0;

    }
}