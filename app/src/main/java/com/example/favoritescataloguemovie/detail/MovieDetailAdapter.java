package com.example.favoritescataloguemovie.detail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.favoritescataloguemovie.Model.Genre;
import com.example.favoritescataloguemovie.R;

import java.util.List;

public class MovieDetailAdapter extends RecyclerView.Adapter<MovieDetailAdapter.MovieViewHolder> {
    private List<Genre> genreList;


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.genre_list, parent, false);
        return new MovieViewHolder(view);
    }

    public MovieDetailAdapter(List<Genre> genreList) {
        this.genreList = genreList;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.genre.setText(genreList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return genreList.size();
    }


    class MovieViewHolder extends RecyclerView.ViewHolder {
        private TextView genre;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            genre = itemView.findViewById(R.id.genreText);
        }

    }
}
