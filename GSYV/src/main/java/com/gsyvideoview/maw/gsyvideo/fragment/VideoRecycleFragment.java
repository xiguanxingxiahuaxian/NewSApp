package com.gsyvideoview.maw.gsyvideo.fragment;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.gsyvideoview.maw.gsyvideo.R;
import com.gsyvideoview.maw.gsyvideo.adapter.RecyclerBaseAdapter;
import com.gsyvideoview.maw.gsyvideo.adapter.RecyclerNormalAdapter;
import com.gsyvideoview.maw.gsyvideo.bean.VideoModel;
import com.gsyvideoview.maw.gsyvideo.holder.RecyclerItemNormalHolder;
import com.gsyvideoview.maw.gsyvideo.utils.ScrollCalculatorHelper;
import com.gsyvideoview.maw.gsyvideo.video.SampleCoverVideo;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * 项目名称：Retrofit-mvp-rxjava
 * 类描述：
 * 创建人：maw@neuqsoft.com
 * 创建时间： 2017/12/5 16:42
 * 修改备注
 */
public class VideoRecycleFragment extends Fragment {

    private static VideoRecycleFragment fragment;
    private RecyclerView videoList;

    LinearLayoutManager linearLayoutManager;

    RecyclerBaseAdapter recyclerBaseAdapter;

    List<VideoModel> dataList = new ArrayList<>();

    boolean mFull = false;

    ScrollCalculatorHelper scrollCalculatorHelper;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_recycler_view, container, false);

        videoList=view.findViewById(R.id.list_item_recycler);
        resolveData();

        final RecyclerNormalAdapter recyclerNormalAdapter = new RecyclerNormalAdapter(getActivity(), dataList);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        videoList.setLayoutManager(linearLayoutManager);
        videoList.setAdapter(recyclerNormalAdapter);

        videoList.addOnScrollListener(new RecyclerView.OnScrollListener() {

            int firstVisibleItem, lastVisibleItem;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                //大于0说明有播放
                if (GSYVideoManager.instance().getPlayPosition() >= 0) {
                    //当前播放的位置
                    int position = GSYVideoManager.instance().getPlayPosition();
                    //对应的播放列表TAG
                    if (GSYVideoManager.instance().getPlayTag().equals(RecyclerItemNormalHolder.TAG)
                            && (position < firstVisibleItem || position > lastVisibleItem)) {
                        //如果滑出去了上面和下面就是否，和今日头条一样
                        if(!mFull) {
                            GSYVideoPlayer.releaseAllVideos();
                            recyclerNormalAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getActivity().getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
            getActivity().getWindow().setEnterTransition(new Explode());
            getActivity().getWindow().setExitTransition(new Explode());
        }
        super.onCreate(savedInstanceState);
    }


    public static Fragment getIntance(int position) {
        if (fragment == null) {
            fragment = new VideoRecycleFragment();
            Bundle args = new Bundle();
            args.putInt("position", position);
            fragment.setArguments(args);
        }
        return fragment;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //如果旋转了就全屏
        if (newConfig.orientation != ActivityInfo.SCREEN_ORIENTATION_USER) {
            mFull = false;
        } else {
            mFull = true;
        }

    }


    private void resolveData() {
        for (int i = 0; i < 19; i++) {
            VideoModel videoModel = new VideoModel();
            dataList.add(videoModel);
        }
        if (recyclerBaseAdapter != null)
            recyclerBaseAdapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        GSYVideoManager.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
        GSYVideoManager.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        GSYVideoPlayer.releaseAllVideos();
    }
    public VideoRecycleFragment(){}
}
