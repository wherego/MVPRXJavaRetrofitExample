package me.mrrobot97.movierec.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.mrrobot97.movierec.Model.IMovieImpl;
import me.mrrobot97.movierec.Model.Movie;
import me.mrrobot97.movierec.R;
import me.mrrobot97.movierec.Retrofit.ImageClient;
import me.mrrobot97.movierec.Retrofit.ImageInterface;
import okhttp3.ResponseBody;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by mrrobot on 16/8/27.
 */
public class MovieAdapter extends BaseAdapter {

    private Context mContext;
    private List<Movie> mMovies;
    private LayoutInflater mInflater;

    public MovieAdapter(Context context, List<Movie> movies) {
        mContext = context;
        mMovies = movies;
        mInflater=LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public Object getItem(int i) {
        return mMovies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Movie movie=mMovies.get(i);
        final ViewHolder holder;
        if (view==null){
            view=mInflater.inflate(R.layout.movie_item_layout,null);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        holder.title.setText(movie.getTitle());
        holder.overview.setText(movie.getOverview());
        //loading avatar
        ImageClient.getClient().create(ImageInterface.class)
                .getBitmap(movie.getPosterPath().replace("/",""), IMovieImpl.key)
                .subscribeOn(Schedulers.newThread())
                .map(new Func1<ResponseBody, Bitmap>() {
                    @Override
                    public Bitmap call(ResponseBody responseBody) {
                        Bitmap bg=null;
                        if (responseBody!=null){
                            bg = BitmapFactory.decodeStream(responseBody.byteStream());
                        }
                        return bg;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Bitmap>() {
            @Override
            public void call(Bitmap bitmap) {
                holder.avatar.setImageBitmap(bitmap);
            }
        });
        return view;
    }


    public class ViewHolder{
        public TextView title;
        public TextView overview;
        public ImageView avatar;
        public ViewHolder(View view){
            title= (TextView) view.findViewById(R.id.title_tv);
            overview= (TextView) view.findViewById(R.id.overview_tv);
            avatar= (ImageView) view.findViewById(R.id.avatar_iv);
        }
    }
}
