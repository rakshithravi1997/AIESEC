package com.android.gdgvit.aiesec.adapter;

import android.media.ExifInterface;
import android.os.AsyncTask;
import android.util.Config;
import android.util.Log;

import java.io.File;
import java.io.IOException;

private class UploadFileToServer extends AsyncTask<Void, Integer, String> {
        /*@Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params) {
            return uploadFile();
        }

        private String uploadFile() {
            String responseString = null;
            Log.d("Log", "File path" + opFilePath);
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(Config.FILE_UPLOAD_URL);
            try {
                AndroidMultiPartEntity entity = new AndroidMultiPartEntity(
                        new AndroidMultiPartEntity.ProgressListener() {

                           @Override
                          public void transferred(long num) {
                                publishProgress((int) ((num / (float) totalSize) * 100));
                            }
                        });
                ExifInterface newIntef = new ExifInterface(opFilePath);
                newIntef.setAttribute(ExifInterface.TAG_ORIENTATION,String.valueOf(2));
                File file = new File(opFilePath);
                entity.addPart("pic", new FileBody(file));
                totalSize = entity.getContentLength();
                httppost.setEntity(entity);

                // Making server call
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity r_entity = response.getEntity();


                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == 200) {
                    // Server response
                    responseString = EntityUtils.toString(r_entity);
                    Log.d("Log", responseString);
                } else {
                    responseString = "Error occurred! Http Status Code: "
                            + statusCode + " -> " + response.getStatusLine().getReasonPhrase();
                    Log.d("Log", responseString);
                }

            } catch (ClientProtocolException e) {
                responseString = e.toString();
            } catch (IOException e) {
                responseString = e.toString();
            }

            return responseString;    
        }*/
    }