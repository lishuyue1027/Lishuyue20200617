package com.bawei.lishuyue.application;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * @author 李淑月
 * @description:
 * @date :2020/6/17 9:21
 */
public class MyApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        //初始化二维码
        ZXingLibrary.initDisplayOpinion(this);
        //初始化图片框架
        Fresco.initialize(this);
    }
}
