package cn.coselding.flowerms.utils;

import java.security.MessageDigest;

/**
 * Created by 宇强 on 2016/7/13 0013.
 */
public class ServiceUtil {

    /***
     * MD5加码 生成32位md5码
     */
    public static String string2MD5(String inStr) {
        if(inStr==null)return null;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    public static void main(String[] args){
        String s = string2MD5("123456");
        System.out.println("$"+s+"$");
    }
}
