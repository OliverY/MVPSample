package com.yxj.mvpsample.login;

import android.os.Handler;

import com.yxj.mvpsample.TestData;
import com.yxj.mvpsample.bean.ResultBean;

import org.json.JSONObject;

/**
 * Created by yxj on 17/1/3.
 */

public class LoginModelImpl implements ILoginModel {

    ResultBean resultSuccess = new ResultBean(0,"登录成功",null);
    ResultBean resultFailed = new ResultBean(1,"登录失败",null);

    Handler handler = null;
    Runnable runnable = null;

    @Override
    public void login(final String account, final String pwd, final Callback callback) {
        // 这里用子线程延时来模拟网络
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if(TestData.PHONE_NUM.equals(account) && TestData.VERIFY.equals(pwd)) {
                    callback.onSucceed(resultSuccess);
                }else{
                    callback.onFailed(resultFailed);
                }
            }
        };
        handler.postDelayed(runnable,2000);
    }

    @Override
    public void onDestory() {
        handler.removeCallbacks(runnable);
    }
}
