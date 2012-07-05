package com.siu.android.andutils.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import ch.boye.httpclientandroidlib.HttpResponse;
import ch.boye.httpclientandroidlib.client.HttpClient;
import ch.boye.httpclientandroidlib.client.methods.HttpGet;
import ch.boye.httpclientandroidlib.impl.client.DefaultHttpClient;
import com.siu.android.andutils.Application;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

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
