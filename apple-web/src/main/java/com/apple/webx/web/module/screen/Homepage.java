package com.apple.webx.web.module.screen;

import javax.annotation.Resource;

import com.alibaba.citrus.turbine.dataresolver.Params;
import com.apple.webx.common.page.DataResult;
import com.apple.webx.common.page.Page;
import com.apple.webx.common.page.PageUtil;
import com.apple.webx.web.dao.I1688CompanyDao;
/**
* @Title: Homepage.java
* @Package com.apple.webx.web.module.screen
* @Description: webx test
* @author SmallFish  
* @date 2016年1月4日 下午5:21:36
* @version V1.0
 */
public class Homepage {
	@Resource
	private I1688CompanyDao i1688CompanyDao;
	public DataResult<Craw1688Test> excute(@Params Page page){
		PageUtil.checkPage(page);
		return i1688CompanyDao.doQueryList(page,new Craw1688Test());
	}
}
