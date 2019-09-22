package com.example.lkpdmb.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lkpdmb.R;
import com.example.lkpdmb.bean.ListBean;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;

public class MyRecycler extends RecyclerView.Adapter<MyRecycler.ViewHolder> {
    private ArrayList <ListBean.ResultsBean> list;
    private Context context;


    public MyRecycler(Context context, ArrayList <ListBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(ArrayList <ListBean.ResultsBean> list) {
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
        final ListBean.ResultsBean resultsBean = list.get(position);
        Glide.with(context).load(resultsBean.getUrl()).into(holder.iv);

        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onLongClick != null){
                    onLongClick.OnClick(position, resultsBean);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;

        public ViewHolder(View view) {
            super(view);
            iv = view.findViewById(R.id.iv);
        }
    }
    private OnLongClick onLongClick;

    public void setOnLongClick(OnLongClick onLongClick) {
        this.onLongClick = onLongClick;
    }
    public interface OnLongClick{
        void OnClick(int position, ListBean.ResultsBean resultsBean);
    }
}

