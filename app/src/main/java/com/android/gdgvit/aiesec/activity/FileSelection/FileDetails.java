package com.android.gdgvit.aiesec.activity.FileSelection;

import android.app.Application;

/**
 * Created by Shuvam Ghosh on 1/1/2017.
 */

public class FileDetails extends Application {
    String[] filePaths;

    public String[] getFilePaths() {
        return filePaths;
    }

    public void setFilePaths(String[] filePaths) {
        this.filePaths = filePaths;
    }


}
