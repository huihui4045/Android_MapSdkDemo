package com.huihui.test;

import android.app.Application;

import com.test.wiwj.sdk.WSDKInitializer;


/**
 * Created by gavin on 2017/3/15.
 */

public class MyApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        WSDKInitializer.initialize(this);
    }
}
