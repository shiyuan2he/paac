package com.hsy.paac.base.common;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path paac/com.hsy.paac.base.common
 * @date 04/09/2017 1:34 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface BaseService<Record, Example> {

    int countByExample(Example example);

    int deleteByExample(Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Record record);

    int insertSelective(Record record);

    List<Record> selectByExampleWithBLOBs(Example example);

    List<Record> selectByExample(Example example);

    List<Record> selectByExampleWithBLOBsForStartPage(Example example, Integer pageNum, Integer pageSize);

    List<Record> selectByExampleForStartPage(Example example, Integer pageNum, Integer pageSize);

    List<Record> selectByExampleWithBLOBsForOffsetPage(Example example, Integer offset, Integer limit);

    List<Record> selectByExampleForOffsetPage(Example example, Integer offset, Integer limit);

    Record selectFirstByExample(Example example);

    Record selectFirstByExampleWithBLOBs(Example example);

    Record selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example);

    int updateByExampleWithBLOBs(@Param("record") Record record, @Param("example") Example example);

    int updateByExample(@Param("record") Record record, @Param("example") Example example);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKeyWithBLOBs(Record record);

    int updateByPrimaryKey(Record record);

    int deleteByPrimaryKeys(String ids);

    void initMapper();

}
