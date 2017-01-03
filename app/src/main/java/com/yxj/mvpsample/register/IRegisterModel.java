package com.yxj.mvpsample.register;

import com.yxj.mvpsample.basemvp.IModel;
import com.yxj.mvpsample.bean.ResultBean;

/**
 * Created by yxj on 17/1/3.
 */

public interface IRegisterModel extends IModel{

    interface SendVerifyCallback {
        void succeed(ResultBean result);
        void failed(ResultBean result);
    }

    interface RegisterCallback{
        void succeed(ResultBean result);
        void failed(ResultBean result);
    }

    void sendVerify(SendVerifyCallback callback);

    void register(String phone,String verify,RegisterCallback callback);

    void onDestory();
}
