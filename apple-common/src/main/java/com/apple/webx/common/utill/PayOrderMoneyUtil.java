package com.apple.webx.common.utill;

import java.util.Date;

/**
 * 支付订单工具类
 * 
 * @author Jndong
 *
 */
public class PayOrderMoneyUtil {

	/**
	 * 生成支付金额明细主键
	 * 
	 * @return
	 */
	public static synchronized Long uid() {
		return Long.parseLong(FileUtil.DATE_FORMAT.format(new Date()));
	}
}
