package com.example.user10.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {


    private EditText editText;
    private TextView textView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

    }


    public void onclick(View v) throws IOException, JSONException, InterruptedException {

        String name = editText.getText().toString();
        textView.setText("ds");

           MyThread myThread = new MyThread(name);
           myThread.start();
           myThread.join();

        textView.setText("token: " + myThread.token);

        Intent intent = new Intent(this, Game.class);
        System.out.println(myThread.token);
        intent.putExtra("token", myThread.token);
        startActivity(intent);
        }

}