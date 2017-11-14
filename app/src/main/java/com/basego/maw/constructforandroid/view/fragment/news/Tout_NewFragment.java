package com.basego.maw.constructforandroid.view.fragment.news;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.basego.maw.constructforandroid.R;
import com.basego.maw.constructforandroid.api.ExceptionHandle;
import com.basego.maw.constructforandroid.base.MvpActivity;
import com.basego.maw.constructforandroid.base.MvpFragment;
import com.basego.maw.constructforandroid.presenter.NewPresenter;
import com.basego.maw.constructforandroid.view.activity.impl.SimpleView;
import com.superrecycleview.superlibrary.recycleview.SuperRecyclerView;

import butterknife.BindView;

/**
 * 项目名称：Retrofit-mvp-rxjava
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/11/10 16:39
 * 修改备注
 */
public class Tout_NewFragment extends MvpFragment<NewPresenter>implements SimpleView /*,SuperRecyclerView.LoadingListener*/{
  /*  @BindView(R.id.sv)
    SuperRecyclerView superRecyclerView;*/


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

    }

    @Override
    public void onFail(ExceptionHandle.ResponeThrowable t) {

    }

    @Override
    protected NewPresenter initPresenter() {
        return new NewPresenter();
    }

    @Override
    public int getLayoutid() {
        return R.layout.new_layout;
    }

    @Override
    public void initView() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
      /*  superRecyclerView.setLayoutManager(llm);
        superRecyclerView.setRefreshEnabled(true); // 开启下拉刷新
        superRecyclerView.setLoadMoreEnabled(true); //开启下拉刷新   默认开启
        superRecyclerView.setLoadingListener(this);
        superRecyclerView.setArrowImageView(R.mipmap.ic_launcher); //设置下拉刷新的图标*/
    }

    public static Tout_NewFragment newInstance(String text){
        Bundle bundle = new Bundle();
        bundle.putString("text","哈哈");
        Tout_NewFragment blankFragment = new Tout_NewFragment();
        blankFragment.setArguments(bundle);
        return blankFragment;
    }

    @Override
    public void initData() {
      //  presener.getTout("toutiao");
    }

  /*  @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }*/
}
