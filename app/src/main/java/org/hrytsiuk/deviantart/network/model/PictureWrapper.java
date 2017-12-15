package org.hrytsiuk.deviantart.network.model;


import com.google.gson.annotations.SerializedName;

import org.hrytsiuk.deviantart.core.pictures.model.Picture;

import java.util.List;

public final class PictureWrapper {
    @SerializedName("results")
    private List<Picture> results;

    public List<Picture> getResults() {
        return results;
    }
}
