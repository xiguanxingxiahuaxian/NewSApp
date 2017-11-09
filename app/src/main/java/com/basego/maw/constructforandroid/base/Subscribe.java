package com.basego.maw.constructforandroid.base;

import com.basego.maw.constructforandroid.api.ExceptionHandle;

import rx.Subscriber;

/**
 * 项目名称：Basego
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/9/6 11:21
 * 修改备注
 */
public abstract class Subscribe<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {
        OnCompleted();
    }

    @Override
    public void onError(Throwable e) {
        OnFail(ExceptionHandle.handleException(e));
        onCompleted();
    }

    @Override
    public void onNext(T t) {
        OnSuccess(t);
    }
    public abstract void OnSuccess(T t);

    public abstract void OnFail(ExceptionHandle.ResponeThrowable e);

    public abstract void  OnCompleted();
}
