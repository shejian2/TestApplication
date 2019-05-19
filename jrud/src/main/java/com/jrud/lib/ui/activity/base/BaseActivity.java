package com.jrud.lib.ui.activity.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jrud.lib.base.BaseAppManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    protected Handler baseHandler = new Handler();

    Unbinder unbinder;

    protected boolean mIsDestroy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseAppManager.getInstance().addActivity(this);
        setContentView(getLayoutId());
        initWidget();
        initData();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        unbinder=ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        mIsDestroy = true;
        super.onDestroy();
        unbinder.unbind();
        BaseAppManager.getInstance().removeActivity(this);
    }

    protected abstract int getLayoutId();

    protected  void initWidget(){}

    protected void initData(){}
}
