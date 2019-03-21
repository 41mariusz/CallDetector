package com.example.mariusz.call2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class InterceptCall extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        try {
            if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_RINGING)) {
                String number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

                Toast.makeText(context, "Ringing! " + number + " ## ", Toast.LENGTH_LONG).show();

                Log.d("Ringing: ", "> " + number);
                Log.d("JSON", "why");

            }
            if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                Log.d("Call: ", "Recivied");
            }
            if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_IDLE)) {
                Log.d("Call: ", "IDLE");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

