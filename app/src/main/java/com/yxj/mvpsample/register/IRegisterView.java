package com.yxj.mvpsample.register;

import com.yxj.mvpsample.basemvp.IView;
import com.yxj.mvpsample.bean.ResultBean;

/**
 * Created by yxj on 17/1/3.
 */

public interface IRegisterView extends IView{

    void sendVerify();

    void register(String phone,String verify);

    void getVerifySucceed(String result);

    void getVerifyFailed(String result);

    void registerSuccess(ResultBean result);

    void registerFailed(ResultBean result);

    void showProgress();

    void dismissProgress();
}
