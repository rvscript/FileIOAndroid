package com.example.rv193.fileio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rv193.fileio.FileRWApplication.FileRWApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    String Message;
    //FileReaderWriter fileRW;

    @Inject
    FileReaderWriter fileRW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((FileRWApplication) getApplication()).getAppComponent().inject(this);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        textView.setVisibility(View.GONE);
        textView.setVerticalScrollBarEnabled(true);
        fileRW = new FileReaderWriter();
    }

    public void writeMessage(View view) {
        //write to file
        Message = editText.getText().toString();
        fileRW.fileWriter(getApplicationContext(), Message);
        editText.setText("");
    }

    public void readMessage(View view) {
       //read from file

        textView.setText(fileRW.fileReader(getApplicationContext()));
        textView.setVisibility(View.VISIBLE);
    }

}
