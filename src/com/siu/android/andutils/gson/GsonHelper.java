package com.siu.android.andutils.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Lukasz Piliszczuk <lukasz.pili AT gmail.com>
 */
public class GsonHelper {

    private static Gson gson;

    protected void configure(GsonBuilder builder) {
    }

    public Gson getGson() {
        if (null == gson) {
            GsonBuilder builder = new GsonBuilder();
            configure(builder);
            gson = builder.create();
        }

        return gson;
    }
}
