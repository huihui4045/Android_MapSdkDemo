package com.huihui.sdk;

import android.content.Context;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by gavin on 2017/3/15.
 */

public class WSDKInitializer {

    public static final String SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_OK = "permission check ok";
    public static final String SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR = "permission check error";
    public static final String SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR = "network error";
    public static final String SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE = "error_code";

    private WSDKInitializer() {
    }

    public static void initialize(String var0, Context var1) {


    }

    public static void initialize(Context var0) {

        SDKInitializer.initialize(var0);
    }
}
