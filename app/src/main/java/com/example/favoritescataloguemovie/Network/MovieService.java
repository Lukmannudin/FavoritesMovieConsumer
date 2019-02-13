package com.example.favoritescataloguemovie.Network;



import com.example.favoritescataloguemovie.Model.Movie;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {

    @GET("movie/{movieId}")
    Single<Movie> getMovie(
            @Path("movieId") int movieId,
            @Query("api_key") String api_key
    );

}
