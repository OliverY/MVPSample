package com.yxj.mvpsample.register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.yxj.mvpsample.R;
import com.yxj.mvpsample.bean.ResultBean;

/**
 * Created by yxj on 17/1/3.
 */

public class RegisterActivity extends AppCompatActivity implements IRegisterView,View.OnClickListener{

    private EditText etPhone;
    private EditText etVerify;
    private Button btnVerify;
    private Button btnRegister;
    private ProgressBar progress;

    private IRegisterPrestener presenter;

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context,RegisterActivity.class);
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

        presenter = new RegisterPresenterImpl(this);
    }

    @Override
    public void sendVerify() {
        presenter.sendVerify();
    }

    @Override
    public void register(String phone, String verify) {
        presenter.register(phone,verify);
    }

    @Override
    public void getVerifySucceed(String result) {
        etVerify.setText(result);
    }

    @Override
    public void getVerifyFailed(String result) {
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerSuccess(ResultBean result) {
        // 回到登录页
        finish();
    }

    @Override
    public void registerFailed(ResultBean result) {
        Toast.makeText(this,result.getMsg(),Toast.LENGTH_SHORT).show();
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
        switch (v.getId()){
            case R.id.btnVerify:
                sendVerify();
                break;
            case R.id.btnRegister:
                if(TextUtils.isEmpty(etPhone.getText()) || TextUtils.isEmpty(etVerify.getText())){
                    Toast.makeText(this,R.string.register_input_phone_and_verify,Toast.LENGTH_SHORT).show();
                    return;
                }
                register(etPhone.getText().toString(),etVerify.getText().toString());
                break;
        }
    }
}
