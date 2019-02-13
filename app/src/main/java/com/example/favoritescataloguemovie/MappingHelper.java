package com.example.favoritescataloguemovie;

import android.database.Cursor;

import com.example.favoritescataloguemovie.Model.Genre;
import com.example.favoritescataloguemovie.Model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.provider.BaseColumns._ID;
import static com.example.favoritescataloguemovie.DatabaseContract.FavoriteColumns.GENRES;
import static com.example.favoritescataloguemovie.DatabaseContract.FavoriteColumns.IMAGE_PATH;
import static com.example.favoritescataloguemovie.DatabaseContract.FavoriteColumns.LANGUAGE;
import static com.example.favoritescataloguemovie.DatabaseContract.FavoriteColumns.OVERVIEW;
import static com.example.favoritescataloguemovie.DatabaseContract.FavoriteColumns.POPULARITY;
import static com.example.favoritescataloguemovie.DatabaseContract.FavoriteColumns.RATING;
import static com.example.favoritescataloguemovie.DatabaseContract.FavoriteColumns.RELEASE;
import static com.example.favoritescataloguemovie.DatabaseContract.FavoriteColumns.TITLE;

public class MappingHelper {
    public static ArrayList<Movie> mapCursorToArrayList(Cursor cursor) {
        ArrayList<Movie> movieList = new ArrayList<>();
        while (cursor.moveToNext()) {
            String sb = cursor.getString(cursor.getColumnIndexOrThrow(GENRES));

            List<String> s = Arrays.asList(sb.split("\\s*,\\s*"));
            List<Genre> gList = new ArrayList<>();
            if (s.size() > 0) {
                for (int i = 1; i < s.size(); i++) {
                    gList.add(new Genre(s.get(i)));
                }
            }

            int id = cursor.getInt(cursor.getColumnIndexOrThrow(_ID));
            String title =  cursor.getString(cursor.getColumnIndexOrThrow(TITLE));
            String imagePath = cursor.getString(cursor.getColumnIndexOrThrow(IMAGE_PATH));
            Double rating = Double.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(RATING)));
            Double popularity = Double.valueOf(cursor.getString(cursor.getColumnIndexOrThrow(POPULARITY)));
            String language = cursor.getString(cursor.getColumnIndexOrThrow(LANGUAGE));
            List<Genre> genres = gList;
            String release = cursor.getString(cursor.getColumnIndexOrThrow(RELEASE));
            String overview = cursor.getString(cursor.getColumnIndexOrThrow(OVERVIEW));
            movieList.add(new Movie(id, title, imagePath, rating,popularity,language,genres,release,overview));
        }
        return movieList;
    }
}
