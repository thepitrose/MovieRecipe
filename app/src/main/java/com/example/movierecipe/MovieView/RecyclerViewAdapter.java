package com.example.movierecipe.MovieView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movierecipe.R;
import com.example.movierecipe.model.MovieModel;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private final OnMoiveListener onMoiveListener;

    Context context ;
    ArrayList<MovieModel> modelArrayList;

    public RecyclerViewAdapter (Context context , ArrayList<MovieModel> modelArrayList ,OnMoiveListener onMoiveListener){

        this.context=context;
        this.modelArrayList=modelArrayList;
        this.onMoiveListener = onMoiveListener;

    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.movie_list_pop,parent,false);

        return new RecyclerViewAdapter.MyViewHolder(view , onMoiveListener);
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerViewAdapter.MyViewHolder holder, int position) {

        holder.title.setText(modelArrayList.get(position).getTitle());
        String popNum = String.valueOf(modelArrayList.get(position).getVote_average());
        holder.release_date.setText(popNum);

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title,release_date;

        public MyViewHolder(@NonNull View itemView , OnMoiveListener onMoiveListener) {
            super(itemView);

            title = itemView.findViewById(R.id.movie_title);
            release_date =  itemView.findViewById(R.id.movie_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onMoiveListener !=null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            onMoiveListener.onMovieClick(pos);
                        }
                    }


                }
            });


        }
    }
}
