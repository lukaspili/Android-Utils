package com.siu.android.andutils.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.siu.android.andutils.Application;

/**
 * @author Lukasz Piliszczuk <lukasz.pili AT gmail.com>
 */
public final class NetworkUtils {

    public static boolean isOnline() {
        NetworkInfo networkInfo = ((ConnectivityManager) Application.getContext().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (null == networkInfo || !networkInfo.isConnectedOrConnecting()) {
            Log.d(NetworkUtils.class.getName(), "No network connection");
            return false;
        }

        return true;
    }


}
