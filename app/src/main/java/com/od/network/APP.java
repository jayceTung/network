package com.od.network;

import android.app.Application;

import com.od.core.Rest;
import com.od.core.rest.NetParams;

/**
 * Created by Super on 2017/9/12.
 */

public class APP extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        NetParams.initInstance(new NetParams.Builder(getApplicationContext())
                .httpHost("http://www.kuaidi100.com")
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
