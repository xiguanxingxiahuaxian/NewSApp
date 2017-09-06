package com.basego.maw.constructforandroid.base;

/**
 * 项目名称：Basego
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/9/6 11:47
 * 修改备注
 */
public class BasePresenter<V extends BaseView> {

    public V view;

    public void addView(V v){
        this.view=v;
    }
    public void detattch(){
        if(view!=null){
            view=null;
        }
    }
}
