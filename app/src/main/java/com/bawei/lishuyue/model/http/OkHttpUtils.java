package com.bawei.lishuyue.model.http;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;


import androidx.annotation.NonNull;

import com.bawei.lishuyue.application.MyApplication;

import java.util.HashMap;

/**
 * @author 李淑月
 * @description:
 * @date :2020/6/17 9:21
 */
public class OkHttpUtils {
    private static OkHttpUtils httpUtils;
    //私有构造方法
    private OkHttpUtils(){}
    public static OkHttpUtils getHttpUtils(){
        if(httpUtils==null){
            httpUtils=new OkHttpUtils();
        }
        return httpUtils;
    }
    //get请求
    public void get(String url){

    }
    //post请求
    public void post(String url, HashMap<String,String> params){

    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                String s= (String) msg.obj;
                //进行接口回调

            }
        }
    };
    //判断是否有网
    public static boolean isNet(){
        ConnectivityManager conn= (ConnectivityManager) MyApplication.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info=conn.getActiveNetworkInfo();
        if(info!=null){
            return info.isAvailable();
        }
        return false;
    }
}
