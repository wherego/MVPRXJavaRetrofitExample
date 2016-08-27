package me.mrrobot97.movierec.Retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mrrobot on 16/8/27.
 */
public class ImageClient {
    public static String api="http://image.tmdb.org/t/p/w92/";
    public static Retrofit retrofit=null;

    public static Retrofit getClient(){
        if (retrofit!=null){
            return retrofit;
        }
        retrofit=new Retrofit.Builder().baseUrl(api).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit;
    }
}
