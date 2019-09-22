package com.example.kjgiugiu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.kjgiugiu.adapter.MyRecycler;
import com.example.kjgiugiu.bean.DatasBean;
import com.example.kjgiugiu.bean.ListBean;
import com.example.kjgiugiu.model.MyModelmpl;
import com.example.kjgiugiu.penester.MyPrenestermpl;
import com.example.kjgiugiu.view.MyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MyView {

    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    private MyPrenestermpl myPrenestermpl;
    private ArrayList <DatasBean> list;
    private MyRecycler myRecycler;

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
    }

    @Override
    public void onSuccess(ListBean listBean) {
        List <DatasBean> datas = listBean.getDatas();
        list.addAll(datas);
        myRecycler.setList(list);
        myRecycler.notifyDataSetChanged();
    }

    @Override
    public void onFail(String msg) {

    }
}
