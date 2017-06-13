package com.android.gdgvit.aiesec.activity.Main.oGet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.gdgvit.aiesec.R;
import com.android.gdgvit.aiesec.activity.Aiesecer.ASignUpActivity;
import com.android.gdgvit.aiesec.activity.EP.EPSignUpActivity;
import com.android.gdgvit.aiesec.activity.Main.ActivityLogin;

public class SignUpActivity extends AppCompatActivity {

    Button signupEP, signupA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signupA = (Button) findViewById(R.id.btnSignUpAiesec);
        signupEP = (Button) findViewById(R.id.btnSignUpEP);

        signupA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpActivity.this,ASignUpActivity.class);
                startActivity(i);

            }
        });

        signupEP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpActivity.this,EPSignUpActivity.class);
                startActivity(i);

            }
        });
    }
}
