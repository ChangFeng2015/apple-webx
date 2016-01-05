package com.apple.webx.web.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.apple.webx.common.page.DataResult;
import com.apple.webx.common.page.Page;
import com.apple.webx.common.page.PageUtil;
import com.apple.webx.domain.Craw1688Test;
import com.apple.webx.domain.Craw1688TestExample;
import com.apple.webx.persistence.Craw1688TestMapperExt;
import com.apple.webx.web.dao.I1688CompanyDao;

public class Company1688DaoImpl implements I1688CompanyDao {
	@Autowired
	private Craw1688TestMapperExt craw1688TestMapperExt;
	@Override
	public DataResult<Craw1688Test> doQueryList(Page page) {
		PageUtil.checkPage(page);
		Craw1688TestExample example = new Craw1688TestExample();
		example.setPage(page);
		List<Craw1688Test> list = craw1688TestMapperExt.selectByExample(example);
		Integer count = craw1688TestMapperExt.countByExample(example);
		return new DataResult<Craw1688Test>(list,count);
	}

}
