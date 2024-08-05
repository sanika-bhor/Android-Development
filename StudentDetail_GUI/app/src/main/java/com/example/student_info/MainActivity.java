package com.example.student_info;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText age;
    EditText marks;

    Button submit;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.editTextText2);
        age=findViewById(R.id.editTextText3);
        marks=findViewById(R.id.editTextText4);
        submit=findViewById(R.id.button);
        result=findViewById(R.id.textView);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Sname=name.getText().toString();
                String Sage=age.getText().toString();
                String Smarks=marks.getText().toString();

                result.setText("*your details*"+"\n\nName:   "+Sname+"\nAge:     "+Sage+"\nMarks:    "+Smarks);
            }
        });

    }
}