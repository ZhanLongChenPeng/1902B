package com.example.kjgiugiu.callback;

import com.example.kjgiugiu.bean.ListBean;

public interface MyCallBack {
    void onSuccess(ListBean listBean);
    void onFail(String msg);
}

