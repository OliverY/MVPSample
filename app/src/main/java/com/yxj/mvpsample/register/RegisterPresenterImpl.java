package com.yxj.mvpsample.register;

import com.yxj.mvpsample.bean.ResultBean;

import org.json.JSONException;

/**
 * Created by yxj on 17/1/3.
 */

public class RegisterPresenterImpl implements IRegisterPrestener {

    IRegisterView view = null;
    IRegisterModel model = null;

    public RegisterPresenterImpl(IRegisterView view){
        this.view = view;
        this.model = new RegisterModelImpl();
    }


    @Override
    public void sendVerify() {
        view.showProgress();
        model.sendVerify(new IRegisterModel.SendVerifyCallback() {
            @Override
            public void succeed(ResultBean result) {
                view.dismissProgress();
                try {
                    view.getVerifySucceed(result.getJson().getString("verify"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(ResultBean result) {
                view.dismissProgress();
                view.getVerifyFailed(result.getMsg());
            }
        });
    }

    @Override
    public void register(String phone, final String verify) {
        view.showProgress();
        model.register(phone, verify, new IRegisterModel.RegisterCallback() {
            @Override
            public void succeed(ResultBean result) {
                view.dismissProgress();
                view.registerSuccess(result);
            }

            @Override
            public void failed(ResultBean result) {
                view.dismissProgress();
                view.registerFailed(result);
            }
        });
    }
}
