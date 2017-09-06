package com.basego.maw.constructforandroid.view.fragment;

import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.basego.maw.constructforandroid.R;
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

    private  static  HomeFragment homeFragment;
    private TextView textView;

    @Override
    public void onShow() {

    }

    @Override
    public void onfinish() {

    }

    @Override
    public void onFail() {

    }

    @Override
    public void onSuccess(Object object) {
        if(object instanceof Persion){
            Persion persion =(Persion)object;
            textView.setText("网络请求数据返回："+persion.getName());
        }
    }

    @Override
    public void onFail(Throwable t) {

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
        textView=getActivity().findViewById(R.id.home);
    }

    @Override
    public void initData() {
        presener.getName();
    }
    public static Fragment getIntance(){
        if(homeFragment==null){
            homeFragment=new HomeFragment();
        }
        return homeFragment;
    }
}
