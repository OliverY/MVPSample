package com.yxj.mvpsample.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.yxj.mvpsample.R;
import com.yxj.mvpsample.bean.ResultBean;

import java.util.regex.Pattern;

/**
 * Created by yxj on 17/1/3.
 */

public class RegisterActivity extends AppCompatActivity implements IRegisterView, View.OnClickListener {

    private EditText etPhone;
    private EditText etVerify;
    private Button btnVerify;
    private Button btnRegister;
    private ProgressBar progress;

    private IRegisterPrestener presenter;

    private static final int COUNT_DOWN_SECONDS = 60;
    private int countDownNum = COUNT_DOWN_SECONDS;

    private Handler handler;
    private Runnable runnable;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etPhone = (EditText) findViewById(R.id.etPhone);
        etVerify = (EditText) findViewById(R.id.etVerify);
        btnVerify = (Button) findViewById(R.id.btnVerify);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        progress = (ProgressBar) findViewById(R.id.progress);

        btnVerify.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        // 当etPhone为phone的时候btnVerify才enable，其它时候都是unable的
        etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (isPhoneNum(s)) {
                    btnVerify.setEnabled(true);
                    if (isVerify(etVerify.getText())) {
                        btnRegister.setEnabled(true);
                    } else {
                        btnRegister.setEnabled(false);
                    }
                } else {
                    btnVerify.setEnabled(false);
                    btnRegister.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etVerify.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (isVerify(s)) {
                    btnRegister.setEnabled(true);
                } else {
                    btnRegister.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        presenter = new RegisterPresenterImpl(this);
    }

    @Override
    public void sendVerify() {
        presenter.sendVerify();
    }

    @Override
    public void register(String phone, String verify) {
        presenter.register(phone, verify);
    }

    @Override
    public void getVerifySucceed(String result) {
        etVerify.setText(result);
        etVerify.requestFocus();
    }

    @Override
    public void getVerifyFailed(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerSuccess(ResultBean result) {
        // 回到登录页
        finish();
    }

    @Override
    public void registerFailed(ResultBean result) {
        Toast.makeText(this, result.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnVerify:
                // 倒计时，如果没结束点击无效
                if (countDown()) {
                    sendVerify();
                }
                break;
            case R.id.btnRegister:
                if (TextUtils.isEmpty(etPhone.getText()) || TextUtils.isEmpty(etVerify.getText())) {
                    Toast.makeText(this, R.string.register_input_phone_and_verify, Toast.LENGTH_SHORT).show();
                    return;
                }
                register(etPhone.getText().toString(), etVerify.getText().toString());
                break;
        }
    }

    private boolean isPhoneNum(CharSequence num) {
        if (TextUtils.isEmpty(num)) {
            return false;
        }
        if (Pattern.compile("\\d{13}").matcher(num).matches()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isVerify(CharSequence verify) {
        if (TextUtils.isEmpty(verify)) {
            return false;
        }
        if (Pattern.compile("\\d{3}").matcher(verify).matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 倒计时
     *
     * @return 是否可以进行倒计时
     */
    private boolean countDown() {
        if (countDownNum == COUNT_DOWN_SECONDS) {
            handler = new Handler();
            runnable = new Runnable() {
                @Override
                public void run() {
                    if (countDownNum != 0) {
                        btnVerify.setText(String.format("获取验证码(%d)", countDownNum));
                        countDownNum--;
                        handler.postDelayed(this, 1000);
                    } else {
                        countDownNum = COUNT_DOWN_SECONDS;
                        btnVerify.setText(String.format("重新获取验证码"));
                    }
                }
            };
            handler.post(runnable);
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
