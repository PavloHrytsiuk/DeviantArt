package org.hrytsiuk.deviantart.core.pictures.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public final class Picture implements Parcelable {

    @SerializedName("title")
    private String title;
    @SerializedName("content")
    private PictureContent content;

    protected Picture(Parcel in) {
        title = in.readString();
        content = in.readParcelable(PictureContent.class.getClassLoader());
    }

    public static final Creator<Picture> CREATOR = new Creator<Picture>() {
        @Override
        public Picture createFromParcel(Parcel in) {
            return new Picture(in);
        }

        @Override
        public Picture[] newArray(int size) {
            return new Picture[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public PictureContent getContent() {
        return content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeParcelable(content, i);
    }
}
