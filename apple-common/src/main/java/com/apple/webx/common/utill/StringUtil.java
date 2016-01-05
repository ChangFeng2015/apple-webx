package com.apple.webx.common.utill;

import org.apache.commons.codec.binary.StringUtils;

/**
 * 类StringUtil.java的实现描述：TODO 类实现描述 String的util
 * 
 * @author Jndong 2014年3月31日 上午9:26:42
 */
public class StringUtil extends StringUtils {

    private StringUtil(){
    }

    /**
     * 将byte数组转化为16进制
     * 
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte[] buf) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) hex = '0' + hex;
            sb.append(hex);
        }
        return sb.toString();
    }

    public static byte[] parseHexStr2Byte(String hexStr) {
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int strIndex = i << 1;
            int high = Integer.parseInt(hexStr.substring(strIndex, strIndex + 1), 16);
            int low = Integer.parseInt(hexStr.substring(strIndex + 1, strIndex + 2), 16);
            result[i] = (byte) ((high << 4) + low);
        }
        return result;
    }
    
    /**
     * 判断一个字符是Ascill字符还是其它字符（如汉，日，韩文字符）
     *
     * @param char
     *             c, 需要判断的字符
     * @return boolean, 返回true,Ascill字符
    */
   public static boolean isLetter(char c) {
       int k = 0x80;
       return c / k == 0 ? true : false;
    }

   /**
     * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1
     *
     * @param String
     *             s ,需要得到长度的字符串
     * @return int, 得到的字符串长度
    */
   public static int lengths(String s) {
       if (s == null)
           return 0;
       char[] c = s.toCharArray();
       int len = 0;
       for (int i = 0; i < c.length; i++) {
            len++;
           if (!isLetter(c[i])) {
                len++;
            }
        }
       return len;
    }

   /**
     * 截取一段字符的长度,不区分中英文,如果数字不正好，则少取一个字符位
     *
     * @author patriotlml
     * @param String
     *             origin, 原始字符串
     * @param int
     *             len, 截取长度(一个汉字长度按2算的)
     * @return String, 返回的字符串
    */
   public static String substring(String origin, int len) {
       if (origin == null || origin.equals("")||len<1)
           return "";
       byte[] strByte = new byte[len];
       if (len > lengths(origin)){
           return origin;
       }
        System.arraycopy(origin.getBytes(), 0, strByte, 0, len);
       int count = 0;
       for (int i = 0; i < len; i++) {
           int value = (int) strByte[i];
           if (value < 0) {
                count++;
            }
        }
       if (count % 2 != 0) {
            //len = (len == 1) ? ++len : --len;
            --len;
        }
       return new String(strByte, 0, len);
    }

}
