package com.Hiagodev.StudentMongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
    public  static String decodeParam(String text) throws UnsupportedEncodingException {
        return URLDecoder.decode(text, "UTF-8");
    }
}
