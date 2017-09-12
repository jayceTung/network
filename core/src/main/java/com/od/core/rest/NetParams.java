package com.od.core.rest;

import android.content.Context;

import com.od.core.Util.RestUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.Interceptor;

/**
 * Created by Super on 2017/9/12.
 */

public class NetParams {
    private static NetParams sNetParams;
    private final String httpHost;
    public final boolean isRelease;
    private final Map<String, String> mExtraHeaders;
    private final List<Interceptor> networkInterceptors;
    private final List<Interceptor> interceptors;
    public final Context mApplicationContext;
    
    private NetParams(Context context,
                      String httpHost,
                      Boolean isRelease,
                      Map<String, String> extraHeaders,
                      List<Interceptor> networkInterceptors,
                      List<Interceptor> interceptors) {
        this.mApplicationContext = context;
        this.httpHost = httpHost;
        this.isRelease = isRelease;
        this.mExtraHeaders = extraHeaders;
        this.networkInterceptors = networkInterceptors;
        this.interceptors = interceptors;
    }

    public static final class Builder {
        private Context context;
        private Map<String, String> extraHeader;
        private List<Interceptor> networkInterceptors;
        private List<Interceptor> interceptors;
        private String httpHost;
        private boolean isRelease = false;

        public Builder(Context context) {
            this.context = context.getApplicationContext();
        }

        public NetParams.Builder extraHeader(Map<String, String> extraHeader) {
            this.extraHeader = extraHeader;
            return this;
        }

        public NetParams.Builder networkInterceptors(List<Interceptor> networkInterceptors) {
            this.networkInterceptors = networkInterceptors;
            return this;
        }

        public NetParams.Builder interceptors(List<Interceptor> interceptors) {
            this.interceptors = interceptors;
            return this;
        }

        public NetParams.Builder httpHost(String httpHost) {
            this.httpHost = httpHost;
            return this;
        }

        public NetParams.Builder isRelease(Boolean isRelease) {
            this.isRelease = isRelease;
            return this;
        }

        public NetParams build() {
            RestUtil.checkNotNull(this.context, "context");
            RestUtil.checkNotNull(this.httpHost, "httpHost");

            if (this.interceptors == null) {
                this.interceptors = new ArrayList();
            }

            if (this.networkInterceptors == null) {
                this.networkInterceptors = new ArrayList();
            }

            return new NetParams(this.context, this.httpHost, this.isRelease, this.extraHeader, this.interceptors, this.interceptors);
        }
    }

    public static void initInstance(NetParams params) {
        if (params == null) {
            throw new RuntimeException("NetParams is null !!!");
        }
        sNetParams = params;
    }

    public static NetParams getInstance() {
        if (sNetParams == null) {
            throw new RuntimeException("sNetParam is null !!!");
        }
        return sNetParams;
    }

    public String getHttpHost() {
        return httpHost;
    }

    public Map<String, String> getmExtraHeaders() {
        return mExtraHeaders;
    }

    public List<Interceptor> getNetworkInterceptors() {
        return networkInterceptors;
    }

    public List<Interceptor> getInterceptors() {
        return interceptors;
    }
}
