package com.example.user10.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent i = getIntent();
        int token = i.getIntExtra("token",-1);
        if(token == -1){
            System.out.println("Ошибка");
        }

    }

}
