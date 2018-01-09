package com.example.retrofit.retrofitlibrary.interceptor;

import android.util.ArrayMap;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * post 请求的拦截器
 */

public class CommonParamsInterceptor implements Interceptor {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Map<String, String> arrayMap = new ArrayMap<>();
        arrayMap.put("versionCode","68343");
        arrayMap.put("lon","116.452558");
        arrayMap.put("memberId","J8416816905");
        arrayMap.put("dev", "android");
        arrayMap.put("deviceType","1");
        arrayMap.put("pageSize","10");
        arrayMap.put("pageIndex","1");
        arrayMap.put("jpushID","1a0018970a98b77945c");
        arrayMap.put("ct","qihoo360");
        arrayMap.put("cityName","北京");
        arrayMap.put("appSign","A99C1B8E45E40DB1D1579F8703C4D966");
        arrayMap.put("deviceID","354765085984532");
        arrayMap.put("beginDate","2017-12-27");
        arrayMap.put("tagVersion","3.4.1");
        arrayMap.put("openType","1");
        arrayMap.put("endDate","2017-12-28");
        arrayMap.put("netType","WIFI");
        arrayMap.put("deviceName","品牌:samsung型号:SM-G9500");
        arrayMap.put("channel","20");
        arrayMap.put("lat","39.915146");
        arrayMap.put("user_id","J8416816905");

        if(request.body() instanceof FormBody){
            FormBody oldBody = (FormBody) request.body();
            for(int i=0; i<oldBody.size(); i++){
                arrayMap.put(oldBody.encodedName(i), oldBody.encodedValue(i));
            }
        }
        Gson gson = new Gson();
        Log.i("gson", gson.toJson(arrayMap).toString()+"-----------");
        RequestBody requestBody = RequestBody.create(JSON,gson.toJson(arrayMap));
        request = request.newBuilder().post(requestBody).build();
        return chain.proceed(request);
    }
}
