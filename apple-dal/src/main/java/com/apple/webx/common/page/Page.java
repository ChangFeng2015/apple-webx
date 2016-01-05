/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.apple.webx.common.page;

import java.io.Serializable;

/**
 * 类Page.java的实现描述：分页对象
 * <p>
 * 
 * @author Jndong 2013年12月12日 上午8:37:32
 */
public class Page implements Serializable {

	private static final long serialVersionUID = 1L;

	private int pageSize;

	private int allRecords;

	private int pageCount;

	private int begin;

	private int end;

	private int currPage;

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		if (pageSize != 0) {
			if (pageSize > 200) {
				pageSize = 10;
			}
			this.begin = (((currPage - 1) * pageSize) > 0) ? ((currPage - 1) * pageSize) : 0;
			this.end = pageSize;
		} else {
			this.begin = ((currPage - 1) * 10 > 0) ? ((currPage - 1) * 10) : 0;
			this.end = 10;

			this.pageSize = 10;
		}
		this.pageSize = pageSize;
	}

	public Page() {
		setCurrPage(0);
	}

	public Page(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}

	/**
	 * @return the begin
	 */
	public int getBegin() {
		return begin;
	}

	/**
	 * @return the currPage
	 */
	public int getCurrPage() {
		return currPage;
	}

	/**
	 * @param currPage
	 *            the currPage to set
	 */
	public void setCurrPage(int currPage) {
		if (pageSize != 0) {
			if (pageSize > 200) {
				pageSize = 10;
			}
			this.begin = (((currPage - 1) * pageSize) > 0) ? ((currPage - 1) * pageSize) : 0;
			this.end = pageSize;
		} else {
			this.begin = ((currPage - 1) * 10 > 0) ? ((currPage - 1) * 10) : 0;
			this.end = 10;

			this.pageSize = 10;
		}

		if (currPage == 0)
			this.currPage = 1;
		else
			this.currPage = currPage;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param begin
	 *            the begin to set
	 */
	public void setBegin(int begin) {
		this.begin = begin - 1;
	}

	/**
	 * @return the end
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * @param end
	 *            the end to set
	 */
	public void setEnd(int end) {
		this.end = pageSize;
	}

	public int getAllRecords() {
		return allRecords;
	}

	public void setAllRecords(int allRecords) {
		pageCount = allRecords / pageSize + allRecords % pageSize > 0 ? 1 : 0;
		this.allRecords = allRecords;
	}

	public int getPageCount() {
		return pageCount;
	}

}
