
package com.example.user10.myapplication;
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
import java.util.Scanner;

 class MyThread extends Thread {


    private String name;
    int token;
    public  String res;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        String set_server_url = "http://194.176.114.21:8050/";
        String data = "{\"action\": \"register\", \"nickname\": \"" + this.name + "\"}";

        try {
            URL url = new URL(set_server_url);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true); // setting POST method

            // creating stream for writing request
            OutputStream out = urlConnection.getOutputStream();
            out.write(data.getBytes());

            String result ="";
            Scanner in = new Scanner(urlConnection.getInputStream());

            while (in.hasNext()){
                result+= in.next();
            }

            JSONObject obj = new JSONObject(result);
            this.token = obj.getInt("token");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }


    }}
