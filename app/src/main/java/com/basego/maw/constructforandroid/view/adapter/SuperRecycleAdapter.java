package com.basego.maw.constructforandroid.view.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.basego.maw.constructforandroid.R;
import com.basego.maw.constructforandroid.bean.news.NewBeanDTO;
import com.basego.maw.constructforandroid.utils.ImageLoader;
import com.superrecycleview.superlibrary.adapter.BaseViewHolder;
import com.superrecycleview.superlibrary.adapter.SuperBaseAdapter;

import java.util.List;

/**
 * 项目名称：Retrofit-mvp-rxjava
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/11/14 14:13
 * 修改备注
 */
public class SuperRecycleAdapter extends SuperBaseAdapter<NewBeanDTO.ResultBean.DataBean> {
    private Context context;

    public SuperRecycleAdapter(Context context, List<NewBeanDTO.ResultBean.DataBean> data) {
        super(context, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder holder, NewBeanDTO.ResultBean.DataBean item, int position) {
        holder.setText(R.id.title,item.getTitle()==null?"":item.getTitle());
        holder.setText(R.id.time,item.getDate()==null?"":item.getDate());
        holder.setText(R.id.address,item.getAuthor_name()==null?"":item.getAuthor_name());
        ImageLoader.getSingleton().displayImage(item.getThumbnail_pic_s(),context, (ImageView) holder.getView(R.id.image));
    }

    @Override
    protected int getItemViewLayoutId(int position, NewBeanDTO.ResultBean.DataBean item) {
        //两种布局设计
        if(item.getThumbnail_pic_s02()!=null){
            return R.layout.news_item_fragmnet;
        }else {
         //   return R.layout.news_item_fragmnet_other;
            return R.layout.news_item_fragmnet;
        }
    }
}
