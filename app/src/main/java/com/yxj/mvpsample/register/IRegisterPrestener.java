package com.yxj.mvpsample.register;

/**
 * Created by yxj on 17/1/3.
 */

public interface IRegisterPrestener {

    void sendVerify();

    void register(String phone,String verify);

    void onDestory();
}
