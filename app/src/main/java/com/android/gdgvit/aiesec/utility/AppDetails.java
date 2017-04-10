package com.android.gdgvit.aiesec.utility;

import android.app.Application;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Shuvam Ghosh on 3/29/2017.
 */

public class AppDetails extends Application {

    private ArrayList<File> filesLocations = new ArrayList<>();
    public ArrayList<File> getFilesLocations() {
        return filesLocations;
    }

    public void setFilesLocations(ArrayList<File> filesLocations) {
        this.filesLocations = filesLocations;
    }


}
