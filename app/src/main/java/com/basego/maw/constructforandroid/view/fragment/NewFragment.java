package com.basego.maw.constructforandroid.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.basego.maw.constructforandroid.R;
import com.basego.maw.constructforandroid.base.BaseFragment;
import com.basego.maw.constructforandroid.view.adapter.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;

/**
 * 项目名称：Basego
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/9/6 14:44
 * 修改备注
 */
public class NewFragment extends BaseFragment {

    public static NewFragment fragment;
    private ArrayList<String> list;

    @Override
    public int getLayoutid() {
        return R.layout.new_fragment_layout;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        list.add("top");
        list.add("shehui");
        list.add("guonei");
        list.add("guoji");
        list.add("yule");
        list.add("tiyu");
        list.add("junshi");
        list.add("keji");
        list.add("caijing");
        list.add("shishang");
    }


    @Override
    public void initData() {
        TabLayout mTabLayout = getView().findViewById(R.id.tablayout);
        ViewPager mViewPager = getView().findViewById(R.id.vpager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager(), list));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    public static Fragment getIntance(int position) {
        if (fragment == null) {
            fragment = new NewFragment();
            Bundle args = new Bundle();
            args.putInt("position", position);
            fragment.setArguments(args);
        }
        return fragment;
    }
}
