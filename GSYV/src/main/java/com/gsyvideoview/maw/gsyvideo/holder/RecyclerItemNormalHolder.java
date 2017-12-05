package com.gsyvideoview.maw.gsyvideo.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gsyvideoview.maw.gsyvideo.R;
import com.gsyvideoview.maw.gsyvideo.bean.VideoModel;
import com.gsyvideoview.maw.gsyvideo.listener.SampleListener;
import com.gsyvideoview.maw.gsyvideo.video.SampleCoverVideo;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guoshuyu on 2017/1/9.
 */

public class RecyclerItemNormalHolder extends RecyclerItemBaseHolder {
    /**
     *   update add maw
     *   更改 StandardGSYVideoPlayer ->SampleConverVideo
     *   去掉本掉封面  同时增加第一帧
     */
    public final static String TAG = "RecyclerView2List";

    protected Context context = null;


  private SampleCoverVideo gsyVideoPlayer;

    ImageView imageView;

    GSYVideoOptionBuilder gsyVideoOptionBuilder;

    public RecyclerItemNormalHolder(Context context, View v) {
        super(v);
        this.context = context;
        gsyVideoPlayer =v.findViewById(R.id.video);
     //   imageView = new ImageView(context);
        gsyVideoOptionBuilder = new GSYVideoOptionBuilder();
    }

    public void onBind(final int position, VideoModel videoModel) {

        //增加封面
     //   imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        /*
     /   if (position % 2 == 0) {
            imageView.setImageResource(R.mipmap.xxx1);
        } else {
            imageView.setImageResource(R.mipmap.xxx2);
        }*/
        String url;
        String title;
        if (position % 2 == 0) {
            url = "http://baobab.wdjcdn.com/14564977406580.mp4";
            title = "这是title";
        } else {
            url = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";
            title = "哦？Title？";
        }
        gsyVideoPlayer.loadCoverImage(url,R.mipmap.ic_launcher);
       /* if (imageView.getParent() != null) {
            ViewGroup viewGroup = (ViewGroup) imageView.getParent();
            viewGroup.removeView(imageView);
        }
*/
        gsyVideoOptionBuilder
                .setIsTouchWiget(false)
       //         .setThumbImageView(imageView)
                .setUrl(url)
                .setVideoTitle(title)
                .setCacheWithPlay(true)
                .setRotateViewAuto(true)
                .setLockLand(true)
                .setPlayTag(TAG)
                .setShowFullAnimation(true)
                .setNeedLockFull(true)
                .setPlayPosition(position)
                .setStandardVideoAllCallBack(new SampleListener() {
                    @Override
                    public void onPrepared(String url, Object... objects) {
                        super.onPrepared(url, objects);
                        if (!gsyVideoPlayer.isIfCurrentIsFullscreen()) {
                            //静音
                            GSYVideoManager.instance().setNeedMute(true);
                        }

                    }

                    @Override
                    public void onQuitFullscreen(String url, Object... objects) {
                        super.onQuitFullscreen(url, objects);
                        //全屏不静音
                        GSYVideoManager.instance().setNeedMute(true);
                    }

                    @Override
                    public void onEnterFullscreen(String url, Object... objects) {
                        super.onEnterFullscreen(url, objects);
                        GSYVideoManager.instance().setNeedMute(false);
                    }
                }).build(gsyVideoPlayer);


        //增加title
        gsyVideoPlayer.getTitleTextView().setVisibility(View.GONE);

        //设置返回键
        gsyVideoPlayer.getBackButton().setVisibility(View.GONE);

        //设置全屏按键功能
        gsyVideoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resolveFullBtn(gsyVideoPlayer);
            }
        });
    }

    /**
     * 全屏幕按键处理
     */
    private void resolveFullBtn(final StandardGSYVideoPlayer standardGSYVideoPlayer) {
        standardGSYVideoPlayer.startWindowFullscreen(context, true, true);
    }

}