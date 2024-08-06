package com.example.activity_life_cycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("oncreate","your activity is created");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ondestroy","your activity is destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("onrestart","your activity is restart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onstart","your activity is started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onstop","your activity is stop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onpause","your activity is pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onresume","your activity is resume");
    }
}
