package com.yxj.mvpsample.register;

import android.os.Handler;
import android.util.Log;

import com.yxj.mvpsample.TestData;
import com.yxj.mvpsample.bean.ResultBean;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by yxj on 17/1/3.
 */

public class RegisterModelImpl implements IRegisterModel {

    private JSONObject sendVerifySucceedJson = null;
    private ResultBean sendVerifySucceed;
    private ResultBean registerSucceed;
    private ResultBean registerFailed;

    public RegisterModelImpl() {
        try {
            sendVerifySucceedJson = new JSONObject("{'verify':"+ TestData.VERIFY+"}");
            sendVerifySucceed = new ResultBean(0, "发送成功", sendVerifySucceedJson);
            registerSucceed = new ResultBean(0, "注册成功", null);
            registerFailed = new ResultBean(0, "注册失败", null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendVerify(final SendVerifyCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (true) {
                    callback.succeed(sendVerifySucceed);
                } else {

                }
            }
        }, 2000);
    }

    @Override
    public void register(final String phone, final String verify, final RegisterCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TestData.PHONE_NUM.equals(phone) && TestData.VERIFY.equals(verify)) {
                    callback.succeed(registerSucceed);
                    Log.i("yxj",Thread.currentThread().getName());
                } else {
                    callback.failed(registerFailed);
                }
            }
        }, 2000);
    }

}
