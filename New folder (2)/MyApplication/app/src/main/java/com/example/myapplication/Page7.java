package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Page7 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner sp, sp2;
    List<String> subCategories = new ArrayList<>( );
    String selected_item, item;
    int i;
    public Button btnp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page7);

        btnp = findViewById(R.id.show_product);
        btnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Page7.this,MainActivity.class);
                startActivity(intent);
            }
        });
        sp = findViewById(R.id.spinner1);
        sp2 = findViewById(R.id.spinner2);

        List<String> categories = new ArrayList<>( );
        databasec g = new databasec(this);

        Cursor t = g.getSpinnerOneinfo( );

        if (t.getCount( ) == 0) {
            Toast.makeText(Page7.this, "no data found", Toast.LENGTH_SHORT).show( );
        }

        while (t.moveToNext( )) {
            categories.add("" + t.getString(3) + "\n");

        }

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, R.layout.list_item, categories);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter1);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener( ) {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                List<String> categories2 = new ArrayList<>( );
                Cursor c = g.getSpinnerTwoinfo(adapterView.getItemAtPosition(i));
                if (c.getCount( ) == 0) {
                    Toast.makeText(Page7.this, "no data found", Toast.LENGTH_SHORT).show( );
                }

                while (c.moveToNext( )) {
                    categories2.add("" + c.getString(5) + "\n");
                    fillSpinner( );

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public  void fillSpinner()
    {
        ArrayAdapter<String> adapter2= new ArrayAdapter<>(this,R.layout.list_item,subCategories);
        adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp2.setAdapter(adapter2);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }




}
