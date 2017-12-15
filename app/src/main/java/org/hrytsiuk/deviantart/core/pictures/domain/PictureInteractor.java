package org.hrytsiuk.deviantart.core.pictures.domain;

import android.support.annotation.NonNull;

import org.hrytsiuk.deviantart.base.mvp.DeviantArtInteractor;
import org.hrytsiuk.deviantart.core.pictures.model.Picture;

import java.util.List;

import rx.Observable;

public abstract class PictureInteractor extends DeviantArtInteractor {

    public abstract Observable<String> fetchAccessToken();

    public abstract Observable<List<Picture>> fetchPictures(@NonNull final String accessToken,
                                                            final int limit);
}
