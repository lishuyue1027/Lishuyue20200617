package com.bawei.lishuyue.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.bawei.lishuyue.R;
import com.bawei.lishuyue.contract.MyContract;
import com.bawei.lishuyue.model.bean.MyBean;
import com.bawei.lishuyue.presenter.MainPresenter;
import com.bawei.lishuyue.view.adapter.MyAdapter;
import com.google.gson.Gson;

public class MainActivity extends BaseActivity<MainPresenter> implements MyContract.MainView {
    private RecyclerView recyclerView;
    private MyAdapter myAdapter=new MyAdapter(this);

    @Override
    public void sunccessTwo(String json) {
        MyBean myBean=new Gson().fromJson(json,MyBean.class);
        myAdapter.setList(myBean.getResult());
    }

    @Override
    public void fail(String mag) {

    }

    @Override
    protected void initData() {
        myAdapter.setOnClickInterface(new MyAdapter.OnClickInterface(){

            @Override
            public void onclik(String name, String price, String pic) {
                Intent intent=new Intent(MainActivity.this,TwoActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("price",price);
                intent.putExtra("pic",pic);
                startActivity(intent);
            }
        });
    }

    @Override
    protected MainPresenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        recyclerView=findViewById(R.id.recycler);
    }

    @Override
    protected int getlayout() {
        return R.layout.activity_main;
    }
}
