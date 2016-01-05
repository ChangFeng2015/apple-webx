package com.apple.webx.common.utill;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IntegerIdUtil {

	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyMMddHHss");
	public static final SimpleDateFormat DATE_FORMAT_SIMPLE = new SimpleDateFormat("yyMddHHSSS");

	/**
	 * 生成 integer 类型主键
	 * 
	 * @return
	 */
	public static synchronized int createId() {
		Random random = new Random(1000);
		return Integer.parseInt(IntegerIdUtil.DATE_FORMAT.format(new Date())) + random.nextInt();
	}
	public static synchronized int createNewId() {
		return Integer.parseInt(IntegerIdUtil.DATE_FORMAT_SIMPLE.format(new Date()));
	}
}
