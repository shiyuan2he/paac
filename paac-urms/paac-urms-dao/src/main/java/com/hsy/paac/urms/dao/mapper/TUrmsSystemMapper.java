package com.hsy.paac.urms.dao.mapper;

import com.hsy.paac.urms.base.model.TUrmsSystem;
import com.hsy.paac.urms.base.model.TUrmsSystemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUrmsSystemMapper {
    long countByExample(TUrmsSystemExample example);

    int deleteByExample(TUrmsSystemExample example);

    int deleteByPrimaryKey(Integer systemId);

    int insert(TUrmsSystem record);

    int insertSelective(TUrmsSystem record);

    List<TUrmsSystem> selectByExample(TUrmsSystemExample example);

    TUrmsSystem selectByPrimaryKey(Integer systemId);

    int updateByExampleSelective(@Param("record") TUrmsSystem record, @Param("example") TUrmsSystemExample example);

    int updateByExample(@Param("record") TUrmsSystem record, @Param("example") TUrmsSystemExample example);

    int updateByPrimaryKeySelective(TUrmsSystem record);

    int updateByPrimaryKey(TUrmsSystem record);
}