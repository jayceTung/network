package com.od.network;

import android.app.Application;

import com.od.core.rest.NetParams;
import com.od.core.rest.interceptor.HeaderInterceptor;

import java.util.ArrayList;

import okhttp3.Interceptor;

/**
 * Created by Super on 2017/9/12.
 */

public class APP extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        ArrayList<Interceptor> list = new ArrayList<>();
        list.add(new HeaderInterceptor());

        NetParams.initInstance(new NetParams.Builder(getApplicationContext())
                .httpHost(Constants.KEY_POST_URL)
                .interceptors(list)
                .isRelease(false)
                .build());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
