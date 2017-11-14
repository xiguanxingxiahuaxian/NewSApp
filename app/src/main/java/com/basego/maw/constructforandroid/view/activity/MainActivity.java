package com.basego.maw.constructforandroid.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.basego.maw.constructforandroid.R;
import com.basego.maw.constructforandroid.base.BaseActivity;
import com.basego.maw.constructforandroid.view.fragment.ChatFragment;
import com.basego.maw.constructforandroid.view.fragment.NewFragment;
import com.basego.maw.constructforandroid.view.fragment.OwnFragment;
import com.basego.maw.constructforandroid.view.fragment.HomeFragment;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    private ArrayList<Fragment> fragments;
    @BindView(R.id.root)
    ViewPager root;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;

    @Override
    public int getLayoutid() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC
                );
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.home, "首页").setActiveColorResource(R.color.green_4d))
                .addItem(new BottomNavigationItem(R.mipmap.new_gray, "头条").setActiveColorResource(R.color.green_4d))
                .addItem(new BottomNavigationItem(R.mipmap.chat, "聊天").setActiveColorResource(R.color.green_4d))
                .addItem(new BottomNavigationItem(R.mipmap.me_h, "我的").setActiveColorResource(R.color.green_4d))

                .setFirstSelectedPosition(0)
                .initialise();


        bottomNavigationBar.setTabSelectedListener(this);
        final FragmentManager fm = getSupportFragmentManager();
        root.setAdapter(new FragmentPagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = HomeFragment.getIntance(position);
                        break;
                    case 1:
                        fragment = NewFragment.getIntance(position);
                        break;
                    case 2:
                        fragment = ChatFragment.getIntance(position);
                        break;
                    case 3:
                        fragment = OwnFragment.getIntance(position);
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 4;
            }
        });
        root.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationBar.selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public void onTabSelected(int position) {
        root.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                ft.remove(fragment);
                ft.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabReselected(int position) {

    }


    @Override
    public void initData() {

    }
}
