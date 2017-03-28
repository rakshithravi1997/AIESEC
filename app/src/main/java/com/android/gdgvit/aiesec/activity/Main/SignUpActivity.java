package com.android.gdgvit.aiesec.activity.Main;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.gdgvit.aiesec.R;
import com.android.gdgvit.aiesec.activity.EP.ActivityEPMain;
import com.android.gdgvit.aiesec.model.SignupResponse;
import com.android.gdgvit.aiesec.rest.ApiClient;
import com.android.gdgvit.aiesec.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Shuvam Ghosh on 3/27/2017.
 */

public class SignUpActivity extends AppCompatActivity{

    EditText name, email, password, raisedby, cp1, cp2, cp3, contactno;
    String recName, recEmail, recPassword, recRaisedby, recCp1, recCp2, recCp3, recContact;
    Button btnSignup;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = (EditText) findViewById(R.id.etName);
        email = (EditText) findViewById(R.id.etEmail);
        password = (EditText) findViewById(R.id.etPassword);
        raisedby = (EditText) findViewById(R.id.etRaisedBy);
        cp1 = (EditText) findViewById(R.id.etCountryPref1);
        cp2 = (EditText) findViewById(R.id.etCountryPref2);
        cp3 = (EditText) findViewById(R.id.etCountryPref3);
        contactno = (EditText) findViewById(R.id.etContactNo);
        btnSignup = (Button) findViewById(R.id.btnSignUp);




        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                recEmail = email.getText().toString();
                recName = name.getText().toString();
                recPassword = password.getText().toString();
                recEmail = email.getText().toString();
                recRaisedby = raisedby.getText().toString();
                recCp1 = cp1.getText().toString();
                recCp2 = cp2.getText().toString();
                recCp3 = cp3.getText().toString();
                recContact = contactno.getText().toString();


                ApiInterface apiService = ApiClient.getClient(SignUpActivity.this).create(ApiInterface.class);
                Call<SignupResponse> signup = apiService.signupUser(recEmail,recPassword,recName,recRaisedby,recCp1,recCp2,recCp3,recContact);


                signup.enqueue(new Callback<SignupResponse>() {
                    @Override
                    public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {


                        if(response.body().getStatus().toString().equals("not_given_access")){

                            Toast.makeText(SignUpActivity.this, "Not Given Access", Toast.LENGTH_SHORT).show();
                        }

                        if (response.body().getStatus().toString().equals("raised")) {

                            Toast.makeText(SignUpActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                            Intent in = new Intent(SignUpActivity.this,ActivityEPMain.class);
                            startActivity(in);
                            // Log.d("User_name:",""+response.body().getUser().getName());
                        }
                    }

                    @Override
                    public void onFailure(Call<SignupResponse> call, Throwable t) {

                    }
                });
            }
        });
        getSupportActionBar().setTitle("Sign Up");
    }
}
