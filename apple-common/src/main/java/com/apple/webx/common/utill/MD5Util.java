package com.apple.webx.common.utill;

import org.apache.commons.codec.digest.DigestUtils;


/**
 * 类MD5Util.java的实现描述：MD5加密工具类
 * 
 * @author abacus.li Apr 29, 2014 2:13:13 PM
 */
public class MD5Util {

    /**
     * 进行MD5加密 参数是明文返回是密文, if data is blank return null
     * 
     * @param data
     * @return
     */
    public static String md5Hex(String data) {
        if (com.alibaba.citrus.util.StringUtil.isBlank(data)) {
            return null;
        }
        return DigestUtils.md5Hex(data);
    }

}
