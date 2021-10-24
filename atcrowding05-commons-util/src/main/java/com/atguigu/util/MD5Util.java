package com.atguigu.util;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GaoUP
 * @Date 2021/10/12 21:35
 * @Version 1.0
 */
public class MD5Util {

    public static String md5(String source){
        if (source==null||source.length()==0){
                new RuntimeException(CrowdConstant.MESSAGE_LOGIN_PASSWORD_FAILED);
        }
        String algorithm ="md5";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            byte[] input = source.getBytes();
//          进行编码
            byte[] out = messageDigest.digest(input);
            int signNate=1;
            BigInteger bigInteger = new BigInteger(signNate, out);
            int radix=16;
            String encoding = bigInteger.toString(radix).toUpperCase();
            return encoding;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
