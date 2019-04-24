package com.example.zb.rxjava3retrofit2okhttp3demo.application;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by zb on 2019/4/23.
 */

public class MyApp extends Application {

    public static MyApp myApp;
    public static final int TIMEOUT = 60;
    private static OkHttpClient mOkHttpClient;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
    }
    /**
     * 全局httpclient
     *
     * @return
     */
    public static OkHttpClient initOKHttp() {
        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(TIMEOUT, TimeUnit.SECONDS)//设置连接超时时间
                    .readTimeout(TIMEOUT, TimeUnit.SECONDS)//设置读取超时时间
                    .writeTimeout(TIMEOUT, TimeUnit.SECONDS)//设置写入超时时间
//                    .addInterceptor(InterceptorUtil.LogInterceptor())//添加日志拦截器
//                    //cookie
//                    .addInterceptor(new CookieReadInterceptor())
//                    .addInterceptor(new CookiesSaveInterceptor())
                    .build();
        }
        return mOkHttpClient;
    }
}
