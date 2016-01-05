package com.apple.webx.common.utill;

import java.util.Date;

/**
 * 物流 主键生成器
 * */
public class LogisticsUtil {

	/**
	 * 生成  物流方式/物流服务/运送区域/国家地址主键
	 * 
	 * @return
	 */
	public static synchronized Long logisticId() {
		return Long.parseLong("10" + FileUtil.DATE_FORMAT.format(new Date()));
	}
}
