package com.example.retrofit.retrofitutils.service;

import com.example.retrofit.retrofitlibrary.utils.HttpResult;
import com.example.retrofit.retrofitutils.bean.NoticeBean;

import java.util.List;
import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by xiaoguai on 2017/3/27.
 */

public interface GitHubService {

    @FormUrlEncoded
    @POST("ethank-sjz-web/rest/hotelResource/v1.1/queryHotelList")
    Observable<HttpResult<List<NoticeBean>>> getNoticeInfo(@FieldMap Map<String, String> hash);

}
