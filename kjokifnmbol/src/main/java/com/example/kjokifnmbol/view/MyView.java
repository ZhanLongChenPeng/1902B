package com.example.kjokifnmbol.view;

import com.example.kjokifnmbol.bean.ListBean;

public interface MyView {
    void onSuccess(ListBean listBean);
    void onFail(String msg);
}

