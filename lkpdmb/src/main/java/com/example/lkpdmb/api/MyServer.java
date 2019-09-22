package com.example.lkpdmb.api;



import com.example.lkpdmb.bean.ListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
public interface MyServer {
    public String url = "http://gank.io/api/data/福利/20/";
        @GET("1")
        Observable <ListBean> getData();
}
