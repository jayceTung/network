package com.od.core.util;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import com.od.core.rest.NetParams;

/**
 * Created by Super on 2017/9/12.
 */

public class RestUtil {

    private RestUtil() {
        throw new UnsupportedOperationException("RestUtil cannot be instantiated");
    }

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
        return NetParams.getInstance().getApplicationContext().getString(res, objects);
    }

    /**
     * 获取版本号
     * @return
     */
    public static String getAppVersionName() {
        String appVersionName = "";
        PackageManager pm = NetParams.getInstance().getApplicationContext().getPackageManager();
        String packageName = NetParams.getInstance().getApplicationContext().getPackageName();
        try {
            PackageInfo packageInfo = pm.getPackageInfo(packageName, 0);
            appVersionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appVersionName;
    }

    public static String getPhoneInfo() {
        return Build.BRAND + "_" + Build.MODEL + "_" + Build.VERSION.RELEASE;
    }
}
