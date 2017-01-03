package com.yxj.mvpsample.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.yxj.mvpsample.R;

public class LoginActivity extends AppCompatActivity {

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
}
