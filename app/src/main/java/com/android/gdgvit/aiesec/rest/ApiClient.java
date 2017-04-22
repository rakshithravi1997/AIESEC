package com.android.gdgvit.aiesec.rest;

import android.content.Context;

import com.android.gdgvit.aiesec.utility.Consts;
import com.android.gdgvit.aiesec.utility.Preferences;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class ApiClient {

    public static final String BASE_URL = "http://139.59.62.236:8000/ep/";
    public static final String BASE_LOGOUT_URL = "http://139.59.62.236:8000/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(final Context context, String baseUrl) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (retrofit==null) {
            OkHttpClient ok=new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request=chain.request().newBuilder().addHeader("access-token", Preferences.getPrefs(Consts.TOKEN_SP_KEY,context)).build();
                            return chain.proceed(request);
                        }
                    })
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(ok.newBuilder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build())
                    .build();
        }
        return retrofit;
    }
}
