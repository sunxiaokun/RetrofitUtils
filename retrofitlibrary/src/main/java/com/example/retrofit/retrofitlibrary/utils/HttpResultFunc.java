package com.example.retrofit.retrofitlibrary.utils;

import android.util.Log;

import retrofit2.Retrofit;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by on 2017/3/27.
 */

public abstract class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

    private String baseUrl = "http://sjz.ihotels.cc/";


    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public abstract Observable getObservable(Retrofit retrofit);


    @Override
    public T call(HttpResult<T> httpResult) {
        if (httpResult.getRetCode() != 200) {
            Log.i("retCode", httpResult.getRetMsg() + "---" + httpResult.getRetCode());
            return httpResult.getRetValue();
        }
        return httpResult.getRetValue();

    }
}
