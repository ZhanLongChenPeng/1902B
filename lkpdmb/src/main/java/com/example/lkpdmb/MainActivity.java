package com.example.lkpdmb;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lkpdmb.adapter.MyRecycler;
import com.example.lkpdmb.adapter.MyVpAdapter;
import com.example.lkpdmb.bean.ListBean;
import com.example.lkpdmb.fragment.VpFragment;
import com.example.lkpdmb.model.MyModelmpl;
import com.example.lkpdmb.prenester.MyPrenestermpl;
import com.example.lkpdmb.view.MyView;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MyView, MyRecycler.OnLongClick {

    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    @BindView(R.id.viewpader)
    ViewPager mViewpader;
    @BindView(R.id.te)
    TextView mTe;
    private MyPrenestermpl myPrenestermpl;
    private ArrayList <ListBean.ResultsBean> list;
    private MyRecycler myRecycler;
    private int isxian = View.VISIBLE;
    private List <ListBean.ResultsBean> results;
    private ArrayList <Fragment> fragments;
    private MyVpAdapter vpAdapter;
    private int page;

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

        mRecycler.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL));

        myRecycler = new MyRecycler(this, list);
        mRecycler.setAdapter(myRecycler);

        myRecycler.setOnLongClick(this);
    }

    @Override
    public void OnClick(int position, ListBean.ResultsBean resultsBean) {
        initAss();
        notifyDataSetChanged();
    }
    private void notifyDataSetChanged() {
        mRecycler.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess(ListBean listBean) {
        results = listBean.getResults();
        list.addAll(results);
        myRecycler.setList(list);
        myRecycler.notifyDataSetChanged();
    }

    @Override
    public void onFail(String msg) {

    }


    private void initAss() {
        fragments = new ArrayList <>();
        for (int i = 0; i < results.size(); i++) {
            VpFragment vpFragment = new VpFragment();
            Bundle bundle = new Bundle();
            bundle.putString("imgUrl", results.get(i).getUrl());
            vpFragment.setArguments(bundle);
            //把fragment添加到集合中
            fragments.add(vpFragment);
        }
//        创建适配器
        vpAdapter = new MyVpAdapter(getSupportFragmentManager(), fragments);
        //绑定适配器
        mViewpader.setAdapter(vpAdapter);
        //页数
        showTv(1, results.size());
        //切换
        mViewpader.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                showTv(position + 1, results.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void showTv(int index, int all) {
        mTe.setText("第" + index + "张/共" + all + "张");
    }
}