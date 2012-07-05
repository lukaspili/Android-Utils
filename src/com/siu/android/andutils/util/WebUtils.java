package com.siu.android.andutils.util;

import android.util.Log;
import android.webkit.WebView;

import java.net.URLEncoder;

/**
 * @author Lukasz Piliszczuk <lukasz.pili AT gmail.com>
 */
public class WebUtils {

    public static final String UTF8 = "utf-8";
    public static final String HTML = "text/html";

    private static final String FAKE_URL = "fake://fuck/android";

    public static String encodeHtml(String content) {
        try {
            return URLEncoder.encode(content, UTF8).replaceAll("\\+", " ");
        } catch (Exception e) {
            Log.e(WebUtils.class.getName(), "Error encoding html in UTF8 : " + e.getMessage());
            return content;
        }
    }

    public static String wrapWithHtml(String content) {
        return "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /></head><body>" +
                content +
                "</body></html>";
    }

    public static void loadToWeview(WebView webView, String content) {
        webView.loadDataWithBaseURL(FAKE_URL, WebUtils.wrapWithHtml(content), WebUtils.HTML, WebUtils.UTF8, "");
    }
}
