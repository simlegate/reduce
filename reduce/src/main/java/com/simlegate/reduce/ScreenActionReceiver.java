package com.simlegate.reduce;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.net.wifi.WifiManager;

/**
 * Created by simlegate on 13-6-1.
 */
public class ScreenActionReceiver extends BroadcastReceiver {
    private String TAG = "ScreenActionReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {


        String action = intent.getAction();
        WifiManager wifiManager =  (WifiManager) context.getSystemService(Context.WIFI_SERVICE);

        if(Intent.ACTION_SCREEN_ON.equals(action))
        {
            Log.d(TAG, "screen is on...");

            if (!wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(true);
            }

        }

        else if(Intent.ACTION_SCREEN_OFF.equals(action))
        {
            Log.d(TAG, "screen is off...");

            if (wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(false);
            }
        }

        else if(Intent.ACTION_USER_PRESENT.equals(action))
        {
            Log.d(TAG, "screen is unlock...");
        }

    }

    public IntentFilter getFilter(){
        final IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_SCREEN_ON);
        return filter;
    }
}