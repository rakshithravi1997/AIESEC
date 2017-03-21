package com.android.gdgvit.aiesec.activity.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.android.gdgvit.aiesec.R;
import com.android.gdgvit.aiesec.activity.EP.ActivityEPMain;

/**
 * Created by Shuvam Ghosh on 1/25/2017.
 */

public class ActivityLogin extends AppCompatActivity{

    private TextSwitcher textSwitcher;
    private ImageButton nextImageButton;
    private ImageButton previousImageButton;
    private String textNonAisec = "NON-AIESECER";
    private String textAisec = "AIESECER";
    private Button btnSignIn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textSwitcher = (TextSwitcher)findViewById(R.id.textSwitcher);
        textSwitcher.setFactory(mFactory);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);
        previousImageButton = (ImageButton)findViewById(R.id.previousImageButton);
        nextImageButton = (ImageButton)findViewById(R.id.nextImageButton);
        textSwitcher.setText(textAisec);
        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        textSwitcher.setInAnimation(in);
        textSwitcher.setOutAnimation(out);


        previousImageButton.setBackground(getDrawable(R.drawable.ic_chevron_left_blackdark_24dp));
        nextImageButton.setBackground(getDrawable(R.drawable.ic_chevron_right_black_24dp));


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityLogin.this, ActivityEPMain.class);
                startActivity(i);
            }
        });

        nextImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation in = AnimationUtils.loadAnimation(getApplicationContext(),
                        android.R.anim.fade_in);
                Animation out = AnimationUtils.loadAnimation(getApplicationContext(),
                        android.R.anim.fade_out);
                textSwitcher.setInAnimation(in);
                textSwitcher.setOutAnimation(out);
                textSwitcher.setText(textNonAisec);

                previousImageButton.setBackground(getDrawable(R.drawable.ic_chevron_left_black_24dp));
                nextImageButton.setBackground(getDrawable(R.drawable.ic_chevron_right_blackdark_24dp));

            }
        });

        previousImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation in = AnimationUtils.loadAnimation(getApplicationContext(),
                        android.R.anim.fade_in);
                Animation out = AnimationUtils.loadAnimation(getApplicationContext(),
                        android.R.anim.fade_out);
                textSwitcher.setInAnimation(in);
                textSwitcher.setOutAnimation(out);
                textSwitcher.setText(textAisec);

                previousImageButton.setBackground(getDrawable(R.drawable.ic_chevron_left_blackdark_24dp));
                nextImageButton.setBackground(getDrawable(R.drawable.ic_chevron_right_black_24dp));
            }
        });


    }


    private ViewSwitcher.ViewFactory mFactory = new ViewSwitcher.ViewFactory() {

        @Override
        public View makeView() {

            // Create a new TextView
            TextView t = new TextView(ActivityLogin.this);
            t.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER);
            t.setTextSize(16);
            //t.setTextAppearance(ActivityLogin.this, android.R.style.TextAppearance_Large);
            t.setTextColor(getResources().getColor(R.color.white));
            return t;
        }
    };
}
