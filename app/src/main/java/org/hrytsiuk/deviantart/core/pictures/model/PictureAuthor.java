package org.hrytsiuk.deviantart.core.pictures.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public final class PictureAuthor implements Parcelable {
    @SerializedName("username")
    private String name;
    @SerializedName("usericon")
    private String usericon;

    private PictureAuthor(Parcel in) {
        name = in.readString();
        usericon = in.readString();
    }

    public static final Creator<PictureAuthor> CREATOR = new Creator<PictureAuthor>() {
        @Override
        public PictureAuthor createFromParcel(Parcel in) {
            return new PictureAuthor(in);
        }

        @Override
        public PictureAuthor[] newArray(int size) {
            return new PictureAuthor[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getUserIcon() {
        return usericon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(usericon);
    }
}
