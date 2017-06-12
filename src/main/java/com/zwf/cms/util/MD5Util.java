package com.zwf.cms.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by user on 2017/3/5.
 */
public class MD5Util {
    public static String getMD5String(String convertStr) {
        MessageDigest digest;
        try {
             digest = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 algorithm not available.  Fatal (should be in the JDK).");
        }
        try {
            byte[] bytes = digest.digest(convertStr.toString().getBytes("UTF-8"));
            return String.format("%032x", new Object[] { new BigInteger(1, bytes) }); } catch (UnsupportedEncodingException e) {
        }
        throw new IllegalStateException("UTF-8 encoding not available.  Fatal (should be in the JDK).");
    }

    public static void main(String[] args) {
        System.out.println(getMD5String("123456"));
    }
}
