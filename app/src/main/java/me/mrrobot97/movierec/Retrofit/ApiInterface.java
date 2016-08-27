package me.mrrobot97.movierec.Retrofit;

import me.mrrobot97.movierec.Model.MovieResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mrrobot on 16/8/27.
 */
public interface ApiInterface {
    @GET("movie/top_rated")
    rx.Observable<MovieResponse> getTopMovies(@Query("api_key") String key);

}
