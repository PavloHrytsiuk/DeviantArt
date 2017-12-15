package org.hrytsiuk.deviantart.base.mvp;

import android.support.annotation.NonNull;

import org.hrytsiuk.deviantart.network.RestApi;

public interface BaseInteractor {
    @NonNull
    RestApi getRestApi();

    int getClientId();

    @NonNull
    String getClientSecret();

    @NonNull
    String getTokenType();

}
