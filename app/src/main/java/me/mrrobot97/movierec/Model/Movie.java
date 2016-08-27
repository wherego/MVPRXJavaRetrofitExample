package me.mrrobot97.movierec.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mrrobot on 16/8/27.
 */
public class Movie {
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("id")
    private int id;
    @SerializedName("overview")
    private String overview;
    @SerializedName("popularity")
    private float popularity;
    @SerializedName("poster_path")
    private String  posterPath;
    @SerializedName("release_date")
    private String releaseDate;


    public Movie(boolean adult, int id, String overview,
                 float popularity, String posterPath,
                 String releaseDate, String title,
                 float averageVote, int voteCount) {
        this.adult = adult;
        this.id = id;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.title = title;
        this.averageVote = averageVote;
        this.voteCount = voteCount;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public float getAverageVote() {
        return averageVote;
    }

    public void setAverageVote(float averageVote) {
        this.averageVote = averageVote;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    @SerializedName("title")
    private String title;
    @SerializedName("vote_averge")
    private float averageVote;
    @SerializedName("vote_count")
    private int voteCount;

}
