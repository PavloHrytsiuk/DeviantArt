package org.hrytsiuk.deviantart.core.pictures.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public final class Picture implements Parcelable {

    @SerializedName("title")
    private String title;
    @SerializedName("content")
    private PictureContent content;
    @SerializedName("author")
    private PictureAuthor author;
    @SerializedName("stats")
    private PictureStats stats;

    public PictureAuthor getAuthor() {
        return author;
    }

    public PictureStats getStats() {
        return stats;
    }

    public String getTitle() {
        return title;
    }

    public PictureContent getContent() {
        return content;
    }


    private Picture(Parcel in) {
        title = in.readString();
        content = in.readParcelable(PictureContent.class.getClassLoader());
        author = in.readParcelable(PictureAuthor.class.getClassLoader());
        stats = in.readParcelable(PictureStats.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeParcelable(content, flags);
        dest.writeParcelable(author, flags);
        dest.writeParcelable(stats, flags);
    }

    @Override
    public int describeContents() {
        return 0;
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


}
