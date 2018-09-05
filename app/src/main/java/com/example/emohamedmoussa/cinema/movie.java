package com.example.emohamedmoussa.cinema;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mohamed_mousa on 22/10/2016.
 */

public class movie implements Parcelable {


    public String adult;
    public String overvirew;
    public String releasedate;
    public String title;
    public String lang;
    public String votecount;
    public String rate;
    public String poster;
    public String background;
    public int movie_id;
    public Bitmap imgposter;
    public Bitmap imgbackdrop;


    movie(String poster, String background, String adult, String overvirew, String releasedate, String title, String lang, String votecount, String rate, int movie_id) {


        this.adult = "adult: " + adult;
        this.background = background;
        this.lang = " " + lang;
        this.overvirew = overvirew;
        this.poster = poster;
        this.rate = "Rate: " + rate;
        this.releasedate = releasedate;
        this.title = title;
        this.votecount = "Vote: " + votecount;
        this.movie_id = movie_id;


    }

    protected movie(Parcel in) {
        adult = in.readString();
        overvirew = in.readString();
        releasedate = in.readString();
        title = in.readString();
        lang = in.readString();
        votecount = in.readString();
        rate = in.readString();
        poster = in.readString();
        background = in.readString();
        movie_id = in.readInt();
        imgposter = in.readParcelable(Bitmap.class.getClassLoader());
        imgbackdrop = in.readParcelable(Bitmap.class.getClassLoader());
    }

    public static final Creator<movie> CREATOR = new Creator<movie>() {
        @Override
        public movie createFromParcel(Parcel in) {
            return new movie(in);
        }

        @Override
        public movie[] newArray(int size) {
            return new movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(adult);
        dest.writeString(overvirew);
        dest.writeString(releasedate);
        dest.writeString(title);
        dest.writeString(lang);
        dest.writeString(votecount);
        dest.writeString(rate);
        dest.writeString(poster);
        dest.writeString(background);
        dest.writeInt(movie_id);
        dest.writeParcelable(imgposter, flags);
        dest.writeParcelable(imgbackdrop, flags);
    }

}
