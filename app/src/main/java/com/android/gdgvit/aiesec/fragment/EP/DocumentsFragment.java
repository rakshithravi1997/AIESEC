package com.android.gdgvit.aiesec.fragment.EP;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.android.gdgvit.aiesec.R;
import com.android.gdgvit.aiesec.activity.FileSelection.FileSelectionActivity;
import com.android.gdgvit.aiesec.utility.AppDetails;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;


/**
 * Created by Shuvam Ghosh on 3/29/2017.
 */

public class DocumentsFragment extends Fragment {


    private Button btnUpload;
    private String TAG = "The tag";
    private String tokenStr = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6Im5pc2hhbnQubmlqYWd1bmE4QGFpZXNlYy5uZXQiLCJ0aW1lIjoiMjMtMDMtMjAxNyAwNTozOCBQTSJ9.D3_yki5HlFdwzOcB2IBqaT65SA5mg2GlXFQpZ_MncxE";
    public static final int RequestPermissionCode = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;

        root = inflater.inflate(R.layout.fragment_document, container, false);
        init(root);
        return root;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RequestPermissionCode:
                if (grantResults.length> 0) {
                    boolean StoragePermission = grantResults[0] ==
                            PackageManager.PERMISSION_GRANTED;
                    boolean RecordPermission = grantResults[1] ==
                            PackageManager.PERMISSION_GRANTED;

                    if (StoragePermission && RecordPermission) {
                        Toast.makeText(getContext(), "Permission Granted",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(),"Permission Denied",Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }
    private void init(View root) {

        btnUpload = (Button) root.findViewById(R.id.btnUpload);

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(checkPermission()) {
                    Intent intent = new Intent(getContext(), FileSelectionActivity.class);
                    startActivity(intent);
                }
                else
                {
                    requestPermission();
                }
            }
        });
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(getActivity(), new
                String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, RequestPermissionCode);
    }

    public boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getContext(),
                WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getContext(),
                READ_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED &&
                result1 == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onResume() {
        super.onResume();
        final AppDetails globalVariable = (AppDetails)getActivity().getApplicationContext();
        if (globalVariable.getFilesLocations().size() == 0) {

        } else {
            Log.d("First file location is:", globalVariable.getFilesLocations().get(0).toString());
            Uri external = Uri.fromFile(globalVariable.getFilesLocations().get(0));
            final File file = new File(String.valueOf(globalVariable.getFilesLocations().get(0)));

            Log.d("File Uri",""+external);
            uploadFile(file);
        }
    }


    public void uploadFile(File file1) {

       // new GetWeatherTask(textView).execute(url);
        new UploadFile().execute();

    }

    private class UploadFile extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {

            StringBuilder s = new StringBuilder();

            try {
                final AppDetails globalVariable = (AppDetails)getActivity().getApplicationContext();
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost postRequest = new HttpPost(
                        "http://139.59.62.236:8000/ep/uploads");
                File file = globalVariable.getFilesLocations().get(0);
                FileBody bin = new FileBody(file);
                MultipartEntity reqEntity = new MultipartEntity(
                        HttpMultipartMode.BROWSER_COMPATIBLE);
                reqEntity.addPart("token", new StringBody(tokenStr));
                reqEntity.addPart("file", bin);
                postRequest.setEntity(reqEntity);
                HttpResponse response = httpClient.execute(postRequest);
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        response.getEntity().getContent(), "UTF-8"));
                String sResponse;


                while ((sResponse = reader.readLine()) != null) {
                    s = s.append(sResponse);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
            return s.toString();
        }

        @Override
        protected void onPostExecute(String temp) {
            Toast.makeText(getContext(), "Upload Successful", Toast.LENGTH_SHORT).show();
            Log.d("Upload Response",temp);
        }
    }
}
