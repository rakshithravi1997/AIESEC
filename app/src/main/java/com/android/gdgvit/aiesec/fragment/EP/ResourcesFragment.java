package com.android.gdgvit.aiesec.fragment.EP;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.gdgvit.aiesec.R;

/**
 * Created by Shuvam Ghosh on 3/29/2017.
 */

public class ResourcesFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;

        root = inflater.inflate(R.layout.fragment_resources,container,false);
        return root;
    }
}
