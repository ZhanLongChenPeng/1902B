package com.example.kjokifnmbol.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kjokifnmbol.R;
import com.example.kjokifnmbol.adapter.MyRecycler;
import com.example.kjokifnmbol.bean.ListBean;
import com.example.kjokifnmbol.model.MyModelmpl;
import com.example.kjokifnmbol.prenester.MyPrenestermpl;
import com.example.kjokifnmbol.view.MyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShouFragment extends Fragment implements MyView {


    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    private MyPrenestermpl myPrenestermpl;
    private ArrayList <ListBean.DataBean.DatasBean> list;
    private MyRecycler myRecycler;
    private View view;
    private Unbinder unbinder;

    public ShouFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_shou, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        initData();
        initAdd();
        return inflate;
    }

    private void initData() {
        myPrenestermpl = new MyPrenestermpl(new MyModelmpl(), this);
        myPrenestermpl.initAdd();
    }


    private void initAdd() {
        list = new ArrayList <>();

        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        myRecycler = new MyRecycler(getActivity(), list);
        mRecycler.setAdapter(myRecycler);
    }

    @Override
    public void onSuccess(ListBean listBean) {
        List <ListBean.DataBean.DatasBean> datas = listBean.getData().getDatas();
        list.addAll(datas);
        myRecycler.setList(list);
        myRecycler.notifyDataSetChanged();
    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
