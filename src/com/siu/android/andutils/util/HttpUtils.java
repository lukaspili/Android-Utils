package com.siu.android.andutils.util;

import android.util.Log;
import ch.boye.httpclientandroidlib.HttpResponse;
import ch.boye.httpclientandroidlib.NameValuePair;
import ch.boye.httpclientandroidlib.client.HttpClient;
import ch.boye.httpclientandroidlib.client.entity.UrlEncodedFormEntity;
import ch.boye.httpclientandroidlib.client.methods.HttpGet;
import ch.boye.httpclientandroidlib.client.methods.HttpPost;
import ch.boye.httpclientandroidlib.impl.client.DefaultHttpClient;
import ch.boye.httpclientandroidlib.message.BasicNameValuePair;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Lukasz Piliszczuk <lukasz.pili AT gmail.com>
 */
public class HttpUtils {

    public static boolean post(String url, String... params) {
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(params.length / 2);
        for (int i = 0; i < params.length; i++) {
            nameValuePairs.add(new BasicNameValuePair(params[i], params[i + 1]));
        }

        return post(url, nameValuePairs);
    }

    public static boolean post(String url, Map<String, String> params) {
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(params.entrySet().size());
        for (Map.Entry<String, String> e : params.entrySet()) {
            nameValuePairs.add(new BasicNameValuePair(e.getKey(), e.getValue()));
        }

        return post(url, nameValuePairs);
    }

    public static boolean post(String url, List<NameValuePair> nameValuePairs) {
        Log.d(HttpUtils.class.getName(), "Connection POST opened to : " + url);
        long time = System.currentTimeMillis();

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        HttpResponse response;

        try {
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            response = client.execute(new HttpPost(url));
        } catch (Exception e) {
            Log.e(HttpUtils.class.getName(), "Error during downloading : " + e.getMessage());
            return false;
        } finally {
            Log.d(HttpUtils.class.getName(), "Finish in " + (System.currentTimeMillis() - time) + " ms");
        }

        if (response.getStatusLine().getStatusCode() == 200) {
            return true;
        }

        return false;
    }

    public static String get(String url) {
        Log.d(NetworkUtils.class.getName(), "Connection GET opened to : " + url);
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
