package com.example.retrofit.retrofitutils.request;

import com.example.retrofit.retrofitlibrary.utils.HttpResultFunc;
import com.example.retrofit.retrofitutils.bean.NoticeBean;
import com.example.retrofit.retrofitutils.service.GitHubService;
import java.util.HashMap;
import java.util.List;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by  on 2017/3/27.
 */

public class RequestMainInfo extends HttpResultFunc<List<NoticeBean>> {

    @Override
    public Observable getObservable(Retrofit retrofit) {
        GitHubService gitHubService = retrofit.create(GitHubService.class);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("hotelId","0014");
        hashMap.put("token","");
        Observable observable = gitHubService.getNoticeInfo(hashMap);
        return observable;
    }


}
