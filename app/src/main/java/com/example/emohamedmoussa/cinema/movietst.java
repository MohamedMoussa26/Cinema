//package com.example.emohamedmoussa.cinema;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//public class movietst implements Parcelable {
//
//
//
//    private String movietitle, moviedetail;
//    private int movieimg;
//
//    public movietst(String movietitle, String moviedetail, int movieimg) {
//        this.movietitle = movietitle;
//        this.moviedetail = moviedetail;
//        this.movieimg = movieimg;
//    }
//
//    public movietst() {
//
//    }
//
//
//    protected movietst(Parcel in) {
//        movietitle = in.readString();
//        moviedetail = in.readString();
//        movieimg = in.readInt();
//    }
//
//    public static final Creator<movietst> CREATOR = new Creator<movietst>() {
//        @Override
//        public movietst createFromParcel(Parcel in) {
//            return new movietst(in);
//        }
//
//        @Override
//        public movietst[] newArray(int size) {
//            return new movietst[size];
//        }
//    };
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(movietitle);
//        dest.writeString(moviedetail);
//        dest.writeInt(movieimg);
//    }
//}
