package com.yxj.mvpsample.bean;

import org.json.JSONObject;

/**
 * 模拟网络数据返回类
 * Created by yxj on 17/1/3.
 */

public class ResultBean {

    private int code;
    private String msg;
    private JSONObject json;

    public ResultBean(int code, String msg, JSONObject json) {
        this.code = code;
        this.msg = msg;
        this.json = json;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }
}
