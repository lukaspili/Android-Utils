package com.siu.android.andutils.ads;

import android.content.Context;
import android.util.Log;
import com.airpush.android.Airpush;
import com.siu.android.andutils.util.AndroidResourceUtils;

/**
 * @author Lukasz Piliszczuk <lukasz.pili AT gmail.com>
 */
public class AirPushHelper {

    private static final String APP = "ads_airpush_app";
    private static final String API = "ads_airpush_api";
    private static final String DEBUG = "ads_airpush_debug";
    private static final String ICONS = "ads_airpush_icons";

    public static void init(Context context) {
        String appId = context.getString(AndroidResourceUtils.getResourceId(context, APP, "string"));
        String apiKey = context.getString(AndroidResourceUtils.getResourceId(context, API, "string"));
        boolean icons = context.getResources().getBoolean(AndroidResourceUtils.getResourceId(context, ICONS, "bool"));

        boolean debug = false;
        try {
            debug = context.getResources().getBoolean(AndroidResourceUtils.getResourceId(context, DEBUG, "bool"));
        } catch (RuntimeException e) {
            Log.d(AirPushHelper.class.getName(), "ads_airpush_debug resource not found, ignoring");
        }

        new Airpush(context, appId, apiKey, debug, true, icons);
    }
}
