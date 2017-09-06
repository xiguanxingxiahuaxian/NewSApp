package com.basego.maw.constructforandroid.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 项目名称：Basego
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/9/6 11:49
 * 修改备注
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutid());
        initBefore(savedInstanceState);
        initView();
        initData();
    }

    public  void initBefore(Bundle savedInstanceState) {

    }

    public abstract int getLayoutid();

    public abstract void initView();

    public abstract void initData();

}
