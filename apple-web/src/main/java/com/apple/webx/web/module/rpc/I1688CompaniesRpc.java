package com.apple.webx.web.module.rpc;

import javax.annotation.Resource;

import com.alibaba.citrus.turbine.dataresolver.Param;
import com.apple.webx.web.dao.I1688CompanyDao;

public class I1688CompaniesRpc {
	@Resource
	private I1688CompanyDao i1688CompanyDao;
	
	public Integer doQueryList(@Param(name="id")Integer id){
		return id;
	}
}
