package com.example.kjokifnmbol.prenester;

import com.example.kjokifnmbol.bean.ListBean;
import com.example.kjokifnmbol.callback.MyCallBack;
import com.example.kjokifnmbol.model.MyModelmpl;
import com.example.kjokifnmbol.view.MyView;

public class MyPrenestermpl implements MyPrenester, MyCallBack {

    private MyModelmpl myModel;
    private MyView myView;

    public MyPrenestermpl(MyModelmpl myModel, MyView myView) {
        this.myModel = myModel;
        this.myView = myView;
    }

    @Override
    public void initAdd() {
        if (myModel != null) {
            myModel.initData(this);
        }
    }

    @Override
    public void onSuccess(ListBean listBean) {
        if (myView != null) {
            myView.onSuccess(listBean);
        }
    }

    @Override
    public void onFail(String msg) {
        if (myView != null) {
            myView.onFail(msg);
        }
    }
}