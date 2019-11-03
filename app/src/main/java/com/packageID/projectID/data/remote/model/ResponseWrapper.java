/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 17/9/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 9/17/19 9:02 PM
 *
 *
 * <Response Wrapper. usefull to define all Api Response Wrapper>
 */

package com.packageID.projectID.data.remote.model;

import com.google.gson.annotations.SerializedName;



public class ResponseWrapper<T> {


    @SerializedName("data")
    private T mData;
    @SerializedName("error")
    private Boolean mError;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("authToken")
    private String mAuthToken;

    public String getAuthToken() {
        return mAuthToken;
    }

    public void setAuthToken(String mAuthToken) {
        this.mAuthToken = mAuthToken;
    }

    public T getData() {
        return mData;
    }

    public void setData(T data) {
        mData = data;
    }

    public Boolean getError() {
        return mError;
    }

    public void setError(Boolean error) {
        mError = error;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }
}
