package com.basego.maw.constructforandroid.api;

import com.basego.maw.constructforandroid.bean.news.NewBeanDTO;



import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * 项目名称：Retrofit-mvp-rxjava
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/11/10 15:34
 * 修改备注
 */
public interface Jh_NewApiservice {
    @GET("toutiao/index")
    Observable<NewBeanDTO> gettoutiaoNew(@Query("type")String type,@Query("key") String key);
}
