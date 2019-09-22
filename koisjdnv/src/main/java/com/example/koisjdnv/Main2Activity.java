package com.example.koisjdnv;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.koisjdnv.adapter.MyRecyclerchuan;
import com.example.koisjdnv.adapter.MyVp;
import com.example.koisjdnv.bean.ListBean;
import com.example.koisjdnv.fragment.JieFragment;
import com.example.koisjdnv.fragment.KeFragment;
import com.example.koisjdnv.fragment.ZhanFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.recycler1)
    RecyclerView mRecycler1;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.tab)
    TabLayout mTab;
    private ListBean.BodyBean.ResultBean bean;
    private ArrayList <ListBean.BodyBean.ResultBean> list;
    private MyRecyclerchuan myRecycler;
    private MyVp myVp;
    private ArrayList <Fragment> list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        initData();
        initAdd();
    }

    private void initAdd() {
        list1 = new ArrayList<>();
        list1.add(new JieFragment());
        list1.add(new KeFragment());
        list1.add(new ZhanFragment());

        myVp = new MyVp(getSupportFragmentManager(), list1);
        mVp.setAdapter(myVp);
        mTab.setupWithViewPager(mVp);

        mTab.getTabAt(0).setText("介绍");
        mTab.getTabAt(1).setText("课程");
        mTab.getTabAt(2).setText("专题");
    }

    private void initData() {
        Intent intent = getIntent();
        bean = (ListBean.BodyBean.ResultBean) intent.getSerializableExtra("bean");
        String id = intent.getStringExtra("Id");

        list = new ArrayList <>();
        mRecycler1.setLayoutManager(new LinearLayoutManager(this));
        myRecycler = new MyRecyclerchuan(this, list);
        mRecycler1.setAdapter(myRecycler);
        list.add(bean);
    }
}
