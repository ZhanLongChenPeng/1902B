package com.example.lkpdmb.callback;

import com.example.lkpdmb.bean.ListBean;

public interface MyCallBack {
    void onSuccess(ListBean listBean);
    void onFail(String msg);
}

