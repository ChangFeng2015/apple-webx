package com.apple.webx.persistence;

import com.apple.webx.domain.Craw1688Test;
import com.apple.webx.domain.Craw1688TestExample;
import com.apple.webx.domain.Craw1688TestKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Craw1688TestMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CRAW1688_TEST
     *
     * @mbggenerated Mon Jan 04 17:55:48 CST 2016
     */
    int countByExample(Craw1688TestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CRAW1688_TEST
     *
     * @mbggenerated Mon Jan 04 17:55:48 CST 2016
     */
    int deleteByExample(Craw1688TestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CRAW1688_TEST
     *
     * @mbggenerated Mon Jan 04 17:55:48 CST 2016
     */
    int deleteByPrimaryKey(Craw1688Test record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CRAW1688_TEST
     *
     * @mbggenerated Mon Jan 04 17:55:48 CST 2016
     */
    int insertSelective(Craw1688Test record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CRAW1688_TEST
     *
     * @mbggenerated Mon Jan 04 17:55:48 CST 2016
     */
    List<Craw1688Test> selectByExample(Craw1688TestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CRAW1688_TEST
     *
     * @mbggenerated Mon Jan 04 17:55:48 CST 2016
     */
    Craw1688Test selectByPrimaryKey(Craw1688TestKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CRAW1688_TEST
     *
     * @mbggenerated Mon Jan 04 17:55:48 CST 2016
     */
    int updateByExampleSelective(@Param("record") Craw1688Test record, @Param("example") Craw1688TestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CRAW1688_TEST
     *
     * @mbggenerated Mon Jan 04 17:55:48 CST 2016
     */
    int updateByExample(@Param("record") Craw1688Test record, @Param("example") Craw1688TestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CRAW1688_TEST
     *
     * @mbggenerated Mon Jan 04 17:55:48 CST 2016
     */
    int updateByPrimaryKeySelective(Craw1688Test record);
}