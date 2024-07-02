package com.example.pr28_login;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    EditText e2;
    Button b1;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        b1 = findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();


                if(s1.equals("") && s2.equals("")){
                    Toast.makeText(MainActivity.this, "text should not be empty please! provide username and password", Toast.LENGTH_SHORT).show();
                }
                else if (s1.length()>=10 && s2.length()>=8) {
                    Toast.makeText(MainActivity.this, "login successful after "+count+" unsuccessful attempt", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "login Unsuccessful", Toast.LENGTH_SHORT).show();
                    count++;
                }


            }
        });


    }
}