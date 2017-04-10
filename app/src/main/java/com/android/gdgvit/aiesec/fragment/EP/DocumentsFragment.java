package com.android.gdgvit.aiesec.fragment.EP;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.android.gdgvit.aiesec.R;
import com.android.gdgvit.aiesec.activity.FileSelection.FileSelectionActivity;
import com.android.gdgvit.aiesec.activity.Main.ActivityLogin;
import com.android.gdgvit.aiesec.rest.ApiClient;
import com.android.gdgvit.aiesec.rest.ApiInterface;
import com.android.gdgvit.aiesec.utility.AppDetails;
import com.android.gdgvit.aiesec.utility.FileUtils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Shuvam Ghosh on 3/29/2017.
 */

public class DocumentsFragment extends Fragment {


    private Button btnUpload;
    private String TAG = "The tag";
    private String tokenStr ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6Im5pc2hhbnQubmlqYWd1bmE4QGFpZXNlYy5uZXQiLCJ0aW1lIjoiMjMtMDMtMjAxNyAwNTozOCBQTSJ9.D3_yki5HlFdwzOcB2IBqaT65SA5mg2GlXFQpZ_MncxE";
    private HttpEntity resEntity;
    private String access_token="3ea9f672";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;

        root = inflater.inflate(R.layout.fragment_document,container,false);
        init(root);
        return root;
    }

    private void init(View root) {

        btnUpload = (Button)root.findViewById(R.id.btnUpload);

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Do upload process
                Intent intent = new Intent(getContext(),FileSelectionActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();

        final AppDetails globalVariable = (AppDetails) getActivity().getApplicationContext();

        // Get name and email from global/application context
        if (globalVariable.getFilesLocations().size() == 0) {
            Toast.makeText(globalVariable, "First time", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Not first time, and the size is:" + globalVariable.getFilesLocations().size(), Toast.LENGTH_SHORT).show();


            Log.d("First file location is:", globalVariable.getFilesLocations().get(0).toString());
            // Uri external = Uri.fromFile(globalVariable.getFilesLocations().get(0));
            final File file = new File(String.valueOf(globalVariable.getFilesLocations().get(0)));


            uploadFile(file);
            // Log.d("Uri is",""+external);
        }
    }





    public void uploadFile(File file) {

        InputStream in = null;
        try {
            in = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] buf = new byte[0];
        try {
            buf = new byte[in.available()];
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            while (in.read(buf) != -1) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        RequestBody requestBodyByte = RequestBody
                .create(MediaType.parse("application/octet-stream"), buf);
        String content_disposition = "13a29d8990eafc99124d0697733cba57";


        ApiInterface apiService = ApiClient.getClient(getContext()).create(ApiInterface.class);

        //GET parameters
        Map<String, String> params = new HashMap<String, String>();
        params.put("token", tokenStr);
        /*params.put("noteUUID", noteUUID);
        params.put("attachmentUUID", attachmentUUID);
        params.put("noteType", noteType);
        params.put("modifiedTime", modifiedTime);*/

        Call<ResponseBody> call = apiService.upload(access_token, content_disposition, requestBodyByte, params);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(getContext(), "Response got", Toast.LENGTH_SHORT).show();
                Log.d("UploadResponse",response.toString());
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
            }
        });

}


   /* @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLEY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            image.setImageURI(data.getData()); // set image to image view
            try{
                // Get real path to make File
                realUri = Uri.parse(getRealPathFromURI(data.getData()));
                Log.d(TAG,"Image path :- "+realUri);
            }
            catch (Exception e){
                Log.e(TAG,e.getMessage());
            }


        }



    }*/

    /*public String getRealPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        assert cursor != null;
        if(cursor.moveToFirst()){;
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }*/

    @NonNull
    private RequestBody createPartFromString(String descriptionString) {
        return RequestBody.create(
                okhttp3.MultipartBody.FORM, descriptionString);
    }

    @NonNull
    private MultipartBody.Part prepareFilePart(String partName, Uri fileUri) {
        // https://github.com/iPaulPro/aFileChooser/blob/master/aFileChooser/src/com/ipaulpro/afilechooser/utils/FileUtils.java
        // use the FileUtils to get the actual file by uri
        File file = FileUtils.getFile(getContext(), fileUri);

        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(
                        MediaType.parse(getContext().getContentResolver().getType(fileUri)),
                        file
                );

        // MultipartBody.Part is used to send also the actual file name
        return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
    }

}
