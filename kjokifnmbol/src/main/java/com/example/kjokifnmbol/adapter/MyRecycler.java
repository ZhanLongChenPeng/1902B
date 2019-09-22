package com.example.kjokifnmbol.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.kjokifnmbol.R;
import com.example.kjokifnmbol.bean.ListBean;

import java.util.ArrayList;

import butterknife.OnLongClick;
import io.reactivex.annotations.NonNull;

public class MyRecycler extends RecyclerView.Adapter <MyRecycler.ViewHolder> {
    private ArrayList <ListBean.DataBean.DatasBean> list;
    private Context context;


    public MyRecycler(Context context, ArrayList <ListBean.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(ArrayList <ListBean.DataBean.DatasBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_main, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        ListBean.DataBean.DatasBean datasBean = list.get(position);
        if (position == 3){
            RoundedCorners roundedCorners = new RoundedCorners(8);
            RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(50, 50);
            Glide.with(context).load(datasBean.getEnvelopePic()).apply(options).into(holder.iv);
            holder.te1.setText("");
            holder.te2.setText("");
        }else {
            RoundedCorners roundedCorners = new RoundedCorners(8);
            RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(50, 50);
            Glide.with(context).load(datasBean.getEnvelopePic()).apply(options).into(holder.iv);
            holder.te1.setText(datasBean.getSuperChapterName());
            holder.te2.setText(datasBean.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView te1;
        private final TextView te2;

        public ViewHolder(View view) {
            super(view);
            iv = view.findViewById(R.id.iv);
            te1 = view.findViewById(R.id.te1);
            te2 = view.findViewById(R.id.te2);
        }
    }

    private OnLongClick onLongClick;

    public void setOnLongClick(OnLongClick onLongClick) {
        this.onLongClick = onLongClick;
    }

    public interface OnLongClick {
        void OnClick(int position, ListBean.DataBean.DatasBean datasBean);
    }
}
