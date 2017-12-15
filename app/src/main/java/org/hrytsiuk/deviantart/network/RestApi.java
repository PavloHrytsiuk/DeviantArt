package org.hrytsiuk.deviantart.network;

import android.support.annotation.NonNull;

import org.hrytsiuk.deviantart.network.rx.PictureApi;

/**
 * RestApi for retrieving data from the network.
 */
public final class RestApi {

    private static final class RestApiHolder {
        private static final RestApi INSTANCE = new RestApi();
    }

    private RestApi() {}

    @NonNull
    public static RestApi getInstance() {
        return RestApiHolder.INSTANCE;
    }

    @NonNull
    public PictureApi createPictureApi() {
        return RetrofitManager.retrofit.create(PictureApi.class);
    }
}
