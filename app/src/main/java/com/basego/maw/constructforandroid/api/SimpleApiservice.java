package com.basego.maw.constructforandroid.api;

import com.basego.maw.constructforandroid.bean.Persion;

import retrofit2.http.GET;
import rx.Observable;

/**
 * 项目名称：Basego
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/9/6 11:27
 * 修改备注
 */
public interface SimpleApiservice {
   /**
   * 项目名称：${PROJECT_NAME}
   * 类描述：  网络请求入口
   * 创建人：maw@neuqsoft.com
   * 创建时间： ${DATE} ${TIME}
   * @version
   */
    @GET("/code")
    Observable<Persion>getName();
}
