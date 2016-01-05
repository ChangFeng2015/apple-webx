/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.apple.webx.common.page;

/**
 * 类PageUtil.java的实现描述：TODO 类实现描述
 * 
 * @author Jndong 2014年5月5日 下午5:39:09
 */
public class PageUtil {

    /***
     * 检测分页对象的完整性
     * 
     * @param page
     */
    public static Page checkPage(Page page) {
        if (page == null) {
            page = new Page(0, 10);
        }
        if (page.getCurrPage() == 0) {
            page.setCurrPage(1);
        }
        return page;
    }
}
