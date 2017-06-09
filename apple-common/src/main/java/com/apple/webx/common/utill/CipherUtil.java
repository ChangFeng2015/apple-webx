package com.apple.webx.common.utill;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.DataBinder;

import com.alibaba.citrus.util.StringUtil;
import com.apple.webx.web.common.cipher.AESCipher;
import com.apple.webx.web.common.cipher.Cipher;

/***
 * 类CipherUtil.java的实现描述：TODO 提供加解密功能
 * 
 * @author Jndong 2014年3月31日 上午9:22:19
 */
public class CipherUtil {

	public static final String DEFAULT_CIPHER_FIELD_SUFFIX = "CipherText";
	private static final String PASSWORD = "beiaka&s&ssa&$%fa@^s&*(%$---1233";

	private static transient Logger logger = LoggerFactory.getLogger(CipherUtil.class);

	/**
	 * 将字符加密成密文，eg. Long加密，请在action层使用加解密功能
	 * 
	 * @param obj
	 *            必须是基本类型或者String
	 * @return 密文
	 */
	public static String encode(Object obj) {
		if (obj == null) {
			return null;
		}
		checkClass(obj.getClass());
		String valueBeforeEncode = String.valueOf(obj);
		return AESCipher.encrypt(valueBeforeEncode, PASSWORD);
	}

	/**
	 * 将数组中每一项加密成密文，eg. List<Long>加密，请在action层使用加解密功能
	 * 
	 * @param objs
	 *            基础对象(Integer,Long,String等)的List
	 * @return
	 */
	public static List<String> encodeList(List<?> objs) {
		if (objs == null) {
			return null;
		}
		List<String> result = new ArrayList<String>(objs.size());
		for (int i = 0; i < objs.size(); i++) {
			result.add(encode(objs.get(i)));
		}
		return result;
	}

	/**
	 * 将对象加密，会根据对象属性上的注解进行加密，并将该属性置空，请在action层使用加解密功能
	 * 
	 * @param obj
	 *            需要加密的对象，可以是一个普通对象或者List
	 */
	public static void encodeObj(Object obj) {
		if (obj == null) {
			return;
		}
		if (obj instanceof Collection<?>) {
			for (Object o : (Collection<?>) obj) {
				doEncodeObj(o);
			}
		} else
			doEncodeObj(obj);
	}

	/**
	 * 单对象加密，请在action层使用加解密功能
	 * 
	 * @param obj
	 */
	private static void doEncodeObj(Object obj) {
		if (obj == null) {
			return;
		}
		BeanWrapper bean = new BeanWrapperImpl(obj);
		List<Field> allFields = getAllAnnotationsFields(obj.getClass());
		for (Field field : allFields) {
			String fieldName = field.getName();
			String cipherFieldName = getCipherFieldName(field);
			Object valueBeforeEncode = bean.getPropertyValue(fieldName);
			// 当该属性为空时，不进行加密
			if (valueBeforeEncode == null)
				continue;
			bean.setPropertyValue(fieldName, null);
			bean.setPropertyValue(cipherFieldName, encode(valueBeforeEncode));
		}
		List<Field> allObjFields = getAllObjectFields(obj.getClass());
		for (Field field : allObjFields) {
			Object o = null;
			try {
				o = bean.getPropertyValue(field.getName());
			} catch (BeansException e) {
				/*
				 * if (logger.isInfoEnabled()) { logger.info(String.format(
				 * "Can not get field : %s with reason : %s!", field.toString(),
				 * e.getMessage())); }
				 */
			}
			if (o != null) {
				encodeObj(o);
			}
		}
	}

	/**
	 * 获得对象属性
	 * 
	 * @param clazz
	 * @return
	 */
	private static List<Field> getAllObjectFields(Class<?> clazz) {
		List<Field> result = new ArrayList<Field>();
		if (clazz.getSuperclass() != Object.class) {
			// 递归获取父类的属性
			result.addAll(getAllObjectFields(clazz.getSuperclass()));
		}
		// 增加当前类的属性
		for (Field field : clazz.getDeclaredFields()) {
			if (!isPrimitiveClass(field.getType()) && field.getType() != String.class) {
				result.add(field);
			}
		}
		return result;
	}

	/**
	 * 校验该类型能否加密或者解密,只支持普通对象和String，请在action层使用加解密功能
	 * 
	 * @param clazz
	 */

	private static boolean isPrimitiveClass(Class<?> clazz) {
		if (clazz.isPrimitive()) {
			return true;
		}
		try {
			return ((Class<?>) clazz.getField("TYPE").get(null)).isPrimitive();
		} catch (Exception e) {
			return false;
		}
	}

	private static void checkClass(Class<?> requiredType) {
		if (isPrimitiveClass(requiredType) || requiredType == String.class) {
			return;
		}
		// throw new
		// IllegalClassException("Cipher field must be a primitive or String");
	}

