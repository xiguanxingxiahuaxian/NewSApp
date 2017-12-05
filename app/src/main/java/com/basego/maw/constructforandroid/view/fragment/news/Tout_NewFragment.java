package com.basego.maw.constructforandroid.view.fragment.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.animation.Animation;

import com.basego.maw.constructforandroid.R;
import com.basego.maw.constructforandroid.api.ExceptionHandle;
import com.basego.maw.constructforandroid.base.MvpActivity;
import com.basego.maw.constructforandroid.base.MvpFragment;
import com.basego.maw.constructforandroid.bean.news.NewBeanDTO;
import com.basego.maw.constructforandroid.presenter.NewPresenter;
import com.basego.maw.constructforandroid.utils.CustomProgressDialog;
import com.basego.maw.constructforandroid.utils.GetJsonFromAssetUtils;
import com.basego.maw.constructforandroid.view.activity.impl.SimpleView;
import com.basego.maw.constructforandroid.view.adapter.SuperRecycleAdapter;
import com.basego.maw.constructforandroid.view.fragment.ChatFragment;
import com.superrecycleview.superlibrary.recycleview.SuperRecyclerView;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 项目名称：Retrofit-mvp-rxjava
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/11/10 16:39
 * 修改备注
 */

/**
 * 类型,,top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
 */
public class Tout_NewFragment extends MvpFragment<NewPresenter>implements SimpleView ,SuperRecyclerView.LoadingListener{
    private static Tout_NewFragment blankFragment;
    private CustomProgressDialog customProgressDialog;

    SuperRecyclerView superRecyclerView;
    private static String  Request_param;
    private List<NewBeanDTO.ResultBean.DataBean> list;
    private SuperRecycleAdapter superRecycleAdapter;
    private boolean isFirst;

    @Override
    public void onShow() {
        customProgressDialog.show();
    }

    @Override
    public void onfinish() {
        customProgressDialog.dismiss();
        superRecyclerView.completeRefresh();
    }


    @Override
    public void onSuccess(Object object) {
        if(object instanceof  NewBeanDTO){
            NewBeanDTO newBeanDTO=(NewBeanDTO)object;
            list.addAll(newBeanDTO.getResult().getData());
            superRecycleAdapter.notifyDataSetChanged();
        }
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
        isFirst=true;
        list=new ArrayList<>();
        list=GetJsonFromAssetUtils.getStates(getActivity());
        superRecyclerView= getView().findViewById(R.id.sv);
        customProgressDialog =new CustomProgressDialog(getActivity(),"正在加载",R.drawable.frame_news);
        LinearLayoutManager llm = new LinearLayoutManager(this.getActivity());
        superRecyclerView.setLayoutManager(llm);
        superRecyclerView.setRefreshEnabled(false); // 开启下拉刷新
        superRecyclerView.setLoadMoreEnabled(false); //开启下拉刷新   默认开启
        superRecyclerView.setLoadingListener(this);
        superRecyclerView.setArrowImageView(R.mipmap.ic_launcher); //设置下拉刷新的图标*/
        superRecycleAdapter =new SuperRecycleAdapter(getActivity(),list);
        superRecyclerView.setAdapter(superRecycleAdapter);
        isFirst=false;
    }

    public static Tout_NewFragment newInstance(String text){
        Request_param=text;
        blankFragment = new Tout_NewFragment();
        return blankFragment;
    }

    @Override
    public void initData() {
    //    presener.getTout(Request_param);
    }

    @Override
    public void onRefresh() {
        initData();
    }

    @Override
    public void onLoadMore() {

    }


}
