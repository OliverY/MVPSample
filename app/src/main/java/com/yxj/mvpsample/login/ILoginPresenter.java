package com.yxj.mvpsample.login;

/**
 * Created by yxj on 17/1/3.
 */

public interface ILoginPresenter {

    /*
    Presenter抽象类中应该定义些什么方法？
    UI界面用户的提交操作，或者说用户需要操作数据的方法。即V——>P
    比如登录操作需要提交数据去服务端验证，而loginSuccess,loginFaild属于反馈型的方法。即P——>V
     */

    /**
     * 登录
     * @param account
     * @param pwd
     */
    void login(String account,String pwd);

    /**
     * 这是为了model，presenter中的多线程在界面销毁时销毁，防止内存泄漏
     */
    void onDestory();
}
