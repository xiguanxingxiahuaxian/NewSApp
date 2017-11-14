package com.basego.maw.constructforandroid.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import rx.Subscription;

/**
 * 项目名称：ggfw_android_hd_r
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/11/13 10:55
 * 修改备注
 */
public class SubscriptionManager implements SubscriptionHelper<Object>{
    public static SubscriptionManager subscriptionManager;
    Map<Object,Subscription> map;
    public  SubscriptionManager(){
       map=new HashMap<>();
    }
    @Override
    public void add(Object o, Subscription subscription) {
        map.put(o,subscription);
    }

    @Override
    public void cancel(Object o) {

        if(map.isEmpty()){
            return;
        }
        if(map.get(o)==null){
            return;
        }
        if(!map.get(o).isUnsubscribed()) {
            map.get(o).unsubscribe();
            map.remove(o);
        }
    }

    @Override
    public void cancelall() {
        if(map.isEmpty()){
           return;
        }else {
            Set<Object> keys = map.keySet();
            for (Object apiKey : keys) {
                cancel(apiKey);
            }
        }
    }
    public static  SubscriptionManager getInstance(){
        if(subscriptionManager==null) {
            synchronized (SubscriptionManager.class){
                if(subscriptionManager==null) {
                    subscriptionManager = new SubscriptionManager();
                }
            }
        }
        return subscriptionManager;
    }
}
