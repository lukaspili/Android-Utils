package com.siu.android.andutils.util;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author Lukasz Piliszczuk <lukasz.pili AT gmail.com>
 */
public class CryptoUtils {

    public static String md5Hex(String data) {
        return new String(Hex.encodeHex(DigestUtils.md5(data)));
    }

    public static String shaHex(String data) {
        return new String(Hex.encodeHex(DigestUtils.sha("textToHash")));
    }
}
