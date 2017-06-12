package com.android.gdgvit.aiesec.fragment.EP;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.gdgvit.aiesec.R;

/**
 * Created by Shuvam Ghosh on 3/29/2017.
 */

public class ProfileFragment extends Fragment {


    private TextView tvName;
    private TextView tvEmail;
    private TextView tvRaisedBy;
    private TextView tvCpf1;
    private TextView tvCpf2;
    private TextView tvCpf3;
    private TextView tvContact;

    private SharedPreferences spf;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;

        root = inflater.inflate(R.layout.fragment_profile,container,false);
        init(root);
        setinit();
        return root;
    }

    private void setinit() {

        tvName.setText(spf.getString("name","null"));
        tvEmail.setText(spf.getString("email","null"));
        tvContact.setText(spf.getString("contact","null"));
        tvCpf1.setText("1. "+spf.getString("cpf1","null"));
        tvCpf2.setText("2. "+spf.getString("cpf2","null"));
        tvCpf3.setText("3. "+spf.getString("cpf3","null"));
        tvRaisedBy.setText(spf.getString("raisedBy","null"));

    }

    private void init(View root) {


        Typeface font = Typeface.createFromAsset(getResources().getAssets(), "tahoma.ttf");
        spf = PreferenceManager.getDefaultSharedPreferences(root.getContext());
        tvName = (TextView)root.findViewById(R.id.tvName);
        tvName.setTypeface(font);

        tvEmail = (TextView)root.findViewById(R.id.tvEmail);
        tvEmail.setTypeface(font);

        tvRaisedBy = (TextView)root.findViewById(R.id.tvRaisedBy);
        tvRaisedBy.setTypeface(font);

        tvCpf1 = (TextView)root.findViewById(R.id.tvCpf1);
        tvCpf1.setTypeface(font);

        tvCpf2 = (TextView)root.findViewById(R.id.tvCpf2);
        tvCpf2.setTypeface(font);

        tvCpf3 = (TextView)root.findViewById(R.id.tvCpf3);
        tvCpf3.setTypeface(font);

        tvContact = (TextView)root.findViewById(R.id.tvContact);
        tvContact.setTypeface(font);

    }
}
