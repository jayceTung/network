package com.od.core.model;

/**
 * Created by Super on 2017/9/14.
 */

public class RestError {
    private String mErrorCode;
    private String mMessage;
    private int errorType;

    public String getmErrorCode() {
        return mErrorCode;
    }

    public void setmErrorCode(String mErrorCode) {
        this.mErrorCode = mErrorCode;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public int getErrorType() {
        return errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }
}
