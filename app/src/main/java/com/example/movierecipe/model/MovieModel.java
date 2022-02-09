package com.example.movierecipe.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.google.gson.annotations.SerializedName;

public class MovieModel implements Parcelable{

    private String title;
    private double vote_average;
    private String poster_path;
    private String overview;

    public MovieModel(String title, int vote_average, String poster_path , String overview) {
        this.title = title;
        this.vote_average = vote_average;
        this.poster_path = poster_path;
        this.overview = overview;
    }

    //================================================

    public String getTitle() {
        return title;
    }

    public double getVote_average() {
        return vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getOverview() {
        return overview;
    }

    //================================================

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeDouble(vote_average);
        parcel.writeString(poster_path);
        parcel.writeString(overview);
    }

    //================================================

    protected MovieModel(Parcel in) {
        title = in.readString();
        vote_average = in.readDouble();
        poster_path = in.readString();
        overview = in.readString();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };


}
