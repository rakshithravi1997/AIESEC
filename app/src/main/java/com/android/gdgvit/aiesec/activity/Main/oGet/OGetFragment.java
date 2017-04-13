package com.android.gdgvit.aiesec.activity.Main.oGet;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.gdgvit.aiesec.R;

/**
 * Created by Shuvam Ghosh on 3/27/2017.
 */

public class OGetFragment extends Fragment {


    private ViewPager vp;
    private CustomPagerAdapter adapter;
    int[] mResources = {
            R.drawable.ogt1,
            R.drawable.ogt2,
            R.drawable.ogt3,
            R.drawable.ogt4,
            R.drawable.ogt5,
            R.drawable.ogt6
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;
        root = inflater.inflate(R.layout.fragment_oget,container,false);
        init(root);
        return root;
 }

    private void init(View root) {

        vp = (ViewPager)root.findViewById(R.id.vpOgt);
        adapter = new CustomPagerAdapter(root.getContext());
        vp.setAdapter(adapter);
    }

    class CustomPagerAdapter extends PagerAdapter {

        Context mContext;
        LayoutInflater mLayoutInflater;

        public CustomPagerAdapter(Context context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mResources.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.fragment_oget_pager_item, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageView.setImageResource(mResources[position]);

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }
}
