/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.apple.webx.common.page;

import java.util.List;

/**
 * 类TemplatePage.java的实现描述：TODO 类实现描述 使用Java模板 进行分页操作
 * 
 * @author Jndong 2014年4月16日 下午6:01:18
 */
public class TemplatePage<T> {

    /***
     * 当前页
     */
    private int currPage;

    /***
     * 数据显示总页数
     */
    private int pageCount;

    /**
     * 数据总条数
     */
    private int totalCount;

    /***
     * 分页大小
     */
    private int pageSize;

    public TemplatePage(){

    }

    private List<T> data;

    public TemplatePage(int totalCount, List<T> data, int curPage, int pageSize){
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.data = data;
        this.currPage = curPage;

        pageCount();
    }

    public TemplatePage(int totalCount, List<T> data, int curPage){
        this.pageSize = 10;
        this.totalCount = totalCount;
        this.data = data;
        this.currPage = curPage;

        pageCount();
    }

    public void pageCount() {
        if (this.pageSize != 0) {
            if (totalCount % pageSize == 0) {
                this.pageCount = totalCount / pageSize;
            } else {
                this.pageCount = (totalCount / pageSize) + 1;
            }
        }
    }

    /**
     * @return the data
     */
    public List<T> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(List<T> data) {
        this.data = data;
    }

    /**
     * @return the currPage
     */
    public int getCurrPage() {
        return currPage;
    }

    /**
     * @param currPage the currPage to set
     */
    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    /**
     * @return the pageCount
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * @param pageCount the pageCount to set
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * @return the totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount the totalCount to set
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
