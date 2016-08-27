package me.mrrobot97.movierec.Retrofit;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by mrrobot on 16/8/27.
 */
public interface ImageInterface {
    @GET("{path}")
    Observable<ResponseBody> getBitmap(@Path("path")String imgPath, @Query("api_key")String key);
}
