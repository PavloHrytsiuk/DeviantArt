package org.hrytsiuk.deviantart.core.pictures.domain;

import android.support.annotation.NonNull;

import org.hrytsiuk.deviantart.core.pictures.model.Picture;
import org.hrytsiuk.deviantart.network.model.AccessTokenWrapper;
import org.hrytsiuk.deviantart.network.model.PictureWrapper;
import org.hrytsiuk.deviantart.network.rx.PictureApi;

import java.util.List;

import rx.Observable;

public final class PictureInteractorImpl extends PictureInteractor {

    private final PictureApi api;

    public PictureInteractorImpl() {
        api = getRestApi().createPictureApi();
    }

    @Override
    public Observable<String> fetchAccessToken() {
        return api.fetchAccessToken(getTokenType(), getClientId(), getClientSecret()).map(AccessTokenWrapper::getAccessToken);
    }

    @Override
    public Observable<List<Picture>> fetchPictures(@NonNull String accessToken, int limit) {
        return api.fetchPictures(accessToken,limit).map(PictureWrapper::getResults);
    }
}
