package com.example.sms_send_receive;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    SmsReceiver sms= new SmsReceiver();
    EditText et1,et2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.etPhno);
        et2=findViewById(R.id.etmsg);
        b1=findViewById(R.id.btnSms);
        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.SEND_SMS},100);
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String phno= et1.getText().toString();
                    String msg=et2.getText().toString();
                    SmsManager smsManager= SmsManager.getDefault();
                    smsManager.sendTextMessage(phno,null,msg,null,null);
                    Toast.makeText(MainActivity.this,"Sms sent successfully from: "+phno, Toast.LENGTH_LONG).show();
                }
                catch(Exception e)
                {
                    Toast.makeText(MainActivity.this,"Sms failed to send... try again", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter=new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(sms,filter);
    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(sms);
    }
}