package com.basego.maw.constructforandroid.presenter;

import com.basego.maw.constructforandroid.base.BasePresenter;
import com.basego.maw.constructforandroid.base.Subscribe;
import com.basego.maw.constructforandroid.bean.Persion;
import com.basego.maw.constructforandroid.model.SimpleModel;
import com.basego.maw.constructforandroid.view.activity.impl.SimpleView;

/**
 * 项目名称：Basego
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/9/6 11:58
 * 修改备注
 */
public class SimplePresenter extends BasePresenter<SimpleView> {

    private final SimpleModel simpleModel;

    public SimplePresenter() {
       simpleModel=new SimpleModel();
    }
    /**
    * 项目名称：${PROJECT_NAME}
    * 类描述： 完成mvp与rxjava的结合
    * 创建人：maw@neuqsoft.com
    * 创建时间： ${DATE} ${TIME}
    * @version
    */
    public void getName(){
     //   view.onShow();
        simpleModel.getName(new Subscribe<Persion>() {
            @Override
            public void OnSuccess(Persion persion) {
                view.onSuccess(persion);
            }

            @Override
            public void OnFail(Throwable e) {
                view.onFail(e);
            }

            @Override
            public void OnCompleted() {
                view.onfinish();
            }
        });
    }
}
