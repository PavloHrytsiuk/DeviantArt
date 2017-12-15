package org.hrytsiuk.deviantart.network.rx;


import org.hrytsiuk.deviantart.network.model.AccessTokenWrapper;
import org.hrytsiuk.deviantart.network.model.PictureWrapper;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface PictureApi {

    @GET("api/v1/oauth2/browse/hot")
    Observable<PictureWrapper> fetchPictures(@Query("access_token") final String token,
                                             @Query("limit") final int limit);

    @GET("oauth2/token")
    Observable<AccessTokenWrapper> fetchAccessToken(@Query("grant_type") final String type,
                                                    @Query("client_id") final int id,
                                                    @Query("client_secret") final String secret);
}
