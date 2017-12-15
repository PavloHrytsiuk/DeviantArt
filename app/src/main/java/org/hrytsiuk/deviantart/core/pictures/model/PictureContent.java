package org.hrytsiuk.deviantart.core.pictures.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class PictureContent implements Parcelable {
    @SerializedName("src")
    private String src;
    @SerializedName("height")
    private int height;
    @SerializedName("width")
    private int width;

    protected PictureContent(Parcel in) {
        src = in.readString();
        height = in.readInt();
        width = in.readInt();
    }

    public static final Creator<PictureContent> CREATOR = new Creator<PictureContent>() {
        @Override
        public PictureContent createFromParcel(Parcel in) {
            return new PictureContent(in);
        }

        @Override
        public PictureContent[] newArray(int size) {
            return new PictureContent[size];
        }
    };

    public String getSrc() {
        return src;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(src);
        parcel.writeInt(height);
        parcel.writeInt(width);
    }
}
