package com.yxj.mvpsample.register;

import com.yxj.mvpsample.basemvp.IPresenter;

/**
 * Created by yxj on 17/1/3.
 */

public interface IRegisterPrestener extends IPresenter{

    void sendVerify();

    void register(String phone,String verify);

    void onDestory();
}
