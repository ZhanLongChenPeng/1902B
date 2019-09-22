package com.example.kjgiugiu.api;

import com.example.kjgiugiu.bean.ListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyServer {
    public String url = "http://static.owspace.com/";
        @GET("?c=api&a=getList&page_id=0")
        Observable <ListBean> getData();
}
