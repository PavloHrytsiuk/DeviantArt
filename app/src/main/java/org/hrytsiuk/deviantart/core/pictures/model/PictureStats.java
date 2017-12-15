package org.hrytsiuk.deviantart.core.pictures.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public final class PictureStats implements Parcelable {
    @SerializedName("comments")
    private int comments;
    @SerializedName("favourites")
    private int favourites;

    private PictureStats(Parcel in) {
        comments = in.readInt();
        favourites = in.readInt();
    }

    public static final Creator<PictureStats> CREATOR = new Creator<PictureStats>() {
        @Override
        public PictureStats createFromParcel(Parcel in) {
            return new PictureStats(in);
        }

        @Override
        public PictureStats[] newArray(int size) {
            return new PictureStats[size];
        }
    };

    public int getComments() {
        return comments;
    }

    public int getFavourites() {
        return favourites;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(comments);
        parcel.writeInt(favourites);
    }
}
