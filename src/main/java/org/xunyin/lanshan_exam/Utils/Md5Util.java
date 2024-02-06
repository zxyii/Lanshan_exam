package org.xunyin.lanshan_exam.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Md5Util {
    protected static char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    protected static MessageDigest messageDigest = null;

    static {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        }catch (NoSuchAlgorithmException noSuchAlgorithmException){
            System.err.println(Md5Util.class.getName() + "初始化失败");
        }
    }
    public static String getMD5String(String s){
        return getMD5String(Arrays.toString(s.getBytes()));
    }
}
