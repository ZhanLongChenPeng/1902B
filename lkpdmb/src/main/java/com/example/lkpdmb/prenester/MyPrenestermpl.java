package com.example.lkpdmb.prenester;

import com.example.lkpdmb.bean.ListBean;
import com.example.lkpdmb.callback.MyCallBack;
import com.example.lkpdmb.model.MyModelmpl;
import com.example.lkpdmb.view.MyView;

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
