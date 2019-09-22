package com.example.koisjdnv.adapter;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.koisjdnv.R;
import com.example.koisjdnv.bean.ListBean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import io.reactivex.annotations.NonNull;

public class MyRecyclerchuan extends RecyclerView.Adapter <MyRecyclerchuan.ViewHolder> {
    private ArrayList <ListBean.BodyBean.ResultBean> list;
    private Context context;
    private SharedPreferences mima;
    private SharedPreferences.Editor edit1;
    private Set <String> position1;
    private HashSet <String> hashSet = new HashSet <>();


    public MyRecyclerchuan(Context context, ArrayList <ListBean.BodyBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(ArrayList <ListBean.BodyBean.ResultBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.ttem_main, null);
        mima = context.getSharedPreferences("mima", context.MODE_PRIVATE);
        edit1 = mima.edit();
        position1 = mima.getStringSet("position", new HashSet <String>());
        hashSet.addAll(position1);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {
        final ListBean.BodyBean.ResultBean datasBean = list.get(i);
        Glide.with(context).load(datasBean.getTeacherPic()).apply(new RequestOptions().circleCrop()).into(holder.iv);
        holder.te1.setText(datasBean.getTeacherName());
        holder.te2.setText(datasBean.getTitle());


        holder.bt.setOnClickListener(new View.OnClickListener() {
            private String guan;

            @Override
            public void onClick(View v) {
                guan = holder.bt.getText().toString();

                if (guan.equals("关注")) {
                    holder.bt.setText("取消");
//                    DatasBeanDao datasBeanDao = MyApp.getInstance().getDaoSession().getDatasBeanDao();
//                    DatasBean datasBean12 = list.get(i);
//                    datasBeanDao.insert(datasBean12);
//                    Toast.makeText(context, "添加成功：", Toast.LENGTH_SHORT).show();

                    String s2 = ((ViewHolder) holder).bt.getText().toString();
                    hashSet.add(i+"");
                    edit1.putStringSet("position",hashSet);
                    edit1.commit();

                }
                if (guan.equals("取消")) {
//                    DatasBeanDao datasBeanDao = MyApp.getInstance().getDaoSession().getDatasBeanDao();
//                    datasBeanDao.delete(list.get(i));
                    holder.bt.setText("关注");
//                    Toast.makeText(context, "删除成功：", Toast.LENGTH_SHORT).show();

                    hashSet.remove(i+"");
                    edit1.putStringSet("position",hashSet);
                    edit1.commit();


                }
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onLongClick != null){
                    onLongClick.OnClick(i, datasBean);
                }
            }
        });

        this.position1 = mima.getStringSet("position", new HashSet<String>());
        for (String s: position1) {
            if (String.valueOf(i).equals(s)){
                ((ViewHolder) holder).bt.setText("取消");
            }
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
        private final Button bt;

        public ViewHolder(View view) {
            super(view);
            iv = view.findViewById(R.id.iv);
            te1 = view.findViewById(R.id.te1);
            te2 = view.findViewById(R.id.te2);
            bt = view.findViewById(R.id.bt);
        }
    }

    private OnLongClick onLongClick;

    public void setOnLongClick(OnLongClick onLongClick) {
        this.onLongClick = onLongClick;
    }

    public interface OnLongClick {
        void OnClick(int position, ListBean.BodyBean.ResultBean datasBean);
    }
}
