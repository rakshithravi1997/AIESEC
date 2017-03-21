package com.android.gdgvit.aiesec.fragment.StartScreenFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.gdgvit.aiesec.R;

/**
 * Created by Shuvam Ghosh on 1/26/2017.
 */

public class StartActivityFragment1 extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;
        root = inflater.inflate(R.layout.fragment_start_activity1,container,false);
        return root;
    }
}
