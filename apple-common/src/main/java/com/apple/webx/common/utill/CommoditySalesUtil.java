package com.apple.webx.common.utill;

import java.util.Date;

public class CommoditySalesUtil {

	
	/**
	 * 生成支付金额明细主键
	 * 
	 * @return
	 */
	public static synchronized Long uid() {
		return Long.parseLong(10 + FileUtil.DATE_FORMAT.format(new Date()));
	}
}
