package com.bawei.lishuyue.presenter;

import com.bawei.lishuyue.application.Constent;
import com.bawei.lishuyue.contract.MyContract;
import com.bawei.lishuyue.model.http.OkHttpUtils;

/**
 * @author 李淑月
 * @description:
 * @date :2020/6/17 9:57
 */
public class MainPresenter extends BasePresenter<MyContract.MainView> implements MyContract.MainPresenterInterface {
    private OkHttpUtils httpUtils;

    public MainPresenter() {
        httpUtils = OkHttpUtils.getHttpUtils();
    }

    @Override
    public void getTwo() {
        if(isNet()){
            httpUtils.get(Constent.TWO+"&keyword='板鞋'&page=1&count=5");
    }
    }
    public boolean isNet(){
        if(OkHttpUtils.isNet()){
            return true;
        }
        return false;
    }
}
