package com.siu.android.andutils.util;

import android.content.Context;

/**
 * @author Lukasz Piliszczuk <lukasz.pili AT gmail.com>
 */
public class AndroidResourceUtils {

    public static int getResourceId(Context context, String key, String type) throws RuntimeException {
        int resource = context.getResources().getIdentifier(key, type, context.getPackageName());

        if (resource == 0) {
            throw new RuntimeException("Missing resource " + key);
        }

        return resource;
    }
}
