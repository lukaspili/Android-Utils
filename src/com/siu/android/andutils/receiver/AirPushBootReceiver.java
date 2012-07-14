package com.siu.android.andutils.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.airpush.android.Airpush;
import com.siu.android.andutils.util.AndroidResourceUtils;

/**
 * @author Lukasz Piliszczuk <lukasz.pili AT gmail.com>
 */
public class AirPushBootReceiver extends BroadcastReceiver {

    private static final String APP = "ads_airpush_app";
    private static final String API = "ads_airpush_api";
    private static final String DEBUG = "ads_airpush_debug";

    public void onReceive(Context context, Intent intent) {
        String appId = context.getString(AndroidResourceUtils.getResourceId(context, APP, "string"));
        String apiKey = context.getString(AndroidResourceUtils.getResourceId(context, API, "string"));

        boolean debug = false;
        try {
            debug = context.getResources().getBoolean(AndroidResourceUtils.getResourceId(context, DEBUG, "bool"));
        } catch (RuntimeException e) {
            Log.d(AirPushBootReceiver.class.getName(), "ads_airpush_debug resource not found, ignoring");
        }

        new Airpush(context, appId, apiKey, debug, true, false);
    }
}