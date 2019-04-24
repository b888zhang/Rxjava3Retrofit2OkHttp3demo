package com.example.zb.rxjava3retrofit2okhttp3demo.base;

import com.example.zb.rxjava3retrofit2okhttp3demo.utils.MainUtil;

/**
 * Created by zb on 2019/4/23.
 */

public class BaseEntry<T> {

    private String errCode;
    private String errMsg;
    private T result;

    public boolean isSuccess(){
        return getCode().equals(MainUtil.SUCCESS_CODE);
    }

    public String getCode() {
        return errCode;
    }

    public void setCode(String errCode) {
        this.errCode = errCode;
    }

    public String getMessage() {
        return errMsg;
    }

    public void setMessage(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getData() {
        return result;
    }

    public void setData(T result) {
        this.result = result;
    }
}
