package com.siu.android.andutils.http;

import android.util.Log;
import ch.boye.httpclientandroidlib.Header;
import ch.boye.httpclientandroidlib.HttpResponse;
import ch.boye.httpclientandroidlib.NameValuePair;
import ch.boye.httpclientandroidlib.client.HttpClient;
import ch.boye.httpclientandroidlib.client.entity.UrlEncodedFormEntity;
import ch.boye.httpclientandroidlib.client.methods.*;
import ch.boye.httpclientandroidlib.impl.client.DefaultHttpClient;
import ch.boye.httpclientandroidlib.message.BasicHeader;
import ch.boye.httpclientandroidlib.message.BasicNameValuePair;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Lukasz Piliszczuk <lukasz.pili AT gmail.com>
 */
public class SimpleHttpRequest {

    private String url;
    private String responseCharset;
    private Method method;
    private List<NameValuePair> params;
    private List<Header> headers;

    public HttpResponse request() {
        HttpClient client = new DefaultHttpClient();

        Log.d(getClass().getName(), "Connection " + method + " opened to : " + url);
        long time = System.currentTimeMillis();

        try {
            HttpRequestBase request;

            switch (method) {
                case GET:
                    request = new HttpGet(url);
                    break;

                case POST:
                    HttpPost post = new HttpPost(url);
                    if (null != params) {
                        post.setEntity(new UrlEncodedFormEntity(params));
                    }
                    request = post;
                    break;

                case PUT:
                    HttpPut put = new HttpPut(url);
                    if (null != params) {
                        put.setEntity(new UrlEncodedFormEntity(params));
                    }
                    request = put;
                    break;

                case DELETE:
                    request = new HttpDelete(url);
                    break;

                default:
                    return null;
            }

            if (null != headers) {
                for (Iterator<Header> it = headers.iterator(); it.hasNext(); ) {
                    request.addHeader(it.next());
                }
            }

            return client.execute(request);

        } catch (Exception e) {
            Log.e(getClass().getName(), "Error in " + method + " to " + url, e);
            return null;
        } finally {
            Log.d(getClass().getName(), "Finish in " + (System.currentTimeMillis() - time) + " ms");
        }
    }

    public String requestAsString() {
        HttpResponse response = request();
        if (null == response) {
            return null;
        }

        InputStream is = null;

        try {
            is = response.getEntity().getContent();

            if (null != responseCharset) {
                return IOUtils.toString(is, Charset.forName(responseCharset));
            } else {
                return IOUtils.toString(is);
            }
        } catch (Exception e) {
            Log.e(getClass().getName(), "Error reading stream", e);
            return null;
        } finally {
            if (null != is) {
                IOUtils.closeQuietly(is);
            }
        }
    }

    public static class Builder {
        private SimpleHttpRequest instance;

        public Builder() {
            instance = new SimpleHttpRequest();
        }

        public Builder url(String url) {
            instance.url = url;
            return this;
        }

        public Builder requestMethod(Method method) {
            instance.method = method;
            return this;
        }

        public Builder requestParam(String name, String value) {
            if (null == instance.params) {
                instance.params = new ArrayList<NameValuePair>();
            }

            instance.params.add(new BasicNameValuePair(name, value));
            return this;
        }

        public Builder requestHeader(String name, String value) {
            if (null == instance.headers) {
                instance.headers = new ArrayList<Header>();
            }

            instance.headers.add(new BasicHeader(name, value));
            return this;
        }

        public Builder responseCharset(String responseCharset) {
            instance.responseCharset = responseCharset;
            return this;
        }

        public SimpleHttpRequest build() {
            return instance;
        }
    }

    public static enum Method {
        GET, POST, PUT, DELETE
    }
}