	/**
	 * 将对象解密，会根据对象属性上的注解进行解密，并将该密文属性置空，请在action层使用加解密功能
	 * 
	 * @param o
	 *            普通对象或者数组对象
	 */
	public static void decodeObj(Object o) {
		if (o == null) {
			return;
		}
		// 如果是数组类
		if (o instanceof Collection<?>) {
			for (Object obj : (Collection<?>) o) {
				doDecodeObj(obj);
			}
		} else {
			doDecodeObj(o);
		}
	}

	/**
	 * 将字符串解密为String，请在action层使用加解密功能
	 * 
	 * @param str
	 *            要解密的字符串
	 * @return
	 */
	public static String decode(String str) {
		return decode(str, String.class);
	}

	/**
	 * 将字符串解密为需要的类型，只能是基本类型或者String，请在action层使用加解密功能
	 * 
	 * @param str
	 *            要解密的字符串
	 * @param requiredType
	 *            需要的类型，只能是基本类型或者String
	 * @return
	 */
	public static <T> T decode(String str, Class<T> requiredType) {
		if (StringUtil.isBlank(str)) {
			return null;
		}
		checkClass(requiredType);
		DataBinder binder = new DataBinder(null);
		String valueAfertDecode = AESCipher.decrypt(str, PASSWORD);
		return (T) binder.convertIfNecessary(valueAfertDecode, requiredType);
	}

	/**
	 * 将字符串数组解密，请在action层使用加解密功能
	 * 
	 * @param objs
	 *            基础对象(Integer,Long,String等)的List
	 * @param requiredType
	 *            需要的类型，只能是基本类型或者String
	 * @return
	 */
	public static <T> List<T> decodeList(List<String> objs, Class<T> requiredType) {
		if (CollectionUtils.isEmpty(objs)) {
			return null;
		}
		List<T> result = new ArrayList<T>(objs.size());
		for (int i = 0; i < objs.size(); i++) {
			result.add(decode(objs.get(i), requiredType));
		}
		return result;
	}

	/**
	 * 解密单个对象，请在action层使用加解密功能
	 * 
	 * @param obj
	 */
	private static void doDecodeObj(Object obj) {
		if (obj == null) {
			return;
		}
		BeanWrapper bean = new BeanWrapperImpl(obj);
		// 获取对象上的属性(包括父类)
		List<Field> allFields = getAllAnnotationsFields(obj.getClass());
		for (Field field : allFields) {
			String fieldName = field.getName();
			String cipherFieldName = getCipherFieldName(field);
			Object cipherFieldValue = bean.getPropertyValue(cipherFieldName);
			if (cipherFieldValue == null) {
				continue;// 要解密字段为空时，直接跳过
			}
			if (!(cipherFieldValue instanceof String)) {
				throw new IllegalArgumentException(cipherFieldName + " must be a String type");
			}
			bean.setPropertyValue(fieldName, decode((String) cipherFieldValue));
			bean.setPropertyValue(cipherFieldName, null);
		}
		List<Field> allObjFields = getAllObjectFields(obj.getClass());
		for (Field field : allObjFields) {
			Object o = null;
			try {
				o = bean.getPropertyValue(field.getName());
			} catch (BeansException e) {
				if (logger.isInfoEnabled()) {
					logger.info(String.format("Can not get field : %s with reason : %s!", field.toString(), e.getMessage()));
				}
			}
			if (o != null) {
				decodeObj(o);
			}
		}
	}

	/**
	 * 获取加密属性对应的密文属性，请在action层使用加解密功能
	 * 
	 * @param field
	 *            需要加密的属性
	 * @return
	 */
	private static String getCipherFieldName(Field field) {
		Cipher cipher = field.getAnnotation(Cipher.class);
		if (cipher == null)
			throw new IllegalArgumentException(field + " must hava annotation : Cipher");
		if (!StringUtil.isBlank(cipher.value()))
			return cipher.value().trim();
		else
			return field.getName() + DEFAULT_CIPHER_FIELD_SUFFIX;
	}

	/**
	 * 获得class上所有带有Cipher的属性，包括父类上的属性，请在action层使用加解密功能
	 * 
	 * @param clazz
	 * @return
	 */
	private static List<Field> getAllAnnotationsFields(Class<?> clazz) {
		List<Field> result = new ArrayList<Field>();
		if (clazz.getSuperclass() != Object.class) {
			// 递归获取父类的属性
			result.addAll(getAllAnnotationsFields(clazz.getSuperclass()));
		}
		// 增加当前类的属性
		for (Field field : clazz.getDeclaredFields()) {
			Cipher cipher = field.getAnnotation(Cipher.class);
			if (cipher != null)
				result.add(field);
		}
		return result;
	}

}
