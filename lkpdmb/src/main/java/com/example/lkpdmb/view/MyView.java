package com.example.lkpdmb.view;

import com.example.lkpdmb.bean.ListBean;

public interface MyView {
    void onSuccess(ListBean listBean);
    void onFail(String msg);
}
