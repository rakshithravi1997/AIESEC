package com.android.gdgvit.aiesec.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Shuvam Ghosh on 3/26/2017.
 */

public class LoginResponse {

    @SerializedName("status")
    private String status;
    @SerializedName("code")
    private String code;
    @SerializedName("user_data")
    private User user;
    @SerializedName("is_admin")
    private String isAdmin;

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
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

