package com.android.gdgvit.aiesec.activity.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.android.gdgvit.aiesec.R;
import com.android.gdgvit.aiesec.activity.EP.ActivityEpMain;
import com.android.gdgvit.aiesec.activity.Main.oGet.OGetFragment;
import com.android.gdgvit.aiesec.fragment.StartScreenFragments.StartActivityFragment1;
import com.android.gdgvit.aiesec.fragment.StartScreenFragments.StartActivityFragment2;

/**
 * Created by Shuvam Ghosh on 3/2/2017.
 */

public class StartActivity extends AppCompatActivity{

    private ViewPager vp;
    private StartActivity.ViewPagerAdapter adapter;
    private ImageView iv1,iv2;
    private ImageView ivLogo;
    private Animation animAlpha;
    private NavigationView navView;
    private ImageView ivHamburger;
    private Toolbar toolbar;
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    private Bundle mSavedInstanceState;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        vp = (ViewPager)findViewById(R.id.viewPagerOnboarding);
        adapter = new StartActivity.ViewPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
        ivHamburger = (ImageView)findViewById(R.id.ivHamburger);
        navView = (NavigationView)findViewById(R.id.nav_view);
        animAlpha = AnimationUtils.loadAnimation(this,R.anim.alphaanim);
        ivLogo = (ImageView)findViewById(R.id.ivLogo);
        iv1 = (ImageView)findViewById(R.id.iv1);



        ivHamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open the drawer
            }
        });

        iv2 = (ImageView)findViewById(R.id.iv2);

        iv1.setImageResource(R.drawable.circle);
        iv2.setImageResource(R.drawable.circledark);
        ivLogo.setImageResource(R.drawable.ldm);


        /**
         *Setup the DrawerLayout and NavigationView
         */
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view) ;

        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        /**
         * Setup click events on the Navigation View Items.
         */

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();



                if (menuItem.getItemId() == R.id.start_screen_menu_home) {

                }
                if (menuItem.getItemId() == R.id.start_screen_menu_icx) {

                }

                if (menuItem.getItemId() == R.id.start_screen_menu_oget) {

                    OGetFragment clubsAndChaptersFragment = new OGetFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.start_screen_content_main,clubsAndChaptersFragment).addToBackStack("Add").commit();

                }
                if (menuItem.getItemId() == R.id.start_screen_menu_expansions) {

                }
                if (menuItem.getItemId() == R.id.start_screen_menu_about_us) {

                } if (menuItem.getItemId() == R.id.start_screen_menu_login) {

                    Intent i = new Intent(StartActivity.this,ActivityLogin.class);
                    startActivity(i);

                }



                return false;
            }

        });

        /**
         * Setup Drawer Toggle of the Toolbar
         */

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setVisibility(View.GONE);

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, mToolbar,R.string.app_name,R.string.app_name);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

        ivHamburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0)
                {

                    iv1.setImageResource(R.drawable.circle);
                    iv2.setImageResource(R.drawable.circledark);
                    ivLogo.setImageResource(R.drawable.ldm);
                    ivLogo.setVisibility(View.INVISIBLE);
                    ivLogo.setAnimation(animAlpha);
                    animAlpha.start();
                    ivLogo.setVisibility(View.VISIBLE);

                }
                else if(position==1) {


                    iv1.setImageResource(R.drawable.circledark);
                    iv2.setImageResource(R.drawable.circle);
                    ivLogo.setImageResource(R.drawable.aiesec_vision);
                    ivLogo.setVisibility(View.INVISIBLE);
                    ivLogo.setAnimation(animAlpha);
                    animAlpha.start();
                    ivLogo.setVisibility(View.VISIBLE);


                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if(position==0)
            {
                StartActivityFragment1 obf1 = new StartActivityFragment1();
                return obf1;
            }
            else if(position==1)
            {

                StartActivityFragment2 obf2 = new StartActivityFragment2();
                return obf2;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
