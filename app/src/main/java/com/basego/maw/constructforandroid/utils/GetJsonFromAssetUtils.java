package com.basego.maw.constructforandroid.utils;

import android.content.Context;
import android.util.Log;

import com.basego.maw.constructforandroid.bean.news.NewBeanDTO;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 项目名称：Retrofit-mvp-rxjava
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/11/15 9:22
 * 修改备注
 */
public class GetJsonFromAssetUtils {

    public GetJsonFromAssetUtils() {

    }
    public static List<NewBeanDTO.ResultBean.DataBean> getStates(Context context) {
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try {
            is = context.getClass().getClassLoader().getResourceAsStream("assets/new_text_top.json");
            bos = new ByteArrayOutputStream();
            byte[] bytes = new byte[4 * 1024];
            int len = 0;
            while ((len = is.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            final String json = new String(bos.toByteArray());
            Gson gson =new Gson();
            final NewBeanDTO areas =gson.fromJson(json,NewBeanDTO.class);
            final List<NewBeanDTO.ResultBean.DataBean> states = areas.getResult().getData();

            return states;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                Log.e("src/main/asset", "getStates", e);
            }
        }
        return null;
    }
}
