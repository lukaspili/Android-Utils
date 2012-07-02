package com.siu.android.andutils;

import android.content.Context;

/**
 * @author Lukasz Piliszczuk <lukasz.pili AT gmail.com>
 */
public class Application extends android.app.Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return Application.context;
    }
}
