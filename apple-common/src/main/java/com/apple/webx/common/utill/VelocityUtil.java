package com.apple.webx.common.utill;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.alibaba.citrus.util.StringUtil;

/**
 * 类VelocityUtil.java的实现描述：TODO 类实现描述
 * 
 * @author Jndong 2014年3月27日 下午4:58:54
 * @author yinjie 2014年4月28日15:26:52
 */
public class VelocityUtil {

	public static final String DEAFAULT_DATE_FORMAT = "yyyy-MM-dd";

	

	public BigDecimal subtract(BigDecimal big1, BigDecimal big2) {
		return big2.subtract(big1);
	}

	/**
	 * 根据大图Key 获取小图key
	 * 
	 * @param key
	 * @return
	 */
	public String thumbnails(String key) {
		if (StringUtil.isBlank(key)) {
			return "";
		} else {
			return key + "?imageView2/2/w/150/h/150/q/100";
		}
	}

	public static String title(String title) {
		if (title != null) {
			title = title.replaceAll(" ", "-");
			title = title.replaceAll(",", "-");
			title = title.replaceAll("\\*", "-");
			title = title.replaceAll("@", "-");
			title = title.replaceAll("!", "-");
			title = title.replaceAll("&", "-");
			title = title.replaceAll("'", "-");
			title = title.replaceAll("~", "-");
			title = title.replaceAll("`", "-");
			title = title.replaceAll("#", "-");
			title = title.replaceAll("%", "-");
			title = title.replaceAll("\"", "-");
			title = title.replaceAll("/", "-");
			if(title.endsWith("-")){
				title = title.substring(0, title.length()-1);
			}
			return "Wholesale-China-"+title;
		}
		return "";
	}
	
	public static String wholesale(String title) {
		return wholesale(title, true);
	}
	
	public static String wholesale(String title ,boolean force){
		if (title != null) {
			title = title.replaceAll(" ", "-");
			title = title.replaceAll(",", "-");
			title = title.replaceAll("\\*", "-");
			title = title.replaceAll("@", "-");
			title = title.replaceAll("!", "-");
			title = title.replaceAll("&", "-");
			title = title.replaceAll("'", "-");
			title = title.replaceAll("~", "-");
			title = title.replaceAll("`", "-");
			title = title.replaceAll("#", "-");
			title = title.replaceAll("%", "-");
			title = title.replaceAll("\"", "-");
			title = title.replaceAll("/", "-");
			
			if(force){
				while(title.endsWith("-")){
					title = title.substring(0, title.length()-1);
					if(title.length()==0){
						break;
					}
				}
				
				char[] src = title.toCharArray();
				StringBuffer sb = new StringBuffer();
				
				for(int i = 0 ; i < src.length ; i ++){
					
					if(src[i] == '-' && i > 0 && src[i-1] == '-'){
						continue;
					}else{
						sb.append(src[i]);
					}
					
				}
				title = sb.toString();
			}
			return title;
		}
		return "";
	}
	
	

	public String thumbnails(String key, Integer width, Integer height) {
		if (StringUtil.isBlank(key)) {
			return "";
		} else {
			int len = key.indexOf(".");
			if (len != -1) {
				String nameKey = key.substring(0, len);
				String suffixKey = key.substring(len, key.length());
				if (width != null && height != null) {
					return nameKey + "_" + width + "*" + height + suffixKey;
				} else {
					return nameKey + "_" + suffixKey;
				}
			}
			return "";
		}
	}

	/**
	 * 日期格式化
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public String formatDate(Date date) {
		return formatDate(date, null);
	}

	/**
	 * 日期格式化
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public String formatDate(Date date, String format) {

		if (date == null) {
			return "";
		}
		if (org.springframework.util.StringUtils.isEmpty(format)) {
			format = DEAFAULT_DATE_FORMAT;
		}
		SimpleDateFormat formater = new SimpleDateFormat(format);
		return formater.format(date);
	}

	/**
	 * 以默认格式获取当前日期
	 * 
	 * @return
	 */
	public String currentDay() {
		return formatDate(new Date(), null);
	}

	/**
	 * 数字格式化
	 * 
	 * @param number
	 * @param pattern
	 * @return
	 */
	public static String formatNumber(Number number, String pattern) {
		if (number == null) {
			number = 0;
		}
		if (org.springframework.util.StringUtils.isEmpty(pattern)) {
			pattern = "#,##0.00";
		}
		DecimalFormat format = new DecimalFormat(pattern);
		return format.format(number);

	}

	/**
	 * 日前格式化
	 * 
	 * @param date
	 * @return
	 */
	public String datetimeDecide(Date date) {
		if (date == null) {
			return formatNumber(new Date().getTime());
		}

		Date now = new Date();
		long l = now.getTime() - date.getTime();
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);

		if (day == 0 && hour == 0 && min == 0) {
			return "刚刚";
		} else if (hour > 0) {
			return hour + "时" + min + "分前";
		} else if (day > 0) {
			return formatDate(date, "yyyy-MM-dd hh:mm:ss");
		}
		return min + "分前";
	}

	/**
	 * 默认数字格式化
	 * 
	 * @param number
	 * @param pattern
	 * @return
	 */
	public String formatNumber(Number number) {
		DecimalFormat format = new DecimalFormat("#,##0.00");
		return format.format(number);

	}

	/**
	 * 默认数字格式化
	 * 
	 * @param number
	 * @param pattern
	 * @return
	 */
	public String formatNumberWithNull(Number number) {
		if (null != number) {
			return formatNumber(number);
		} else {
			return "0.00";
		}

	}

	/**
	 * 字符串非空判断
	 * 
	 * @param str
	 * @return
	 */
	public boolean isNotBlank(String str) {
		if (!StringUtil.isBlank(str)) {
			return true;
		}
		return false;
	}

	/**
	 * 给指定的字符串截取从头开始的指定的长度
	 * 
	 * @param str
	 *            指定的字符串
	 * @param n
	 *            指定的长度
	 * @return string
	 */
	public String substring(String str, int n) {
		if (StringUtil.isBlank(str)) {
			return "";
		}

		int l = str.length();

		if (l < n) {
			return str;
		}

		str = str.substring(0, n);
		return str + "...";
	}

	/**
	 * 遍历枚举对象为List
	 * 
	 * @param n
	 * @return
	 */
	public static List<Enum<?>> enumToList(Enum<?>[] n) {

		List<Enum<?>> list = new LinkedList<Enum<?>>();

		for (Enum<?> e : n) {
			list.add(e);
		}

		return list;
	}
	
	/**
	 * bigDecimal的比较
	 */
	public static int decimalCompare(BigDecimal left,int right){
		BigDecimal val = new BigDecimal(right);
		return left.compareTo(val);
	}
	
	/**
	 * 比较是否超过最大订单价格
	 * -1, 0, or 1 as this input is less than, equal to, or greater than MAX.
	 */
	public static int compareToMax(BigDecimal input){
		return input.compareTo(ConstantUtil.ORDER_MAX_PRICE);
	}
	
	/**
	 * 保留2位数做增加  00->01   01->02
	 */
	public static String plusOne(String input){
		
		if(StringUtil.isBlank(input)){
			return "00";
		}
		
		if(input.length() > 2){
			return "99";
		}
		
		int num = Integer.parseInt(input);
		num ++;
		String result = String.valueOf(num);
		
		if(result.length() > 2 ){
			return "99";
		}
		
		if(result.length() <2 ){
			result = "0" + result;
		}
		
		return result;
		
	}
}
