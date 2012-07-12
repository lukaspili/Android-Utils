package com.siu.android.andutils.util;

import android.util.Log;
import ch.boye.httpclientandroidlib.HttpResponse;
import ch.boye.httpclientandroidlib.NameValuePair;
import ch.boye.httpclientandroidlib.client.HttpClient;
import ch.boye.httpclientandroidlib.client.entity.UrlEncodedFormEntity;
import ch.boye.httpclientandroidlib.client.methods.*;
import ch.boye.httpclientandroidlib.impl.client.DefaultHttpClient;
import ch.boye.httpclientandroidlib.message.BasicNameValuePair;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lukasz Piliszczuk <lukasz.pili AT gmail.com>
 */
public class HttpUtils {

    public static HttpResponse request(String url, HttpMethod method, String... params) {
        List<NameValuePair> nameValuePairs = null;

        if (params.length != 0) {
            nameValuePairs = new ArrayList<NameValuePair>(params.length / 2);
            for (int i = 0; i < params.length; i = i + 2) {
                nameValuePairs.add(new BasicNameValuePair(params[i], params[i + 1]));
            }
        }

        HttpClient client = new DefaultHttpClient();

        Log.d(HttpUtils.class.getName(), "Connection " + method + " opened to : " + url);
        long time = System.currentTimeMillis();

        try {
            HttpRequestBase request;

            switch (method) {
                case GET:
                    request = new HttpGet(url);
                    break;

                case POST:
                    HttpPost post = new HttpPost(url);
                    if (null != nameValuePairs) {
                        post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    }
                    request = post;
                    break;

                case PUT:
                    HttpPut put = new HttpPut(url);
                    if (null != nameValuePairs) {
                        put.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    }
                    request = put;
                    break;

                case DELETE:
                    request = new HttpDelete(url);
                    break;

                default:
                    return null;
            }

            return client.execute(request);

        } catch (Exception e) {
            Log.e(HttpUtils.class.getName(), "Error in " + method, e);
            return null;
        } finally {
            Log.d(HttpUtils.class.getName(), "Finish in " + (System.currentTimeMillis() - time) + " ms");
        }
    }

    public static boolean post(String url, String... params) {
        HttpResponse response = request(url, HttpMethod.POST, params);

        if (null != response && response.getStatusLine().getStatusCode() == 200) {
            return true;
        }

        return false;
    }

    public static String postGetAsString(String url, String... params) {
        return getResponseAsString(request(url, HttpMethod.POST, params));
    }

    public static String get(String url) {
        HttpResponse response = request(url, HttpMethod.GET);

        if (null == response) {
            return null;
        }

        return getResponseAsString(response);
    }

    public static String getResponseAsString(HttpResponse response) {
        if (null == response) {
            return null;
        }

        InputStream in = null;

        try {
            in = response.getEntity().getContent();
            return IOUtils.toString(in);
        } catch (Exception e) {
            Log.e(HttpUtils.class.getName(), "Error reading stream", e);
            return null;
        } finally {
            if (null != in) {
                IOUtils.closeQuietly(in);
            }
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

    public static enum HttpMethod {
        GET, POST, PUT, DELETE
    }
}
