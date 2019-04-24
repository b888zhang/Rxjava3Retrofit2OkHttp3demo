package com.example.zb.rxjava3retrofit2okhttp3demo.presenter;

import android.content.Context;
import android.util.Log;

import com.example.zb.rxjava3retrofit2okhttp3demo.base.BaseEntry;
import com.example.zb.rxjava3retrofit2okhttp3demo.base.BaseObserver;
import com.example.zb.rxjava3retrofit2okhttp3demo.bean.Login;
import com.example.zb.rxjava3retrofit2okhttp3demo.module.MainContract;
import com.example.zb.rxjava3retrofit2okhttp3demo.utils.MainUtil;
import com.example.zb.rxjava3retrofit2okhttp3demo.utils.MyLog;
import com.example.zb.rxjava3retrofit2okhttp3demo.utils.RetrofitUtil;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zb on 2019/4/23.
 */

public class MainPresenter implements MainContract.presenter {

    private Context           context;
  //  private MainContract.View view;

    public MainPresenter(Context context) {
        this.context = context;
       // this.view = view;
    }
    /**
     * 登录
     * @param user
     * @param pwd
     * @param
     */
    @Override
    public void userLogin(String user, String pwd) {
        Map<String,String> map=new HashMap<>();
        map.put("code",user);
        map.put("password",pwd);
        //  map.put("verifyCode",code);
        RetrofitUtil.getInstance().initRetrofit().userLogin(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Login>(context, MainUtil.loadLogin) {
                    @Override
                    protected void onSuccees(BaseEntry<Login> t) throws Exception {
                        boolean success = t.isSuccess();
                        Log.i("success",success+"");
                        if(t.isSuccess()){
                           // view.setContent("Hello---->"+t.getData().Name);
                            MyLog.i("成功-------",t.getData().Name);
                        }else {
                          // view.setContent("----->"+t.getMessage());
                            MyLog.i("----->",t.getMessage());
                        }

                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                       // view.setContent("失败了----->"+e.getMessage());
                        MyLog.i("失败了-------",e.getMessage());
                    }
                });
    }
}
