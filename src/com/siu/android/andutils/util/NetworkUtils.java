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

    public static String downloadData(String url) {
        Log.d(NetworkUtils.class.getName(), "Connection opened to : " + url);
        long time = System.currentTimeMillis();

        HttpClient client = new DefaultHttpClient();

        try {
            HttpResponse response = client.execute(new HttpGet(url));
            InputStream in = response.getEntity().getContent();

            try {
                return IOUtils.toString(in);
            } finally {
                in.close();
            }
        } catch (Exception e) {
            Log.e(NetworkUtils.class.getName(), "Error during downloading : " + e.getMessage());
            return null;
        } finally {
            Log.d(NetworkUtils.class.getName(), "Finish in " + (System.currentTimeMillis() - time) + " ms");
        }
    }

    public static URL getUrl(String urlAsString) {
        URL url;
        try {
            url = new URL(urlAsString);
        } catch (MalformedURLException e) {
            Log.w(NetworkUtils.class.getName(), "Invalid format for url : " + urlAsString, e);
            return null;
        }

        return url;
    }
}
