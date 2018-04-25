package com.od.core.util;

import com.od.core.rest.NetParams;

/**
 * Created by Super on 2017/9/12.
 */

public class RestUtil {
    public static void checkNotNull(Object object, String error) {
        if (object == null) {
            throw new IllegalArgumentException(error + "can not be null!");
        }
    }

    public static void checkNotNull(Object object) {
        if (object == null) {
            throw new IllegalStateException(object.getClass().getName() + "can not be null");
        }
    }

    /**
     * 填充字符串
     * @param res
     * @param objects
     * @return
     */
    public static String getString(int res, Object... objects) {
        return NetParams.getInstance().mApplicationContext.getString(res, objects);
    }
}
