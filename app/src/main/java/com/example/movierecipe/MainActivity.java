package com.example.movierecipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.movierecipe.MovieView.OnMoiveListener;
import com.example.movierecipe.MovieView.RecyclerViewAdapter;
import com.example.movierecipe.model.MovieModel;
import com.example.movierecipe.response.BuildConnection;
import com.example.movierecipe.utils.SortedArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class MainActivity extends AppCompatActivity implements OnMoiveListener{

    private RecyclerView recyclerView ;
    private Button button;
    private Boolean isSort=false;

    ArrayList<MovieModel> movieModelslist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BuildConnection.buildData();
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        movieModelslist = BuildConnection.getMovieModelslist();

        setDisply();


        button = findViewById(R.id.button_view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!isSort)
                {
                    isSort=true;
                    Collections.sort(movieModelslist,new SortedArrayList());
                    RecyclerViewAdapter adapter = new RecyclerViewAdapter(MainActivity.this,movieModelslist , MainActivity.this::onMovieClick);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                }
                else if(isSort)
                {
                    isSort=false;
                    Collections.reverse(movieModelslist);
                    RecyclerViewAdapter adapter = new RecyclerViewAdapter(MainActivity.this,movieModelslist , MainActivity.this::onMovieClick);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                }

            }
        });


    }

    private void setDisply(){

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                RecyclerViewAdapter adapter = new RecyclerViewAdapter(MainActivity.this,movieModelslist , MainActivity.this::onMovieClick);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        }, 2000);

    }


    @Override
    public void onMovieClick(int position) {
        Intent intent = new Intent(this, MovieDetails.class);
        intent.putExtra("movie",movieModelslist.get(position));
        startActivity(intent);
    }


}