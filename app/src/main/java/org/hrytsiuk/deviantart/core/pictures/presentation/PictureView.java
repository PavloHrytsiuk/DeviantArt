package org.hrytsiuk.deviantart.core.pictures.presentation;

import android.support.annotation.NonNull;

import org.hrytsiuk.deviantart.base.mvp.BaseView;
import org.hrytsiuk.deviantart.core.pictures.model.Picture;

import java.util.List;

public interface PictureView extends BaseView {

    void saveAccessToken(@NonNull final String accessToken);

    void loadPictures(@NonNull final List<Picture> pictures);
}
