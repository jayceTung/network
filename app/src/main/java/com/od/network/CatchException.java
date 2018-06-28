package com.od.network;

import android.util.Log;

/**
 * @author super
 * @date 2018/4/27
 */
public class CatchException implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "CatchException";

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Log.i(TAG, e.getMessage());
    }
}
