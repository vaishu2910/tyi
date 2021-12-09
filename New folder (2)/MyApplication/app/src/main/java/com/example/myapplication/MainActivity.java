package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ListView lvs;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3);

        lvs=findViewById(R.id.lv);
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listItems);
        setListAdapter(adapter);
        lvs.setOnItemClickListener(this);
        databasec g=new databasec(this);

        Cursor t=g.getinfo();

        if(t.getCount()==0)
        {
            Toast.makeText(MainActivity.this,"no data found",Toast.LENGTH_SHORT).show();
        }

        while (t.moveToNext())
        {
            listItems.add("name::"+t.getString(5)+"\n");
        }


    }

    public void setListAdapter(ArrayAdapter<String> listAdapter) {
        this.listAdapter = listAdapter;
    }

    public ArrayAdapter<String> getListAdapter() {
        return listAdapter;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);

    }
}