package com.od.core.rest.interceptor;

import com.od.core.util.RestUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Super on 2017/9/12.
 */

public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .addHeader("Content-Type","text/plain")
//                .addHeader("Accept-Encoding", "gzip")
                .addHeader("Connection", "keep-alive")
                .addHeader("Accept", "*/*")
                .addHeader("App-Version", RestUtil.getAppVersionName())
                .addHeader("Phone-Info", RestUtil.getPhoneInfo())
                .build();
        return chain.proceed(request);
    }
}
