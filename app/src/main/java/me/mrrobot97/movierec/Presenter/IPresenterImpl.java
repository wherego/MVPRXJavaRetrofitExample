package me.mrrobot97.movierec.Presenter;

import java.util.List;

import me.mrrobot97.movierec.Model.IMovie;
import me.mrrobot97.movierec.Model.IMovieImpl;
import me.mrrobot97.movierec.Model.Movie;
import me.mrrobot97.movierec.View.IView;

/**
 * Created by mrrobot on 16/8/27.
 */
public class IPresenterImpl implements IPresenter {
    private IView mView;
    private IMovie mMovie;

    public IPresenterImpl(IView view){
        mView=view;
        mMovie=new IMovieImpl();
    }

    @Override
    public void refresh() {
        mMovie.getTopMovies(new IMovie.MoviesListener() {
            @Override
            public void onMoviesFinished(List<Movie> movies) {
                mView.stopRefresh();
                mView.refreshData(movies);
            }
        });
    }
}
