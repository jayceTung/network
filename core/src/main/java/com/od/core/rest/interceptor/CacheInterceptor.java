package com.od.core.rest.interceptor;

import com.od.core.Util.NetworkUtil;
import com.od.core.rest.NetParams;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Super on 2017/9/12.
 */

public class CacheInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);

        if (NetworkUtil.isConnected(NetParams.getInstance().mApplicationContext)) {
            String cacheControl = request.cacheControl().toString();
            return response.newBuilder()
                    .removeHeader("Cache-Control")//清楚响应体对Cache有影响的信息
                    .removeHeader("Pragma")
                    .header("Cache-Control", cacheControl)  //由接口人自由控制缓存时间
                    .build();
        } else {
            return response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=60*24*60")
                    .removeHeader("Pragma")
                    .build();
        }
    }
}
