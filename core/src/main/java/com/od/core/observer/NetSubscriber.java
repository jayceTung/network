package com.od.core.observer;


import android.content.Context;
import android.net.Network;

import com.od.core.R;
import com.od.core.rest.NetParams;
import com.od.core.util.NetworkUtil;

import rx.Subscriber;

/**
 * Created by Super on 2017/9/14.
 */

public abstract class NetSubscriber<T> extends Subscriber<T> {

    @Override
    public void onStart() {
        if (!NetworkUtil.isConnected(NetParams.getInstance().mApplicationContext)) {
            if (!isUnsubscribed()) {
                unsubscribe();
            }
            onFail(NetParams.getInstance().mApplicationContext.getResources()
                    .getString(R.string.error_net_filed));
        }
    }

    @Override
    public void onCompleted() {
        if (!isUnsubscribed()) {
            unsubscribe();
        }
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        onFail(e.getMessage());
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    protected abstract void onSuccess(T t);

    protected abstract void onFail(String message);
}
