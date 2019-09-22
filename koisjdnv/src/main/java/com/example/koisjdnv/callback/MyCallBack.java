package com.example.koisjdnv.callback;


import com.example.koisjdnv.bean.ListBean;

public interface MyCallBack {
    void onSuccess(ListBean listBean);
    void onFail(String msg);
}

