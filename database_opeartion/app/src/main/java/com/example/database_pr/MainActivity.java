package com.example.database_pr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;

import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper myDB;
    //widgets
    private EditText idEdit, nameEdit, emailEdit;

    private Button addButton,  showAllButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHelper(MainActivity.this);

        idEdit = findViewById(R.id.idid);
        nameEdit = findViewById(R.id.name);
        emailEdit = findViewById(R.id.email);
        addButton = findViewById(R.id.addbtn);
        showAllButton = findViewById(R.id.showallbtn);
        addData();

        getAllData();


    }
    public void addData(){
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDB.insertData(nameEdit.getText().toString() , emailEdit.getText().toString());

                if (isInserted){
                    Toast.makeText(MainActivity.this, "Data Inserted...", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(MainActivity.this, "Something went Wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }



    public void getAllData(){
        showAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = myDB.getAllData();
                StringBuffer buffer = new StringBuffer();
                if(cursor.getCount() == 0){
                    showMessage("Data" , "Nothing found");
                    return;
                }
                while (cursor.moveToNext()){
                    buffer.append("ID : " + cursor.getString(0) + "\n");
                    buffer.append("NAME : " + cursor.getString(1) + "\n");
                    buffer.append("EMAIL : " + cursor.getString(2) + "\n\n");
                }
                showMessage("DATA" , buffer.toString());

            }
        });
    }


    public void showMessage(String title , String msg){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();

    }
}







