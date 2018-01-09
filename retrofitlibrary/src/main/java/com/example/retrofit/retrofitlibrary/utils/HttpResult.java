package com.example.retrofit.retrofitlibrary.utils;

/**
 * Created by  on 2017/3/27.
 */

public class HttpResult<T> {
    private int retCode;
    private String retMsg;
    private T retValue;

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public T getRetValue() {
        return retValue;
    }

    public void setRetValue(T retValue) {
        this.retValue = retValue;
    }
}
