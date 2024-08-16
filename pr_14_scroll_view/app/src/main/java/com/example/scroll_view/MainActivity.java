package com.example.scroll_view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Correctly initialize the TextView and Button
        t1 = findViewById(R.id.tf1);
        b1 = findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText("Government Polytechnic, Awasari(khurd) is one of newly established institute in Maharashtra state in the academic year 2008-09 by Higher & Technical Education Department, Government of Maharashtra to impart technical education and inculcate technical skills among rural and tribal masses for their sustainable development making them competent to be entrepreneurs so that they will provide effective and efficient services to the society. The aim of institute is to create technical human resource and entrepreneurs to contribute towards increasing GDP of the nation and to set a model polytechnic. This institute offers the diploma programs in engineering which are affiliated to Maharashtra State Board of Technical Education, Mumbai and recognized by All India Council for Technical Education, New Delhi.");
            }
        });
    }
}
