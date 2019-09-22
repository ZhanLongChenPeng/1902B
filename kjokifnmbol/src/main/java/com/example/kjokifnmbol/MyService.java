package com.example.kjokifnmbol;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(){
            @Override
            public void run() {
                super.run();
                String path = "/storage/emulated/legacy/abc.apk";
                File file = new File(path);
                if (!file.exists()){
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    URL url = new URL("http://cdn.banmi.com/banmiapp/apk/banmi_330.apk");
                    HttpURLConnection op = (HttpURLConnection) url.openConnection();
                    if (op.getResponseCode() == 200){
                        Log.i("TAG","响应码："+op.getResponseCode());
                        InputStream in = op.getInputStream();
                        long max = op.getContentLength();
                        int len = 0;
                        int pass = 0;
                        FileOutputStream out = new FileOutputStream(file);
                        byte[] b = new byte[4096];
                        Log.i("TAG", "run: "+in.available());
                        while ((len = in.read(b)) != -1){
                            out.write(b,0,len);
                            pass+=len;
                            int zong  = (int) (pass*100/max);
                            MyEvenbus myEnevnbus = new MyEvenbus((int) max, pass, zong);
                            EventBus.getDefault().post(myEnevnbus);
                            Log.i("TAG", "run: "+len+" pass "+pass);
                        }
                        in.close();
                        out.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}