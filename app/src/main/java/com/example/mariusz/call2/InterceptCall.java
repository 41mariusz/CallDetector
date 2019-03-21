package com.example.mariusz.call2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class InterceptCall extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        try {
            if(state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_RINGING)) {
                String number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Toast.makeText(context,  "Ringing! " + number, Toast.LENGTH_LONG).show();
            }
            if(state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                Toast.makeText(context, "Recived!", Toast.LENGTH_LONG).show();
            }
            if(state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_IDLE)) {
                Toast.makeText(context, "IDLE!", Toast.LENGTH_LONG).show();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
