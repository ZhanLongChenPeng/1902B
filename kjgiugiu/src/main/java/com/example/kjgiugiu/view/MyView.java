package com.example.kjgiugiu.view;

import com.example.kjgiugiu.bean.ListBean;

public interface MyView {
    void onSuccess(ListBean listBean);
    void onFail(String msg);
}
