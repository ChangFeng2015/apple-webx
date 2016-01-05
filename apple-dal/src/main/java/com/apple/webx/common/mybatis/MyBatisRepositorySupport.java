/**
 * 
 */
package com.apple.webx.common.mybatis;

import org.apache.ibatis.session.SqlSession;

/**
 * @author liuronghuan
 *
 * 2014年6月12日
 */
public abstract class MyBatisRepositorySupport {
    private SqlSession sqlSession;

    public void setSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    
    protected final <T> T getMapper(Class<T> type) {
        return sqlSession.getMapper(type);
    }
}

