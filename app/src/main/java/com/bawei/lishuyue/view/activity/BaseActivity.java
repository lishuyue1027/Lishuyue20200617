package com.bawei.lishuyue.view.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.lishuyue.presenter.BasePresenter;
import com.bawei.lishuyue.view.BaseView;

/**
 * @author 李淑月
 * @description:
 * @date :2020/6/17 10:23
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayout());
        initView();
        presenter=setPresenter();
        if(presenter!=null){
            presenter.attchView(this);
        }
        initData();
    }

    protected abstract void initData();

    protected abstract P setPresenter();

    protected abstract void initView();

    protected abstract int getlayout();

    public P getPresenter() {
        return presenter;
    }
    //销毁

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.detachView();
        }
        presenter.detachView();
    }
}
