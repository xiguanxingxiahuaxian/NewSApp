package com.basego.maw.constructforandroid.presenter;

import com.basego.maw.constructforandroid.api.ExceptionHandle;
import com.basego.maw.constructforandroid.base.BasePresenter;
import com.basego.maw.constructforandroid.base.Subscribe;
import com.basego.maw.constructforandroid.bean.news.NewBeanDTO;
import com.basego.maw.constructforandroid.model.newmodel.NewModel;
import com.basego.maw.constructforandroid.view.activity.impl.SimpleView;

/**
 * 项目名称：Retrofit-mvp-rxjava
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/11/10 16:01
 * 修改备注
 */
public class NewPresenter extends BasePresenter<SimpleView> {
    private NewModel newModel;
    public NewPresenter(){
        newModel=new NewModel();
    }
    public void getTout(String type){
        view.onShow();
        newModel.getTout(type, new Subscribe<NewBeanDTO>() {
            @Override
            public void OnSuccess(NewBeanDTO newBeanDTO) {
                view.onSuccess(newBeanDTO);
            }

            @Override
            public void OnFail(ExceptionHandle.ResponeThrowable e) {
                view.onFail(e);
            }

            @Override
            public void OnCompleted() {
                view.onfinish();
            }
        });
    }
}
