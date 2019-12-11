package com.od.core.util;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import com.od.core.rest.NetParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

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

    public static RequestBody getBody(Map<String, Object> map) {
        MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
        JSONObject jsonObject = new JSONObject();
        try {
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> entry = it.next();
                jsonObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String str = jsonObject.toString();

        return RequestBody.create(mediaType, str);
    }
}
