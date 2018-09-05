package com.example.emohamedmoussa.cinema;

import android.os.Parcel;
import android.os.Parcelable;

public class cinPlace implements Parcelable {

    public cinPlace(String icon, String id, String name, String lat, String lng, String place_id, String compound_code, String global_code, String rating, String refrence, String vicinity) {
        this.icon = icon;
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.place_id = place_id;
        this.compound_code = compound_code;
        this.global_code = global_code;
        this.rating = rating;
        this.refrence = refrence;
        this.vicinity = vicinity;
    }
 public cinPlace(String icon, String id, String name, String lat, String lng, String place_id,  String rating, String refrence, String vicinity) {
        this.icon = icon;
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.place_id = place_id;
        this.compound_code = compound_code;
        this.global_code = global_code;
        this.rating = rating;
        this.refrence = refrence;
        this.vicinity = vicinity;
    }

    String icon,id,name,lat,lng,place_id,compound_code,global_code,rating,refrence,vicinity;

    protected cinPlace(Parcel in) {
        icon = in.readString();
        id = in.readString();
        name = in.readString();
        lat = in.readString();
        lng = in.readString();
        place_id = in.readString();
        compound_code = in.readString();
        global_code = in.readString();
        rating = in.readString();
        refrence = in.readString();
        vicinity = in.readString();
    }

    public static final Creator<cinPlace> CREATOR = new Creator<cinPlace>() {
        @Override
        public cinPlace createFromParcel(Parcel in) {
            return new cinPlace(in);
        }

        @Override
        public cinPlace[] newArray(int size) {
            return new cinPlace[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(icon);
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(lat);
        dest.writeString(lng);
        dest.writeString(place_id);
        dest.writeString(compound_code);
        dest.writeString(global_code);
        dest.writeString(rating);
        dest.writeString(refrence);
        dest.writeString(vicinity);
    }
}
