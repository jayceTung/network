package com.od.network;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Super on 2017/9/12.
 */

public interface KDService {

    @GET("/query?")
    Observable<KDBean> getCoupons(@Query("type") String userId,
                                  @Query("postid") String postid);
}
