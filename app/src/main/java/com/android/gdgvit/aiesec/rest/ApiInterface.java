package com.android.gdgvit.aiesec.rest;


import android.net.Uri;
import android.support.annotation.NonNull;

import com.android.gdgvit.aiesec.model.AddUserResponse;
import com.android.gdgvit.aiesec.model.LoginResponse;
import com.android.gdgvit.aiesec.model.LogoutResponse;
import com.android.gdgvit.aiesec.model.SignupResponse;
import com.android.gdgvit.aiesec.model.UploadResponse;
import com.android.gdgvit.aiesec.utility.FileUtils;

import java.io.File;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;


public interface ApiInterface {


    /*@POST("login")
    Call<LoginResponse> getLoginResponse(@Query("api_key")String apiKey);*/

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> updateUser(@Field("email") String email, @Field("pswd") String password, @Field("member") String member);

    @FormUrlEncoded
    @POST("signup")
    Call<SignupResponse> signupUser(@Field("email") String name, @Field("pswd") String password, @Field("name") String email,@Field("raisedby") String raisedby, @Field("cpf1") String countrypref1 ,  @Field("cpf2") String countrypref2, @Field("cpf3") String countrypref3, @Field("ctNo") String contactnp );


    /*@Multipart
    @POST("uploads")
    Call<UploadResponse> uploadData(@Part("token") RequestBody token,@Part MultipartBody.Part image);*/

   /* @Multipart
    @POST("upload")
    Call<ResponseBody> uploadFileWithPartMap(
            @PartMap() Map<String, RequestBody> partMap,
            @Part MultipartBody.Part file);*/

    @FormUrlEncoded
    @POST("admin/addUser")
    Call<AddUserResponse> addUser(@Field("token") String token, @Field("aemail") String aemail, @Field("uemail") String uemal, @Field("body") String body);


    @FormUrlEncoded
    @POST("logout")
    Call<LogoutResponse> logoutUser(@Field("token") String token);



}