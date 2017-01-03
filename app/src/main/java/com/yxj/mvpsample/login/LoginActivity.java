package com.yxj.mvpsample.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.yxj.mvpsample.R;
import com.yxj.mvpsample.bean.ResultBean;
import com.yxj.mvpsample.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    private EditText etPwd;
    private EditText etAccount;
    private Button btnLogin;
    private ProgressBar progress;
    private TextView tvRegister;

    private ILoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etAccount = (EditText) findViewById(R.id.etAccount);
        etPwd = (EditText) findViewById(R.id.etPwd);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        progress = (ProgressBar) findViewById(R.id.progress);
        tvRegister = (TextView) findViewById(R.id.tvRegister);

        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);

        // 如何去操作P层，实现V——>P的操作？持有Presenter的引用
        mLoginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public void login(String account, String pwd) {
        mLoginPresenter.login(account,pwd);
    }

    @Override
    public void loginSucceed(ResultBean result) {
        Toast.makeText(this,result.getMsg(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed(ResultBean result) {
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
            case R.id.btnLogin:
                if(!TextUtils.isEmpty(etAccount.getText()) && !TextUtils.isEmpty(etPwd.getText())){
                    login(etAccount.getText().toString(),etPwd.getText().toString());
                }else{
                    Toast.makeText(this,R.string.login_login_text_error,Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tvRegister:
                startActivity(RegisterActivity.newIntent(LoginActivity.this));
                break;
        }

    }
}
