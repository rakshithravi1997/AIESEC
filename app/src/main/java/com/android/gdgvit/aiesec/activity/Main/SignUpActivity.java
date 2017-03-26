package com.android.gdgvit.aiesec.activity.Main;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.android.gdgvit.aiesec.R;

/**
 * Created by Shuvam Ghosh on 3/27/2017.
 */

public class SignUpActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().setTitle("Sign Up");
    }
}
