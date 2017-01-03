package com.yxj.mvpsample.login;

import com.yxj.mvpsample.bean.ResultBean;

/**
 * Created by yxj on 17/1/3.
 */

public class LoginPresenterImpl implements ILoginPresenter {

    /*
    P层的实现应该是处理业务主要部分
    简单来说就是P——>V,P——>M的处理，Model层不依赖于P层，P层需要持有V，M层的引用
     */

    // 这里注意都是接口
    public ILoginView mLoginView;
    public ILoginModel mLoginModel;

    public LoginPresenterImpl(ILoginView loginView){
        mLoginView = loginView;
        mLoginModel = new LoginModelImpl();
    }

    @Override
    public void login(String account, String pwd) {
        mLoginView.showProgress();
        mLoginModel.login(account, pwd, new ILoginModel.Callback() {
            @Override
            public void onSucceed(ResultBean result) {
                mLoginView.dismissProgress();
                mLoginView.loginSucceed(result);
            }

            @Override
            public void onFailed(ResultBean result) {
                mLoginView.dismissProgress();
                mLoginView.loginFailed(result);
            }
        });
    }
}
