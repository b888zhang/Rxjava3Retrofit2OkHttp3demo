package com.example.zb.rxjava3retrofit2okhttp3demo.utils;

/**
 * Created by zb on 2019/4/23.
 */

import com.example.zb.rxjava3retrofit2okhttp3demo.application.MyApp;
import com.example.zb.rxjava3retrofit2okhttp3demo.network.AllApi;
import com.example.zb.rxjava3retrofit2okhttp3demo.url.ApiAddress;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description: retrofit请求工具类
 */
public class RetrofitUtil {
    /**
     * 超时时间
     */
    private static volatile RetrofitUtil mInstance;
    private                 AllApi       allApi;

    /**
     * 单例封装
     *
     * @return
     */
    public static RetrofitUtil getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitUtil.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitUtil();
                }
            }
        }
        return mInstance;
    }

    /**
     * 初始化Retrofit
     */
    public AllApi initRetrofit() {
        if (allApi == null) {
            Retrofit mRetrofit = new Retrofit.Builder()
                    .client(MyApp.initOKHttp())
                    // 设置请求的域名
                    .baseUrl(ApiAddress.api)
                    // 设置解析转换工厂，用自己定义的
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            allApi = mRetrofit.create(AllApi.class);
        }
        return allApi;
    }

}
