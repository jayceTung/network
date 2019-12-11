package com.od.network;


import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Super on 2017/9/12.
 */

public interface KDService {

    @GET("/query?")
    Observable<KDBean> getCoupons(@Query("type") String userId,
                                  @Query("postid") String postid);

    @POST("api/amoy/auth/login")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @FormUrlEncoded
    Observable<Result<LoginInfo>> LoginByPhone(@Field("mobile") String mobile, @Field("password") String password);
}
