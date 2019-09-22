package com.example.koisjdnv.model;


import com.example.koisjdnv.api.MyServer;
import com.example.koisjdnv.bean.ListBean;
import com.example.koisjdnv.callback.MyCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModelmpl implements MyModel {
    @Override
    public void initData(final MyCallBack myCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyServer.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        final MyServer myserver = retrofit.create(MyServer.class);
        Observable <ListBean> data = myserver.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer <ListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ListBean listBean) {
                        myCallBack.onSuccess(listBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
