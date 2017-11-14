package com.basego.maw.constructforandroid.model.newmodel;

import com.basego.maw.constructforandroid.api.AppConfig;
import com.basego.maw.constructforandroid.api.RetrofitManager;
import com.basego.maw.constructforandroid.base.Subscribe;
import com.basego.maw.constructforandroid.bean.news.NewBeanDTO;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 项目名称：Retrofit-mvp-rxjava
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/11/10 16:04
 * 修改备注
 */
public class NewModel {
    public void getTout (String type,Subscribe<NewBeanDTO> subscribe){
        Observable<NewBeanDTO> observable= RetrofitManager.getSingleton(1).jh_newApiservice().gettoutiaoNew(type, AppConfig.APPKEY);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscribe);
    }
}
