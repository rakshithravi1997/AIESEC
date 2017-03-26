package com.android.gdgvit.aiesec.rest;


import com.android.gdgvit.aiesec.model.LoginResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;


public interface ApiInterface {


    /*@POST("login")
    Call<LoginResponse> getLoginResponse(@Query("api_key")String apiKey);*/

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> updateUser(@Field("email") String email, @Field("pswd") String password);
}