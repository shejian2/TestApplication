package com.jrud.lib.network;

import com.jrud.lib.BuildConfig;
import com.jrud.lib.network.api.DemoService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DemoRetrofit {

    public static String BASE_URL="http://47.112.117.182:8095/";

    private static final int  DEFAULT_TIMEOUT = 60;

    public static Retrofit getRetrofit(){

        // 创建一个OkHttpClient
        OkHttpClient.Builder builder =new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS);

        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        if(BuildConfig.DEBUG){
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }else {
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        builder.addInterceptor(logInterceptor);

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    static Retrofit retrofit=getRetrofit();

    public static DemoService getDemoService(){
        return retrofit.create(DemoService.class);
    }
}
