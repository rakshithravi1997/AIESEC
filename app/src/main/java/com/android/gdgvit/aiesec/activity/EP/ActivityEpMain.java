package com.android.gdgvit.aiesec.activity.EP;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.gdgvit.aiesec.R;
import com.android.gdgvit.aiesec.fragment.EP.DocumentsFragment;
import com.android.gdgvit.aiesec.fragment.EP.ProfileFragment;
import com.android.gdgvit.aiesec.fragment.EP.ResourcesFragment;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

/**
 * Created by Shuvam Ghosh on 3/29/2017.
 */

public class ActivityEpMain extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    Fragment fragment;
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

        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));
        bottomNavigation.setAccentColor(Color.parseColor("#9C27B0"));
        bottomNavigation.setInactiveColor(Color.parseColor("#9e9e9e"));
        bottomNavigation.setBehaviorTranslationEnabled(false);
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);

        bottomNavigation.setCurrentItem(1);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view) ;

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();


                if (item.getItemId() == R.id.nav_search) {

                }
                if (item.getItemId() == R.id.nav_today_event) {

                }

                if (item.getItemId() == R.id.nav_live_stats) {

                }
                if (item.getItemId() == R.id.nav_registration) {

                }
                if (item.getItemId() == R.id.nav_my_club) {

                } if (item.getItemId() == R.id.nav_clubs_chapters) {


                }
                if (item.getItemId() == R.id._nav_feedback) {


                }

                return false;
            }
        });

        DocumentsFragment df = new DocumentsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer,df).commit();
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
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

                    ProfileFragment pf = new ProfileFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer,pf).commit();
                }
                else if(position==1)
                {
                    DocumentsFragment df = new DocumentsFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer,df).commit();
                }
                else if(position==2)
                {
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
}
