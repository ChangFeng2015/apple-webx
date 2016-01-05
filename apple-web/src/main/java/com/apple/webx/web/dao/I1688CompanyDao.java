package com.apple.webx.web.dao;

import com.apple.webx.common.page.DataResult;
import com.apple.webx.common.page.Page;
import com.apple.webx.domain.Craw1688Test;

/**
* @Title: I1688CompanyDao.java
* @Package com.apple.webx.web.dao
* @Description: webx环境搭建
* @author SmallFish  
* @date 2016年1月4日 下午5:02:10
* @version V1.0
 */
public interface I1688CompanyDao {
	/**
	 * 查询公司list
	 * @param page
	 * @return <code>
	 */
	public DataResult<Craw1688Test> doQueryList(Page page,Craw1688Test test);
}
