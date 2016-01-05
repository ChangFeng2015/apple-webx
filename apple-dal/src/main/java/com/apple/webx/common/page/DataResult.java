/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.apple.webx.common.page;

import java.io.Serializable;
import java.util.List;

/**
 * 类DataResult.java的实现描述： 分页组件实现类
 * <p>
 * @author Jndong 2013年12月12日 上午8:34:03
 */
public class DataResult<T> implements Serializable {

	
	
    public DataResult(List<T> data, int count) {
		super();
		this.data = data;
		this.count = count;
	}
    
    public DataResult() {
    	super();
	}

	/**
     * 数据对象
     */
    private List<T> data;

    /***
     * 总页数
     */
    private int     count;

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
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

}
