package com.basego.maw.constructforandroid.utils;

import com.basego.maw.constructforandroid.base.BaseApp;
import com.basego.maw.constructforandroid.net.NetWorkUtil;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 项目名称：Basego
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/8/31 11:01
 * 修改备注
 */
public class CatcheInterceptor implements Interceptor {
    private int maxCacheTime = 60;

    public CatcheInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if(NetWorkUtil.isNetworkAvailable(BaseApp.getInstance())){
            request.newBuilder().
                    cacheControl(CacheControl.FORCE_NETWORK)
                    .build();
            Response response = chain.proceed(request);
            response.newBuilder().removeHeader("Pragma")
                    .header("Cache-Control", "public,max-age=" + maxCacheTime)
                    .build();

            return response;
        }else{
            request.newBuilder().
                    cacheControl(CacheControl.FORCE_CACHE)
                    .build();
            Response response = chain.proceed(request);
            return response.newBuilder().removeHeader("Pragma")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxCacheTime)
                    .build();
        }
    }
}
