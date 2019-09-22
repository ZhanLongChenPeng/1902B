package com.example.koisjdnv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.koisjdnv.adapter.MyRecycler;
import com.example.koisjdnv.bean.DatasBean;
import com.example.koisjdnv.bean.ListBean;
import com.example.koisjdnv.model.MyModelmpl;
import com.example.koisjdnv.penester.MyPrenestermpl;
import com.example.koisjdnv.view.MyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MyView, MyRecycler.OnLongClick {

    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    private MyPrenestermpl myPrenestermpl;
    private MyRecycler myRecycler;
    private ArrayList <ListBean.BodyBean.ResultBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initAdd();
    }

    private void initData() {
        myPrenestermpl = new MyPrenestermpl(new MyModelmpl(), this);
        myPrenestermpl.initAdd();
    }


    private void initAdd() {
        list = new ArrayList <>();
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        myRecycler = new MyRecycler(this, list);
        mRecycler.setAdapter(myRecycler);

        myRecycler.setOnLongClick(this);
    }

    @Override
    public void OnClick(int position, ListBean.BodyBean.ResultBean datasBean) {
        Intent intent = new Intent(this, Main2Activity.class);
        ListBean.BodyBean.ResultBean resultBean = list.get(position);
        intent.putExtra("Id", resultBean.getID()+"");
        intent.putExtra("bean", list.get(position));
        startActivity(intent);
    }

    @Override
    public void onSuccess(ListBean listBean) {
        List <ListBean.BodyBean.ResultBean> result = listBean.getBody().getResult();
        list.addAll(result);
        myRecycler.setList(list);
        myRecycler.notifyDataSetChanged();
    }

    @Override
    public void onFail(String msg) {

    }
}
