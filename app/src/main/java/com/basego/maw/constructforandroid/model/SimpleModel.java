package com.basego.maw.constructforandroid.model;

import com.basego.maw.constructforandroid.api.AppConfig;
import com.basego.maw.constructforandroid.api.RetrofitManager;
import com.basego.maw.constructforandroid.api.SubscriptionManager;
import com.basego.maw.constructforandroid.base.Subscribe;
import com.basego.maw.constructforandroid.bean.Persion;
import com.basego.maw.constructforandroid.bean.news.NewBeanDTO;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * 项目名称：Basego
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/9/6 11:26
 * 修改备注
 */
public class SimpleModel {
    /**
    * 项目名称：${PROJECT_NAME}
    * 类描述： 完成 Rxjava的声明
    * 创建人：maw@neuqsoft.com
    * 创建时间： ${DATE} ${TIME}
    * @version
    */
    public void getName (Subscribe<Persion>subscribe){
        Observable<Persion> observable=RetrofitManager.getSingleton(0).getSimpleApiservice().getName();

       Subscription subscription= observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscribe);

        SubscriptionManager.getInstance().add("getName",subscription);
    }


}
