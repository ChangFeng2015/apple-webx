package com.apple.webx.common.utill;

import java.util.Date;

public class UserUtil {
	/**
	 * 生成用户主键
	 * 
	 * @return
	 */
	public static synchronized Long uid() {
		return Long.parseLong(FileUtil.DATE_FORMAT.format(new Date()));
	}
}
