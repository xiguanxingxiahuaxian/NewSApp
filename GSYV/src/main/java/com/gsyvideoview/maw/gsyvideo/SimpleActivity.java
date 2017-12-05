package com.gsyvideoview.maw.gsyvideo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gsyvideoview.maw.gsyvideo.listener.SampleListener;
import com.gsyvideoview.maw.gsyvideo.video.SampleCoverVideo;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

public class SimpleActivity extends AppCompatActivity {

    private boolean mFull=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        final SampleCoverVideo sampleCoverVideo =findViewById(R.id.video);
       // sampleCoverVideo.loadCoverImage();
        String url =/*"http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";*/
                getIntent().getStringExtra("url");
        sampleCoverVideo.loadCoverImage(url,R.mipmap.ic_launcher);
        GSYVideoOptionBuilder gsyVideoOptionBuilder =new GSYVideoOptionBuilder();
        gsyVideoOptionBuilder
                .setIsTouchWiget(false)
//                .setThumbImageView(imageView)
                .setUrl(url)
 //               .setVideoTitle(title)
                .setCacheWithPlay(true)
                .setRotateViewAuto(true)
                .setLockLand(true)
  //              .setPlayTag(TAG)
                .setShowFullAnimation(true)
                .setNeedLockFull(true)
  //              .setPlayPosition(position)
                .setStandardVideoAllCallBack(new SampleListener() {
                    @Override
                    public void onPrepared(String url, Object... objects) {
                        super.onPrepared(url, objects);
                        if (!sampleCoverVideo.isIfCurrentIsFullscreen()) {
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
                }).build(sampleCoverVideo);
        //设置返回键
        sampleCoverVideo.getBackButton().setVisibility(View.GONE);
        //设置全屏按键功能
        sampleCoverVideo.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resolveFullBtn(sampleCoverVideo);
            }
        });

    }


    /**
     * 全屏幕按键处理
     */
    private void resolveFullBtn(final StandardGSYVideoPlayer standardGSYVideoPlayer) {
        standardGSYVideoPlayer.startWindowFullscreen(this, true, true);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //如果旋转了就全屏
        if (newConfig.orientation != ActivityInfo.SCREEN_ORIENTATION_USER) {
            //mFull = false;
        } else {
           // mFull = true;

        }

    }

    @Override
    public void onBackPressed() {
        if (StandardGSYVideoPlayer.backFromWindowFull(this)) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onResume() {
        super.onResume();
        GSYVideoManager.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        GSYVideoManager.onPause();
    }

    public void qp(View view) {
        Intent intent = new Intent(SimpleActivity.this, RecyclerViewActivity.class);
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        ActivityCompat.startActivity(SimpleActivity.this, intent, activityOptions.toBundle());
    }
}
