package com.apple.webx.common.utill;

import java.util.Date;
import java.util.Random;

/**
 * 购物车 主键生成器
 */
public class CartUtil {

	/**
	 * 生成支付金额明细主键
	 * 
	 * @return
	 */
	public static synchronized Long uid() {
		return Long.parseLong(10 + FileUtil.DATE_FORMAT.format(new Date()));
	}

	/**
	 * Sku 主键
	 * 
	 * @return
	 */
	public static synchronized Long skuid() {
		Random random = new Random(10);
		return Long.parseLong("10" + FileUtil.DATE_FORMAT.format(new Date())) + random.nextLong();
	}

	public static synchronized Long cid() {
		Random random = new Random(10);
		return Long.parseLong("10" + FileUtil.DATE_FORMAT.format(new Date())) + random.nextLong();
	}
}
