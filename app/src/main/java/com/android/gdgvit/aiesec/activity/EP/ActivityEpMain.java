package com.android.gdgvit.aiesec.activity.EP;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.gdgvit.aiesec.R;
import com.android.gdgvit.aiesec.activity.Main.StartActivity;
import com.android.gdgvit.aiesec.fragment.EP.AddUserFragment;
import com.android.gdgvit.aiesec.fragment.EP.DocumentsFragment;
import com.android.gdgvit.aiesec.fragment.EP.ProfileFragment;
import com.android.gdgvit.aiesec.fragment.EP.ResourcesFragment;
import com.android.gdgvit.aiesec.model.LogoutResponse;
import com.android.gdgvit.aiesec.rest.ApiClient;
import com.android.gdgvit.aiesec.rest.ApiInterface;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Shuvam Ghosh on 3/29/2017.
 */

public class ActivityEpMain extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    SharedPreferences sps;
    SharedPreferences.Editor ed;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ep_main);
        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);


        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_1, R.drawable.ic_person_black_24dp, R.color.white);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_2, R.drawable.ic_folder_black_24dp, R.color.white);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.drawable.ic_archive_black_24dp, R.color.white);
        item1.setTitle("Profile");
        item2.setTitle("Documents");
        item3.setTitle("Resources");
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);


        sps = PreferenceManager.getDefaultSharedPreferences(this);

        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));
        bottomNavigation.setAccentColor(Color.parseColor("#9C27B0"));
        bottomNavigation.setInactiveColor(Color.parseColor("#9e9e9e"));
        bottomNavigation.setBehaviorTranslationEnabled(false);
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);

        bottomNavigation.setCurrentItem(1);
        final Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view) ;

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();


                if (item.getItemId() == R.id.nav_search) {

                }
                if (item.getItemId() == R.id.nav_add_user) {

                    mToolbar.setVisibility(View.VISIBLE);
                    AddUserFragment auf = new AddUserFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer,auf).commit();
                }

                if (item.getItemId() == R.id.nav_logout){


                    ProgressDialog progressDialog = new ProgressDialog(ActivityEpMain.this);
                    progressDialog.setTitle("Logging Out");
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progressDialog.show();
                    ed = sps.edit();
                    ed.putInt("LoggedIn",0);
                    ed.commit();

                    ApiInterface apiInterface = ApiClient.getLogoutClient(ActivityEpMain.this).create(ApiInterface.class);
                    Call<LogoutResponse> logoutResponseCall = apiInterface.logoutUser("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6Im5pc2hhbnQubmlqYWd1bmE4QGFpZXNlYy5uZXQiLCJ0aW1lIjoiMjMtMDMtMjAxNyAwNTozOCBQTSJ9.D3_yki5HlFdwzOcB2IBqaT65SA5mg2GlXFQpZ_MncxE");


                    logoutResponseCall.enqueue(new Callback<LogoutResponse>() {
                        @Override
                        public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {

                            Log.d("Logout Response:",""+""+response.body().getStatus());

                            Intent i = new Intent(getApplicationContext(), StartActivity.class);
                            startActivity(i);
                        }

                        @Override
                        public void onFailure(Call<LogoutResponse> call, Throwable t) {

                            Log.d("Logout Response:","Failed");


                        }
                    });





                }
               /* if (item.getItemId() == R.id.nav_registration) {

                }
                if (item.getItemId() == R.id.nav_my_club) {

                } if (item.getItemId() == R.id.nav_clubs_chapters) {


                }
                if (item.getItemId() == R.id._nav_feedback) {


                }*/

                return false;
            }
        });

        DocumentsFragment df = new DocumentsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer,df).commit();

        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, mToolbar,R.string.app_name,
                R.string.app_name);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {


                if(position==0)
                {
                    mToolbar.setVisibility(View.GONE);
                    ProfileFragment pf = new ProfileFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer,pf).commit();
                }
                else if(position==1)
                {
                    mToolbar.setVisibility(View.VISIBLE);
                    DocumentsFragment df = new DocumentsFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer,df).commit();
                }
                else if(position==2)
                {
                    mToolbar.setVisibility(View.VISIBLE);
                    ResourcesFragment rf = new ResourcesFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer,rf).commit();
                }

                // Do something cool here...
                return true;
            }
        });
        bottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
            @Override public void onPositionChange(int y) {
                // Manage the new y position
            }
        });
        
        
        
        

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
