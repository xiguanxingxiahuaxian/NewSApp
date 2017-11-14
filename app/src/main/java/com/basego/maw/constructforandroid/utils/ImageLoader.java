package com.basego.maw.constructforandroid.utils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.basego.maw.constructforandroid.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;


import java.io.File;


public class ImageLoader {
    private volatile static ImageLoader singleton;
    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";

    private ImageLoader() {
    }

    public static ImageLoader getSingleton() {
        if (singleton == null) {
            synchronized (ImageLoader.class) {
                if (singleton == null) {
                    singleton = new ImageLoader();
                }
            }
        }
        return singleton;
    }


    //直接加载网络图片
    private void displayImage(String url, Context context, ImageView imageView, int placeholderImage, int failureImage) {
        Glide.with(context)
                .load(url)
                .fitCenter()
                .placeholder(placeholderImage)
                .error(failureImage)
                .fitCenter()
                .crossFade()
                .into(imageView);
    }

    public void displayImage(String url, Context context, ImageView imageView) {
        displayImage(url, context, imageView, R.mipmap.bg_morentu, R.mipmap.bg_morentu);
    }

    public void displayLongImage(String url, Context context, ImageView imageView) {
        displayImage(url, context, imageView, R.mipmap.bg_morentu, R.mipmap.bg_morentu);
    }

    //加载SD卡图片
    public void displayImage(Context context, File file, ImageView imageView) {
        Glide
                .with(context)
                .load(file)
                .centerCrop()
                .into(imageView);
    }

    //加载SD卡图片并设置大小
    public void displayImage(Context context, File file, ImageView imageView, int width, int height) {
        Glide
                .with(context)
                .load(file)
                .override(width, height)
                .centerCrop()
                .into(imageView);

    }

    //加载网络图片并设置大小
    public void displayImage(Context context, String url, ImageView imageView, int width, int height) {
        Glide
                .with(context)
                .load(url)
                .centerCrop()
                .override(width, height)
                .crossFade()
                .into(imageView);
    }

    //加载drawable图片
    public void displayImage(Context context, int resId, ImageView imageView) {
        Glide.with(context)
                .load(resourceIdToUri(context, resId))
                .crossFade()
                .into(imageView);
    }

    //加载drawable图片显示为圆形图片
    public void displayCricleImage(Context context, int resId, ImageView imageView) {
        Glide.with(context)
                .load(resourceIdToUri(context, resId))
                .crossFade()
                .transform(new GlideCircleTransform(context))
                .into(imageView);
    }

    //加载网络图片显示为圆形图片
    public void displayCricleImage(Context context, String url, ImageView imageView) {
        this.displayTransformationImage(context, url, imageView, new GlideCircleTransform(context));
    }

    public void displayBlurImage(Context context, String url, ImageView imageView) {
        this.displayTransformationImage(context, url, imageView, new BlurTransformation(context));
    }

    public void displayTransformationImage(Context context, String url, ImageView imageView, Transformation transform) {
        Glide
                .with(context)
                .load(url)
                .transform(new GlideCircleTransform(context))
                .crossFade()
                .bitmapTransform(transform)
                .into(imageView);
    }


    //加载SD卡图片显示为圆形图片
    public void displayCricleImage(Context context, File file, ImageView imageView) {
        Glide.with(context)
                .load(file)
                .centerCrop()
                .transform(new GlideCircleTransform(context))
                .into(imageView);

    }

    //将资源ID转为Uri
    public Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + resourceId);
    }

    public void saveImage(Context context, String url) {
        Glide
                .with(context)
                .load(url)
                .downloadOnly(new SimpleTarget<File>() {
                    @Override
                    public void onResourceReady(File resource, GlideAnimation<? super File> glideAnimation) {

                    }
                });


    }


}