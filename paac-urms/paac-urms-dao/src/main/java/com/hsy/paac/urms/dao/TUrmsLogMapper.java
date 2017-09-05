package com.hsy.paac.urms.dao;

import com.hsy.paac.urms.base.model.TUrmsLog;
import com.hsy.paac.urms.base.model.TUrmsLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUrmsLogMapper {
    long countByExample(TUrmsLogExample example);

    int deleteByExample(TUrmsLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(TUrmsLog record);

    int insertSelective(TUrmsLog record);

    List<TUrmsLog> selectByExampleWithBLOBs(TUrmsLogExample example);

    List<TUrmsLog> selectByExample(TUrmsLogExample example);

    TUrmsLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") TUrmsLog record, @Param("example") TUrmsLogExample example);

    int updateByExampleWithBLOBs(@Param("record") TUrmsLog record, @Param("example") TUrmsLogExample example);

    int updateByExample(@Param("record") TUrmsLog record, @Param("example") TUrmsLogExample example);

    int updateByPrimaryKeySelective(TUrmsLog record);

    int updateByPrimaryKeyWithBLOBs(TUrmsLog record);

    int updateByPrimaryKey(TUrmsLog record);
}