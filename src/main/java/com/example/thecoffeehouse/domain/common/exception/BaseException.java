package com.example.thecoffeehouse.domain.common.exception;

public class BaseException extends Exception{
    private int errorCode;
    private String devMess;
    private String userMess;
    private String moreInfo;
    private Object error;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getDevMess() {
        return devMess;
    }

    public void setDevMess(String devMess) {
        this.devMess = devMess;
    }

    public String getUserMess() {
        return userMess;
    }

    public void setUserMess(String userMess) {
        this.userMess = userMess;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}
