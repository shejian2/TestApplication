package com.jrud.testapplication;

import android.widget.Button;
import android.widget.Toast;

import com.jrud.lib.ui.activity.base.BaseActivity;


import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.login)
    Button login;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.login)
    public void login(){
        Toast.makeText(this,"登录",Toast.LENGTH_SHORT).show();
    }
}
