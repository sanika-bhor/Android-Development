package com.example.sms_send_receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;
public class SmsReceiver extends BroadcastReceiver {
    SmsReceiver(){}
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
// Retrieve the SMS Messages received
            Object[] sms = (Object[]) bundle.get("pdus");
// For every SMS message received
            for (int i=0; i < sms.length; i++) {
// Convert Object array
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);
                String phone = smsMessage.getOriginatingAddress();
                String message = smsMessage.getMessageBody().toString();
                Toast.makeText(context, "Received from "+ phone + ": " + message, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
