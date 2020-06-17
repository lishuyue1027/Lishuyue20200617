package com.bawei.lishuyue.view.activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bawei.lishuyue.R;
import com.bawei.lishuyue.presenter.BasePresenter;
import com.bawei.lishuyue.presenter.MainPresenter;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

/**
 * @author 李淑月
 * @description:
 * @date :2020/6/17 10:34
 */
public class TwoActivity extends BaseActivity{
    private ImageView imageView;
    private Button button;
    private static final int PERMS_GODE=1;
    private static final int PERMS=2;
    @Override
    protected void initData() {
        final Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String price=intent.getStringExtra("price");
        String pic=intent.getStringExtra("pic");
        Uri uri=Uri.parse(pic);
        //生成二维码
        Bitmap bitmap= CodeUtils.createImage(name,400,400, BitmapFactory.decodeFile(pic));
        imageView.setImageBitmap(bitmap);
        String[] prem=new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA};
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP_MR1){
            requestPermissions(prem,PERMS);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(TwoActivity.this, CaptureActivity.class);
                startActivityForResult(intent,PERMS_GODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PERMS_GODE){
            if(null!=data){
                Bundle bundle=data.getExtras();
                if(bundle==null){
                    return;
                }
                if(bundle.getInt(CodeUtils.RESULT_TYPE)==CodeUtils.RESULT_SUCCESS){
                    String result=bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this,"解析结果："+result,Toast.LENGTH_SHORT).show();
                }else if(bundle.getInt(CodeUtils.RESULT_TYPE)==CodeUtils.RESULT_FAILED){
                    Toast.makeText(this,"解析二维码失败",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected BasePresenter setPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        imageView=findViewById(R.id.er);
        button=findViewById(R.id.shao);
    }

    @Override
    protected int getlayout() {
        return R.layout.seconed;
    }
}
