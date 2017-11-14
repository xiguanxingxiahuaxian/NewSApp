package com.basego.maw.constructforandroid.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.TextView;

import com.basego.maw.constructforandroid.R;
import com.basego.maw.constructforandroid.api.ExceptionHandle;
import com.basego.maw.constructforandroid.base.MvpFragment;
import com.basego.maw.constructforandroid.bean.Persion;
import com.basego.maw.constructforandroid.presenter.SimplePresenter;
import com.basego.maw.constructforandroid.view.activity.impl.SimpleView;

/**
 * 项目名称：Basego
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/9/6 12:53
 * 修改备注
 */
public class HomeFragment extends MvpFragment<SimplePresenter>implements SimpleView {

    private static HomeFragment fragment;


    @Override
    public void onShow() {

    }

    @Override
    public void onfinish() {

    }



    @Override
    public void onSuccess(Object object) {
        if(object instanceof Persion){
            Persion persion =(Persion)object;

        }
    }

    @Override
    public void onFail(ExceptionHandle.ResponeThrowable t) {
        Log.i("HomeFragment",t.toString());
    }

    @Override
    protected SimplePresenter initPresenter() {
        return new SimplePresenter();
    }

    @Override
    public int getLayoutid() {
        return R.layout.home_item_layout;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
      //  presener.getName();
    }
    public static Fragment getIntance(int position) {
        if (fragment == null) {
            fragment = new HomeFragment();
            Bundle args = new Bundle();
            args.putInt("position", position);
            fragment.setArguments(args);
        }
        return fragment;
    }
}
