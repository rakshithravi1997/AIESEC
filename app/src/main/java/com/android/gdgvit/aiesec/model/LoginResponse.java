package com.android.gdgvit.aiesec.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Shuvam Ghosh on 3/26/2017.
 */

public class LoginResponse {

    @SerializedName("msg")
    private String status;
    @SerializedName("code")
    private String code;
    @SerializedName("udata")
    private User user;
    @SerializedName("raisedBy")
    private String raisedby;
    @SerializedName("token")
    private  String token;
    @SerializedName("member")
    private String member;


    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}

