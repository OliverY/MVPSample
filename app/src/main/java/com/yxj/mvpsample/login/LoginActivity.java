package com.yxj.mvpsample.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.yxj.mvpsample.R;
import com.yxj.mvpsample.bean.ResultBean;

public class LoginActivity extends AppCompatActivity implements ILoginView{

    private EditText etPwd;
    private EditText etAccount;
    private Button btnLogin;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAccount = (EditText) findViewById(R.id.etAccount);
        etPwd = (EditText) findViewById(R.id.etPwd);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        progress = (ProgressBar) findViewById(R.id.progress);


    }

    @Override
    public void login(String account, String pwd) {

    }

    @Override
    public void loginSucceed(ResultBean result) {

    }

    @Override
    public void loginFailed(ResultBean result) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }
}
