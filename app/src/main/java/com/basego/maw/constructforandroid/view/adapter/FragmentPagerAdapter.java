package com.basego.maw.constructforandroid.view.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.basego.maw.constructforandroid.view.fragment.news.Tout_NewFragment;

import java.util.List;

/**
 * 项目名称：Retrofit-mvp-rxjava
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/11/11 12:17
 * 修改备注
 */
public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
    private List<String> list;

    public FragmentPagerAdapter(FragmentManager fm, List<String> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return Tout_NewFragment.newInstance(list.get(position));
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return transTitle(list.get(position));
    }
    //提供转换
    private String transTitle(String t){
       String title="";
        switch (t){
            case "top":
                title="头条";
                break;
           /* case "shehui":
                title="社会";
                break;
            case "guonei":
                title="国内";
                break;
            case "guoji":
                title="国际";
                break;
            case "yule":
                title="娱乐";
                break;
            case "tiyu":
                title="体育";
                break;
            case "junshi":
                title="军事";
                break;
            case "keji":
                title="科技";
                break;
            case "caijing":
                title="财经";
                break;
            case "shishang":
                title="时尚";
                break;*/
        }
        return  title;
    }
}
