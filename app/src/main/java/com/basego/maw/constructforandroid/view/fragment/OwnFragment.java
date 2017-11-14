package com.basego.maw.constructforandroid.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.basego.maw.constructforandroid.R;
import com.basego.maw.constructforandroid.api.ExceptionHandle;
import com.basego.maw.constructforandroid.base.MvpFragment;
import com.basego.maw.constructforandroid.presenter.SimplePresenter;
import com.basego.maw.constructforandroid.view.activity.impl.SimpleView;

/**
 * 项目名称：Basego
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/9/6 14:44
 * 修改备注
 */
public class OwnFragment extends MvpFragment<SimplePresenter>implements SimpleView {
    public  static OwnFragment fragment;

    @Override
    public void onShow() {

    }

    @Override
    public void onfinish() {

    }



    @Override
    public void onSuccess(Object object) {

    }

    @Override
    public void onFail(ExceptionHandle.ResponeThrowable t) {

    }

    @Override
    protected SimplePresenter initPresenter() {
        return new SimplePresenter();
    }

    @Override
    public int getLayoutid() {
        return R.layout.book_item_layout;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
    public static Fragment getIntance(int position) {
        if (fragment == null) {
            fragment = new OwnFragment();
            Bundle args = new Bundle();
            args.putInt("position", position);
            fragment.setArguments(args);
        }
        return fragment;
    }
}
