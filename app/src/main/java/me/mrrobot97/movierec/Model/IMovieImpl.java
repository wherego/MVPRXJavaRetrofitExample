package me.mrrobot97.movierec.Model;

import android.util.Log;

import me.mrrobot97.movierec.Retrofit.ApiClient;
import me.mrrobot97.movierec.Retrofit.ApiInterface;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by mrrobot on 16/8/27.
 */
public class IMovieImpl implements IMovie {
    public static String key="8b6db09569a3b71023cc4dcae2ade7fe";

    @Override
    public void getTopMovies(final MoviesListener listener) {
        ApiInterface observable= ApiClient.getClient().create(ApiInterface.class);
        observable.getTopMovies(key).subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MovieResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d("yjw","completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("yjw","error");
                    }

                    @Override
                    public void onNext(MovieResponse movieResponse) {
                        Log.d("yjw","next");
                        listener.onMoviesFinished(movieResponse.getMovies());
                    }
                });
    }
}
