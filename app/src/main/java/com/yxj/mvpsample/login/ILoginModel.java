package com.yxj.mvpsample.login;

import com.yxj.mvpsample.bean.ResultBean;

/**
 * Created by yxj on 17/1/3.
 */

public interface ILoginModel {

    /*
     * Model层定义的方法是什么?
     * 所需的数据操作，login是P——>M，回调Callback是M——>P
     */

    interface Callback{
        void onSucceed(ResultBean result);
        void onFailed(ResultBean result);
    }

    void login(String account,String pwd,Callback callback);

    void onDestory();
}
