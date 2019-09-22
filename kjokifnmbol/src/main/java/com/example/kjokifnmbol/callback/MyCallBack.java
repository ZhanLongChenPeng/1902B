package com.example.kjokifnmbol.callback;

import com.example.kjokifnmbol.bean.ListBean;

public interface MyCallBack {
    void onSuccess(ListBean listBean);
    void onFail(String msg);
}
