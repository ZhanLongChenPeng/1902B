package com.example.koisjdnv.api;

import com.example.koisjdnv.bean.ListBean;
import com.example.koisjdnv.bean.ListBeands;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyServer {
    public String url = "https://api.yunxuekeji.cn/yunxue_app_api/content/getData/30/66597/1/";
    @GET("10")
    Observable <ListBean> getData();

    public String url1 = "https://api.yunxuekeji.cn/yunxue_app_api/teacher/getTeacherPower/";
    @GET("{ID}")
    Observable <ListBeands> getData1(@Path("ID")int ID);
}
