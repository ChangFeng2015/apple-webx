package com.apple.webx.web.common.cipher;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/***
 * 类AESCipher.java的实现描述：TODO 类实现描述 AES加解密
 * 
 * @author Jndong 2014年3月31日 上午9:56:48
 */
public class AESCipher {

	private static String CIPHER_ALGORITHM = "AES";
	private static String DEFAULT_CHARSET = "utf-8";
	private static String SECURE_ALGORITHM = "SHA1PRNG";

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
			if (hex.length() == 1)
				hex = '0' + hex;
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

	public static String encrypt(String content, String password) {
		try {
			Cipher cipher = getCipher(Cipher.ENCRYPT_MODE, password);
			byte[] byteContent = content.getBytes(DEFAULT_CHARSET);
			return parseByte2HexStr(cipher.doFinal(byteContent));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static Cipher getCipher(int opMode, String password) throws Exception {
		KeyGenerator kgen = KeyGenerator.getInstance(CIPHER_ALGORITHM);
		// 指定SecureRandom的算法，防止在Linux上生成不同的秘钥
		SecureRandom secureRandom = SecureRandom.getInstance(SECURE_ALGORITHM);
		secureRandom.setSeed(password.getBytes());
		kgen.init(128, secureRandom);
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, CIPHER_ALGORITHM);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		cipher.init(opMode, key);
		return cipher;// 创建密码器
	}

	public static String decrypt(String content, String password) {
		try {
			Cipher cipher = getCipher(Cipher.DECRYPT_MODE, password);
			byte[] result = cipher.doFinal(parseHexStr2Byte(content));
			return new String(result, DEFAULT_CHARSET);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
