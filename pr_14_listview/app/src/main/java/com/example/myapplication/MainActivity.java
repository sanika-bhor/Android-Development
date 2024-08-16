package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    ListView l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String s1[]={"android","java","php","Hadoop","sap","python","ajax","c++","ruby","rails","angular js","javascript","react"};
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,s1);
        l1=findViewById(R.id.list_view);
        l1.setAdapter(adapter);

        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected=s1[position];
                Toast.makeText(MainActivity.this, selected, Toast.LENGTH_SHORT).show();
            }
        });
    }
}