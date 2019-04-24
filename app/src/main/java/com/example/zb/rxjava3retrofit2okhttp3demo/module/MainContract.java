package com.example.zb.rxjava3retrofit2okhttp3demo.module;

import android.graphics.Bitmap;

import com.example.zb.rxjava3retrofit2okhttp3demo.base.BasePresenter;

/**
 * Created by zb on 2019/4/23.
 */

public interface MainContract {


    interface presenter extends BasePresenter {

        void userLogin(String user,String pwd); //登录

    }

}
