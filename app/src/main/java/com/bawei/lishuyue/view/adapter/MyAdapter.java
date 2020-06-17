package com.bawei.lishuyue.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.lishuyue.R;
import com.bawei.lishuyue.model.bean.MyBean;
import com.bawei.lishuyue.view.activity.MainActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.util.List;

/**
 * @author 李淑月
 * @description:
 * @date :2020/6/17 10:03
 */
public class MyAdapter extends RecyclerView.Adapter {
    private Context context;

    public MyAdapter(Context context) {
        this.context = context;
    }
    private List<MyBean.ResultBean> list;

    public MyAdapter (MainActivity mainActivity){}

    public void setList(List<MyBean.ResultBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        final MyBean.ResultBean resultBean=list.get(position);
        holder1.name.setText(resultBean.getCommodityName());
        holder1.price.setText("￥"+resultBean.getPrice());
        Uri parse=Uri.parse(resultBean.getMasterPic());
        ImageRequest build= ImageRequestBuilder.newBuilderWithSource(parse)
                .setProgressiveRenderingEnabled(true).build();
        AbstractDraweeController controller= Fresco.newDraweeControllerBuilder()
                .setImageRequest(build).build();
        holder1.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickInterface.onclik(resultBean.getCommodityName(),"￥"+resultBean.getPrice(),resultBean.getMasterPic());
            }
        });
    }

    @Override
    public int getItemCount() {
        if(list!=null)
            return list.size();
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView name,price;
        private RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img);
            name=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.price);
            relativeLayout=itemView.findViewById(R.id.relat);
        }
    }
    private OnClickInterface onClickInterface;

    public void setOnClickInterface(OnClickInterface onClickInterface) {
        this.onClickInterface = onClickInterface;
    }

    public interface OnClickInterface{
        void onclik(String name,String price,String pic);
    }

}
