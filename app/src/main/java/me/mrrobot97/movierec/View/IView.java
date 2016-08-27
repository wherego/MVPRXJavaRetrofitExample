package me.mrrobot97.movierec.View;

import java.util.List;

import me.mrrobot97.movierec.Model.Movie;

/**
 * Created by mrrobot on 16/8/27.
 */
public interface IView {
    void refresh();

    void stopRefresh();

    void refreshData(List<Movie> movies);

}
