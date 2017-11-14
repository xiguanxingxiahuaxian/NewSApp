package com.basego.maw.constructforandroid.api;

import com.basego.maw.constructforandroid.base.BaseApp;
import com.basego.maw.constructforandroid.utils.CatcheInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目名称：Basego
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/8/30 16:23
 * 修改备注
 */
public class RetrofitManager {

  private volatile static RetrofitManager  retrofitManager;
  private Retrofit retrofit;


  public RetrofitManager(int i){
    initRetrofitManager(i);
  }

  /**
   * 根据不同的业务显示不同的基地址
   */
  private void initRetrofitManager(int i) {
     String url="";
      switch (i){
        case 1:
          url=UrlContant.JH_BASEURL;
          break;
      }
    retrofit= new Retrofit.Builder().baseUrl(url).client(defaultHttpClient())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson()))
            .build();

  }
  public static RetrofitManager getSingleton(int i){
    if(retrofitManager==null){
      synchronized (RetrofitManager.class){
        retrofitManager =new RetrofitManager(i);
      }
    }
    return retrofitManager;
  }
  //gson
  private Gson gson(){
    return new GsonBuilder().serializeNulls().enableComplexMapKeySerialization().create();
  }
  //okhttp添加网络拦截以及缓存
  private  OkHttpClient defaultHttpClient(){
    return  new OkHttpClient.Builder().cache(cache()).addNetworkInterceptor(new CatcheInterceptor())
            .build();
  }

  public Cache cache(){
    File file = BaseApp.getInstance().getExternalFilesDir(AppConfig.CATCHE_DIRECTORY);
     return  new Cache(file,AppConfig.CATCHE_SIZE);
  }
  public  SimpleApiservice getSimpleApiservice(){
    return  retrofit.create(SimpleApiservice.class);
  }
  public  Jh_NewApiservice jh_newApiservice(){
    return  retrofit.create(Jh_NewApiservice.class);
  }
}
