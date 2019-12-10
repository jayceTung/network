package com.od.core;

import com.od.core.rest.NetParams;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Super on 2017/9/12.
 */

public class NetPost {
    private static NetPost sPost;
    private Retrofit mRetrofit;

    public static NetPost getInstance() {
        if (sPost == null) {
            synchronized (NetPost.class) {
                if (sPost == null) {
                    NetParams.getInstance();//must to init NetParams
                    sPost = new NetPost();
                }
            }
        }
        return sPost;
    }

    private NetPost() {
        initRest();
    }

    private void initRest() {
        OkHttpClient.Builder builder = generateDefaultOkHttpBuilder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        if (NetParams.getInstance().isRelease) {
            logging.setLevel(Level.NONE);
        } else {
            logging.setLevel(Level.BODY);
        }

        builder.addInterceptor(logging);
        List<Interceptor> interceptorList = NetParams.getInstance().getInterceptors();
        for (Interceptor interceptor : interceptorList) {
            builder.addInterceptor(interceptor);
        }

        List<Interceptor> networkInterceptorList = NetParams.getInstance().getNetworkInterceptors();
        for (Interceptor interceptor : networkInterceptorList) {
            builder.addNetworkInterceptor(interceptor);
        }

        final OkHttpClient client = builder.build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(NetParams.getInstance().getHttpHost())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .validateEagerly(true)
                .build();
    }

    private OkHttpClient.Builder generateDefaultOkHttpBuilder() {
        return (new OkHttpClient.Builder()).cache(getCache()).writeTimeout(10L, TimeUnit.SECONDS)
                .connectTimeout(10L, TimeUnit.SECONDS)
                .readTimeout(30L, TimeUnit.SECONDS);
    }

    private Cache getCache() {
        //缓存文件夹
        File cacheFile = new File(NetParams.getInstance().mApplicationContext.getExternalCacheDir()
                .toString(), "http/cache");
        //缓存200M
        int cacheSize = 100 * 1024 * 1024;
        //创建缓存对象
        return new Cache(cacheFile, cacheSize);
    }

    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }

}
