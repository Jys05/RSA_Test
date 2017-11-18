package com.example.administrator.rsa_test.util;

import android.util.Base64;


/**
 * Created by Mr.Su on 2017/8/23.
 */

public class Base64Helper {

    public static String encode(byte[] byteArray) {
//        sun.misc.BASE64Encoder base64Encoder = new sun.misc.BASE64Encoder();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    public static byte[] decode(String base64EncodedString) {
        return Base64.decode(base64EncodedString, Base64.DEFAULT);
//        sun.misc.BASE64Decoder base64Decoder = new sun.misc.BASE64Decoder();
//        try {
//            return base64Decoder.decodeBuffer(base64EncodedString);
//        } catch (IOException e) {
//            return null;
//        }
    }
}
