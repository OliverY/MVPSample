package com.yxj.mvpsample.login;

import com.yxj.mvpsample.basemvp.IView;
import com.yxj.mvpsample.bean.ResultBean;

/**
 * 定义登录界面的用户的操作，界面的变化
 * Created by yxj on 17/1/3.
 */
public interface ILoginView extends IView{

    /**
     * 用户点击登录（接受用户操作）
     * @param account
     * @param pwd
     */
    void login(String account,String pwd);

    /**
     * 登录成功对界面的反馈（界面变化）
     * @param result
     */
    void loginSucceed(ResultBean result);

    /**
     * 登录失败对界面的反馈（界面变化）
     * @param result
     */
    void loginFailed(ResultBean result);

    /**
     * 显示dialog（界面变化）
     */
    void showProgress();

    /**
     * 消除dialog（界面变化）
     */
    void dismissProgress();

}
