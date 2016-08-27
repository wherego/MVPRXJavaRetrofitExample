package me.mrrobot97.movierec.Model;

import java.util.List;

/**
 * Created by mrrobot on 16/8/27.
 */
public interface IMovie {
    void getTopMovies(MoviesListener listener);


    public interface MoviesListener{
        void onMoviesFinished(List<Movie> movies);
    }


}
