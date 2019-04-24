package com.example.zb.rxjava3retrofit2okhttp3demo.utils;

import android.util.Log;

/**
 * Created by zb on 2019/4/23.
 */

public class MainUtil {
    public static String logger = "logger";
    private static boolean isPrintLog = true; //是否打开日志打印

    //日志打印
    public static void printLogger(String logTxt) {
        if (isPrintLog) {
            Log.d(logger, logTxt);
        }
    }

    public static String SUCCESS_CODE = "0";//成功的code
    public static String loadTxt = "正在加载";
    public static String loadLogin = "正在登录";
}
