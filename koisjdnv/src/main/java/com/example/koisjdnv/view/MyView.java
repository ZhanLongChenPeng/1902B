package com.example.koisjdnv.view;

import com.example.koisjdnv.bean.ListBean;

public interface MyView {
    void onSuccess(ListBean listBean);
    void onFail(String msg);
}
