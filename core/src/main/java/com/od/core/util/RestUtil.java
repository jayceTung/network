package com.od.core.util;

/**
 * Created by Super on 2017/9/12.
 */

public class RestUtil {
    public static void checkNotNull(Object object, String error) {
        if (object == null) {
            throw new IllegalArgumentException(error + "can not be null!");
        }
    }
}
