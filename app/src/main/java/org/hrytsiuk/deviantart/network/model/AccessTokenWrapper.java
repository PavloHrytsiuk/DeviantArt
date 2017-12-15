package org.hrytsiuk.deviantart.network.model;


import com.google.gson.annotations.SerializedName;

public final class AccessTokenWrapper {
    @SerializedName("access_token")
    private String accessToken;

    public AccessTokenWrapper() {
    }

    public String getAccessToken() {
        return accessToken;
    }
}
