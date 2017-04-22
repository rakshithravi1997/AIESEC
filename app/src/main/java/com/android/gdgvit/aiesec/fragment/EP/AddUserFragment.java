package com.android.gdgvit.aiesec.fragment.EP;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.gdgvit.aiesec.R;
import com.android.gdgvit.aiesec.activity.Main.ActivityLogin;
import com.android.gdgvit.aiesec.activity.Main.SignUpActivity;
import com.android.gdgvit.aiesec.model.AddUserResponse;
import com.android.gdgvit.aiesec.model.LoginResponse;
import com.android.gdgvit.aiesec.model.SignupResponse;
import com.android.gdgvit.aiesec.rest.ApiClient;
import com.android.gdgvit.aiesec.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Shuvam Ghosh on 4/13/2017.
 */

public class AddUserFragment extends Fragment {


    EditText etUserEmail;
    EditText etAdminEmail;
    Spinner spinner;
    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6Im5pc2hhbnQubmlqYWd1bmE4QGFpZXNlYy5uZXQiLCJ0aW1lIjoiMjMtMDMtMjAxNyAwNTozOCBQTSJ9.D3_yki5HlFdwzOcB2IBqaT65SA5mg2GlXFQpZ_MncxE";
    String body;
    String input;
    Button btnAdd;
    ProgressBar pBar;
    private String BaseUrl = "http://139.59.62.236:8000/ep/";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root;
        root = inflater.inflate(R.layout.fragment_add_user,container,false);
        init(root);
        setinit();
        return root;
    }

    private void setinit() {


        pBar.setVisibility(View.INVISIBLE);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pBar.setVisibility(View.VISIBLE);
                input=spinner.getSelectedItem().toString();

                if(!input.equalsIgnoreCase("Enter your choice"))
                {

                    if(input.equalsIgnoreCase("Execution Body"))
                        body = "eb";
                    else if(input.equalsIgnoreCase("Managament Body"))
                        body = "mb";
                    else if(input.equalsIgnoreCase("General Body"))
                        body = "gb";


                    ApiInterface apiService = ApiClient.getClient(getContext(),BaseUrl).create(ApiInterface.class);
                    Call<AddUserResponse> addUser = apiService.addUser(token, etAdminEmail.getText().toString(), etUserEmail.getText().toString(), body);

                    addUser.enqueue(new Callback<AddUserResponse>() {
                        @Override
                        public void onResponse(Call<AddUserResponse> call, Response<AddUserResponse> response) {

                            if(response.body().getStatus().equalsIgnoreCase("successfull"))
                            {
                                pBar.setVisibility(View.INVISIBLE);
                                Toast.makeText(getContext(),"New user added", Toast.LENGTH_SHORT).show();
                            }
                            else if(response.body().getStatus().equalsIgnoreCase("already _a_member"))
                            {
                                Toast.makeText(getContext(), "Already a member", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<AddUserResponse> call, Throwable t) {

                        }
                    });
                }
                else
                {
                    Toast.makeText(getContext(), "Enter your body Choice", Toast.LENGTH_SHORT).show();
                }


            }
        });



       // ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);
       // Call<AddUserResponse> addUser = apiService.addUser(token,etAdminEmail.getText().toString(),etUserEmail.getText().toString(),body);


    }

    private void init(View root) {

       // token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6Im5pc2hhbnQubmlqYWd1bmE4QGFpZXNlYy5uZXQiLCJ0aW1lIjoiMjMtMDMtMjAxNyAwNTozOCBQTSJ9.D3_yki5HlFdwzOcB2IBqaT65SA5mg2GlXFQpZ_MncxE";

        pBar = (ProgressBar)root.findViewById(R.id.progreeBar);



        btnAdd =(Button) root.findViewById(R.id.vtbAddUser);

        token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6Im5pc2hhbnQubmlqYWd1bmE4QGFpZXNlYy5uZXQiLCJ0aW1lIjoiMjMtMDMtMjAxNyAwNTozOCBQTSJ9.D3_yki5HlFdwzOcB2IBqaT65SA5mg2GlXFQpZ_MncxE";

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
