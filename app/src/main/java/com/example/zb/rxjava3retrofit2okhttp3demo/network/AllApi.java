package com.example.zb.rxjava3retrofit2okhttp3demo.network;

import com.example.zb.rxjava3retrofit2okhttp3demo.base.BaseEntry;
import com.example.zb.rxjava3retrofit2okhttp3demo.bean.Login;
import com.example.zb.rxjava3retrofit2okhttp3demo.url.ApiAddress;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by zb on 2019/4/23.
 */

public interface AllApi {
    /**
     * 登录
     */
    @POST(ApiAddress.userLogin)
    Observable<BaseEntry<Login>> userLogin(@Body Map<String,String> maps);

}
