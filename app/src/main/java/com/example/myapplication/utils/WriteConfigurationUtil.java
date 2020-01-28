package com.example.myapplication.utils;

import android.annotation.TargetApi;
import android.content.Context;

import java.io.FileOutputStream;

public class WriteConfigurationUtil {


    @TargetApi(19)
    public static void writeConfiguration(Context ctx ) {
        try (FileOutputStream openFileOutput =
                     ctx.openFileOutput( "config.txt", Context.MODE_PRIVATE);) {

            openFileOutput.write("This is a test1.".getBytes());
            openFileOutput.write("This is a test2.".getBytes());
        } catch (Exception e) {
            // not handled
        }
    }

}
