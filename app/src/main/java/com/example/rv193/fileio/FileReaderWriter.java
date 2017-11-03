package com.example.rv193.fileio;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.inject.Inject;

import dagger.Provides;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by rv193 on 11/2/2017.
 */

public class FileReaderWriter {
    private String file_name = "hello_file";
    private String Message = "";

    @Inject
    public FileReaderWriter() {
    }

    String fileReader(Context context){
         /*
        1. create a FileInputStream fileInputStream and add our file to it
        2. create an InputStreamReader to read the inputStream and add our FileInputstream to it.
        3. Create a BufferedReader and add our inputStream to it.
        IE. BufferedReader(inputStreamReader(FileInputStreamReader(String FileName);
         */
        String stringBufferTemp = "temp test string";
        try {
            FileInputStream fileInputStream = context.openFileInput(file_name);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            while((Message = bufferedReader.readLine()) != null){

                stringBuffer.append(Message + "\n");
            }
            stringBufferTemp = stringBuffer.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBufferTemp;
    }
    void fileWriter(Context context, String message){
        /*
        1. get information from edit text
        2. Define a file
        3. Create a file output stream
        4. add Message to fileOutputStream
        5. close file output stream
         */
        Message = message;
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(file_name, MODE_PRIVATE);
            fileOutputStream.write(Message.getBytes());
            fileOutputStream.close();
            Toast.makeText(context, "message Saved", Toast
                    .LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
