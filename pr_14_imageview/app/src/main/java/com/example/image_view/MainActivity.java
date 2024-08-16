package com.example.image_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    ImageView i1;
    int count=1;
    String img[]={"clg","clg1","clg2","clg3","clg4","clg5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        i1=findViewById(R.id.imageView);

//        previous image
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
               if(count==1)
               {
                   i1.setImageResource(R.drawable.clg1);
                   count=6;
               }
               if(count==2)
               {
                   i1.setImageResource(R.drawable.clg2);
               }
               if(count==3)
               {
                   i1.setImageResource(R.drawable.clg3);
               }
               if(count==4)
               {
                   i1.setImageResource(R.drawable.clg4);
               }
               if(count==5)
               {
                   i1.setImageResource(R.drawable.clg5);
               }
                if(count==6)
                {
                    i1.setImageResource(R.drawable.clg6);

                }

            }
        });


        //        next image
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;

                if(count==1)
                {
                    i1.setImageResource(R.drawable.clg1);
                }
                if(count==2)
                {
                    i1.setImageResource(R.drawable.clg2);
                }
                if(count==3)
                {
                    i1.setImageResource(R.drawable.clg3);
                }
                if(count==4)
                {
                    i1.setImageResource(R.drawable.clg4);
                }
                if(count==5)
                {
                    i1.setImageResource(R.drawable.clg5);
                }
                if(count==6)
                {
                    i1.setImageResource(R.drawable.clg6);
                    count=0;
                }
//                count++;

            }
        });
    }
}