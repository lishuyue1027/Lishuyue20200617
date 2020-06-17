package com.bawei.lishuyue.presenter;

import com.bawei.lishuyue.view.BaseView;

/**
 * @author 李淑月
 * @description:
 * @date :2020/6/17 9:52
 */
public class BasePresenter<V extends BaseView> {
    private V view;
    //绑定
    public void attchView(V view){
        view=view;
    }
    //获取
    public V getView(){
        return view;
    }
    //取消绑定
    public void detachView(){
        view=null;
    }
}
