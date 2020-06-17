package com.bawei.lishuyue.contract;

import com.bawei.lishuyue.view.BaseView;

/**
 * @author 李淑月
 * @description:
 * @date :2020/6/17 9:28
 */
public interface MyContract {
    public interface MainView extends BaseView{
        void sunccessTwo(String json);
        void fail(String mag);
    }
    public interface MainPresenterInterface{
        void getTwo();
    }
}
