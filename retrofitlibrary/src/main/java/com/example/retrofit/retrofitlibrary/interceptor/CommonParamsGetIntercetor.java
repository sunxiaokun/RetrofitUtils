package com.example.retrofit.retrofitlibrary.interceptor;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;

/**
 * get 请求拦截器
 */

public class CommonParamsGetIntercetor implements Interceptor {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        HttpUrl httpUrl = request.url().newBuilder()
                .addQueryParameter("versionCode","68343")
                .addQueryParameter("dev","android")
                .addQueryParameter("deviceType","1")
                .addQueryParameter("ct","ethankTest")
                .addQueryParameter("appSign","A99C1B8E45E40DB1D1579F8703C4D966")
                .addQueryParameter("deviceID","3340")
                .addQueryParameter("tagVersion","3.1.0")
                .addQueryParameter("openType","1")
                .addQueryParameter("netType","1")
                .addQueryParameter("deviceName","品牌:Xiaomi型号:MI 5")
                .addQueryParameter("channel","20")
                .build();
        request = request.newBuilder().url(httpUrl).build();

        return chain.proceed(request);
    }
}
