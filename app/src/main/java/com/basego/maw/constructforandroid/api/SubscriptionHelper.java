package com.basego.maw.constructforandroid.api;

import rx.Subscription;

/**
 * 项目名称：ggfw_android_hd_r
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/11/13 10:53
 * 修改备注
 */
public interface SubscriptionHelper<T> {
     void add(T t, Subscription subscription);

    void cancel(T t);

    void cancelall();
}
