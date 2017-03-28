package com.android.gdgvit.aiesec.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Shuvam Ghosh on 3/26/2017.
 */

public class SignupResponse {

    @SerializedName("status")
    private String status;
    @SerializedName("code")
    private String code;

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





}

