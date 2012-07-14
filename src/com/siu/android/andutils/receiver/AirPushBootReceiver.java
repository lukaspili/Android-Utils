package com.siu.android.andutils.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.airpush.android.Airpush;
import com.siu.android.andutils.ads.AirPushHelper;
import com.siu.android.andutils.util.AndroidResourceUtils;

/**
 * @author Lukasz Piliszczuk <lukasz.pili AT gmail.com>
 */
public class AirPushBootReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        AirPushHelper.init(context);
    }
}