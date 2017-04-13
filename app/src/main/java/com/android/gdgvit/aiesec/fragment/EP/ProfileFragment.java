package com.android.gdgvit.aiesec.fragment.EP;

import android.content.SharedPreferences;
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
        tvCpf1.setText(spf.getString("cpf1","null"));
        tvCpf2.setText(spf.getString("cpf2","null"));
        tvCpf3.setText(spf.getString("cpf3","null"));
        tvRaisedBy.setText(spf.getString("raisedBy","null"));


    }

    private void init(View root) {


        spf = PreferenceManager.getDefaultSharedPreferences(root.getContext());
        tvName = (TextView)root.findViewById(R.id.tvName);
        tvEmail = (TextView)root.findViewById(R.id.email);
        tvRaisedBy = (TextView)root.findViewById(R.id.tvRaisedby);
        tvCpf1 = (TextView)root.findViewById(R.id.tvCpf1);
        tvCpf2 = (TextView)root.findViewById(R.id.tvCpf2);
        tvCpf3 = (TextView)root.findViewById(R.id.tvCpf3);
        tvContact = (TextView)root.findViewById(R.id.tvContact);

    }
}
