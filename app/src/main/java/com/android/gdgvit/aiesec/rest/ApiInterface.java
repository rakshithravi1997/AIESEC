package com.android.gdgvit.aiesec.rest;


import com.android.gdgvit.aiesec.model.LoginResponse;
import com.android.gdgvit.aiesec.model.SignupResponse;

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

    @FormUrlEncoded
    @POST("signup")
    Call<SignupResponse> signupUser(@Field("name") String name, @Field("pswd") String password, @Field("email") String email,@Field("raisedby") String raisedby, @Field("cpf1") String countrypref1 ,  @Field("cpf2") String countrypref2, @Field("cpf3") String countrypref3, @Field("ctNo") String contactnp );


}