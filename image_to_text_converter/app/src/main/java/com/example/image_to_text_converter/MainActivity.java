package com.example.image_to_text_converter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.Activity;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ImageView clear, getimage, copy;
    EditText recgtext;
    Uri imageUri;

    TextRecognizer textRecognizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clear = findViewById(R.id.erase);
        copy = findViewById(R.id.copy);
        getimage = findViewById(R.id.getimg);
        recgtext = findViewById(R.id.recgtext);

        textRecognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);


        getimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(MainActivity.this)
                        .crop()
                        .maxResultSize(1080, 1080)
                        .start(101);
            }
        });


        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = recgtext.getText().toString();

                if (text.isEmpty()) {

                    Toast.makeText(MainActivity.this, "There is no text to copy", Toast.LENGTH_SHORT).show();
                } else {

                    ClipboardManager clipboardManager = (ClipboardManager) getSystemService(MainActivity.this.CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText("Data", recgtext.getText().toString());
                    clipboardManager.setPrimaryClip(clipData);

                    Toast.makeText(MainActivity.this, " text copy to clipboard", Toast.LENGTH_SHORT).show();
                }
            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = recgtext.getText().toString();

                if (text.isEmpty()) {

                    Toast.makeText(MainActivity.this, "There is no text to clear", Toast.LENGTH_SHORT).show();
                } else {

                    recgtext.setText("");
                }
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && requestCode == 101) {

            if (data != null) {

                imageUri = data.getData();

                Toast.makeText(this, "Image selected", Toast.LENGTH_SHORT).show();
                recognizeText();

            } else {

                Toast.makeText(this, "Image not selected", Toast.LENGTH_SHORT).show();

            }
        }
    }

    private void recognizeText() {
        if (imageUri != null) {

            try {
                InputImage inputImage = InputImage.fromFilePath(MainActivity.this, imageUri);

                Task<Text> result = textRecognizer.process(inputImage)
                        .addOnSuccessListener(new OnSuccessListener<Text>() {
                            @Override
                            public void onSuccess(Text text) {
                                // Handle success, e.g., update UI with recognized text
                                String recognizedText = text.getText();
                                recgtext.setText(recognizedText);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Handle failure
                                e.printStackTrace();
                                Toast.makeText(MainActivity.this, "Text recognition failed", Toast.LENGTH_SHORT).show();
                            }
                        });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}