package com.example.kjokifnmbol.server;

import com.example.kjokifnmbol.bean.ListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Myserver {
    public String url = "https://www.wanandroid.com/project/list/1/";
        @GET("json?cid=294")
        Observable <ListBean> getData();
}
