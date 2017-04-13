package com.android.gdgvit.aiesec.fragment.EP;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.gdgvit.aiesec.R;

/**
 * Created by Shuvam Ghosh on 4/13/2017.
 */

public class AddUserFragment extends Fragment {


    EditText etUserEmail;
    EditText etAdminEmail;
    Spinner spinner;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root;
        root = inflater.inflate(R.layout.fragment_add_user,container,false);
        init(root);
        return root;
    }

    private void init(View root) {

        etUserEmail = (EditText)root.findViewById(R.id.etUserEmail);
        etAdminEmail = (EditText) root.findViewById(R.id.etAdminEmail);
        spinner = (Spinner)root.findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(root.getContext(),
                R.array.admin_choices, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);



    }
}
