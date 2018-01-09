package com.example.retrofit.retrofitlibrary.utils;

import android.util.Log;

import com.example.retrofit.retrofitlibrary.interceptor.CommonParamsInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by  on 2017/3/27.
 */

public class HttpUtils {

    private ResultInterface mResultInterface;

    private static class HolderClass {
        private final static HttpUtils httpUtils = new HttpUtils();
    }

    public static HttpUtils getInstance() {
        return HolderClass.httpUtils;
    }

    public void start(ResultInterface resultInterface) {
        this.mResultInterface = resultInterface;
    }

    public void getInfo(final HttpResultFunc httpResultFunc) {
        CommonParamsInterceptor commonParamsInterceptor = new CommonParamsInterceptor();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("RetrofitLog", "retrofitBack = " + message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(commonParamsInterceptor)
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl(httpResultFunc.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();


        Observable observable = httpResultFunc.getObservable(mRetrofit);
        observable.map(httpResultFunc)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("e", e.toString());
                    }

                    @Override
                    public void onNext(Object o) {

                        if (o != null) {
                            mResultInterface.onSuccess(o);
                        } else {
                            mResultInterface.faild();
                        }
                    }
                });

    }
}
