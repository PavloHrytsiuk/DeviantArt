package org.hrytsiuk.deviantart.base.mvp;

import android.support.annotation.NonNull;

import org.hrytsiuk.deviantart.network.RestApi;


public abstract class DeviantArtInteractor implements BaseInteractor {

    private final static String TOKEN_TYPE = "client_credentials";
    private final static String CLIENT_SECRET = "8734c1b097f205b3c2679876943ae58b";
    private final static int CLIENT_ID = 7231;


    @NonNull
    @Override
    public RestApi getRestApi() {
        return RestApi.getInstance();
    }

    @Override
    public int getClientId() {
        return CLIENT_ID;
    }

    @NonNull
    @Override
    public String getClientSecret() {
        return CLIENT_SECRET;
    }

    @NonNull
    @Override
    public String getTokenType() {
        return TOKEN_TYPE;
    }
}
