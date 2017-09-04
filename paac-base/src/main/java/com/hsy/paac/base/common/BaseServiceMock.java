package com.hsy.paac.base.common;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path paac/com.hsy.paac.base.common
 * @date 04/09/2017 1:35 PM
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public abstract class BaseServiceMock<Mapper, Record, Example> implements BaseService<Record, Example> {

    @Override
    public int countByExample(Example example) {
        return -1;
    }

    @Override
    public int deleteByExample(Example example) {
        return -1;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return -1;
    }

    @Override
    public int insert(Record record) {
        return -1;
    }

    @Override
    public int insertSelective(Record record) {
        return -1;
    }

    @Override
    public List<Record> selectByExampleWithBLOBs(Example example) {
        return null;
    }

    @Override
    public List<Record> selectByExample(Example example) {
        return null;
    }

    @Override
    public List<Record> selectByExampleWithBLOBsForStartPage(Example example, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public List<Record> selectByExampleForStartPage(Example example, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public List<Record> selectByExampleWithBLOBsForOffsetPage(Example example, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public List<Record> selectByExampleForOffsetPage(Example example, Integer offset, Integer limit) {
        return null;
    }

    @Override
    public Record selectFirstByExample(Example example) {
        return null;
    }

    @Override
    public Record selectFirstByExampleWithBLOBs(Example example) {
        return null;
    }

    @Override
    public Record selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example) {
        return -1;
    }

    @Override
    public int updateByExampleWithBLOBs(@Param("record") Record record, @Param("example") Example example) {
        return -1;
    }

    @Override
    public int updateByExample(@Param("record") Record record, @Param("example") Example example) {
        return -1;
    }

    @Override
    public int updateByPrimaryKeySelective(Record record) {
        return -1;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Record record) {
        return -1;
    }

    @Override
    public int updateByPrimaryKey(Record record) {
        return -1;
    }

    @Override
    public int deleteByPrimaryKeys(String ids) {
        return -1;
    }

    @Override
    public void initMapper() {}

}
