package com.yxj.mvpsample.bean;

import org.json.JSONObject;

/**
 * Created by yxj on 17/1/3.
 */

public class ResultBean {

    int code;
    String msg;
    JSONObject json;

    public ResultBean(int code, String msg, JSONObject json) {
        this.code = code;
        this.msg = msg;
        this.json = json;
    }

}
