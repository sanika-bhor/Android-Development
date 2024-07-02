package com.example.zoom_in_out;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    Button b1 ,b2,b3;
    private float rotationValue = 0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zoomIn();
            }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zoomOut();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float rotateValue = 90f;
                ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(imageView, "rotation", rotationValue, rotationValue + rotateValue);

                rotateAnimator.setDuration(1000);
                rotateAnimator.start();
                rotationValue += rotateValue;
            }
        });


    }

    private void zoomIn() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1.0f, 1.5f,
                1.0f, 1.5f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        scaleAnimation.setDuration(1000);
        scaleAnimation.setFillAfter(true);

        imageView.startAnimation(scaleAnimation);
    }

    private void zoomOut() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1.5f, 1.0f,
                1.5f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        scaleAnimation.setDuration(1000);
        scaleAnimation.setFillAfter(true);

        imageView.startAnimation(scaleAnimation);
    }
}
