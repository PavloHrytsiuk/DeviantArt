package org.hrytsiuk.deviantart.core.pictures.presentation;

import android.support.annotation.NonNull;

import org.hrytsiuk.deviantart.base.mvp.BasePresenter;

public interface PicturePresenter extends BasePresenter<PictureView> {

    void fetchPictures(@NonNull final String accessToken, final int limit);

    void fetchAccessToken();

    //void saveAccessToken();
}
