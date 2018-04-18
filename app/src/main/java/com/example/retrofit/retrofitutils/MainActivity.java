package com.example.retrofit.retrofitutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.retrofit.retrofitlibrary.utils.HttpUtils;
import com.example.retrofit.retrofitlibrary.utils.ResultInterface;
import com.example.retrofit.retrofitutils.bean.NoticeBean;
import com.example.retrofit.retrofitutils.request.RequestMainInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<NoticeBean> mNoticeBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mNoticeBeanList = new ArrayList<>();
        initData();

        Toast.makeText(this,"Test", Toast.LENGTH_LONG).show();


    }

    private void initData() {
        RequestMainInfo requestMainInfo = new RequestMainInfo();
        HttpUtils httpUtils = HttpUtils.getInstance();
        httpUtils.getInfo(requestMainInfo);
        httpUtils.start(new ResultInterface() {
            @Override
            public void onSuccess(Object o) {
                mNoticeBeanList = (List<NoticeBean>) o;
            }

            @Override
            public void faild() {

            }
        });
    }
}
