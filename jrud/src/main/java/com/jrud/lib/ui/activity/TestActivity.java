package com.jrud.lib.ui.activity;

import android.widget.Button;
import android.widget.Toast;

import com.jrud.lib.R;
import com.jrud.lib.R2;
import com.jrud.lib.ui.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class TestActivity extends BaseActivity {

    @BindView(R2.id.test)
    Button test;

    @OnClick(R2.id.test)
    public void test(){
        Toast.makeText(this,"测试123",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }
}
