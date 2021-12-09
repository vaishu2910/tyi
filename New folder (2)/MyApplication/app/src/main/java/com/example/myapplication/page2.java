package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class page2 extends AppCompatActivity {
    public Button btn,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        databasec g=new databasec(this);
        SQLiteDatabase db = g.getReadableDatabase();


        btn = (Button) findViewById(R.id.doctor);
        btn2 = (Button) findViewById(R.id.product);
        btn3 = (Button) findViewById(R.id.add_doctor);
        btn4 = (Button) findViewById(R.id.add_product);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(page2.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2= new Intent(page2.this,MainActivity.class);    //here add class name of that page which we expected to open after clicking on this button!!
                startActivity(intent2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3= new Intent(page2.this,MainActivity.class);    //here add class name of that page which we expected to open after clicking on this button!!
                startActivity(intent3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4= new Intent(page2.this,MainActivity.class);    //here add class name of that page which we expected to open after clicking on this button!!
                startActivity(intent4);
            }
        });
    }

}