package com.basego.maw.constructforandroid.view.activity.impl;

import com.basego.maw.constructforandroid.base.BaseView;

import java.util.Observable;

/**
 * 项目名称：Basego
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/9/6 11:53
 * 修改备注
 */
public interface SimpleView extends BaseView {
    void  onSuccess(Object object);
    void  onFail(Throwable t);
}
