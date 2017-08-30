package com.hsy.paac.dao.mapper;

import com.hsy.paac.dao.model.TUrmsUser;
import com.hsy.paac.dao.model.TUrmsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUrmsUserMapper {
    long countByExample(TUrmsUserExample example);

    int deleteByExample(TUrmsUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(TUrmsUser record);

    int insertSelective(TUrmsUser record);

    List<TUrmsUser> selectByExample(TUrmsUserExample example);

    TUrmsUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TUrmsUser record, @Param("example") TUrmsUserExample example);

    int updateByExample(@Param("record") TUrmsUser record, @Param("example") TUrmsUserExample example);

    int updateByPrimaryKeySelective(TUrmsUser record);

    int updateByPrimaryKey(TUrmsUser record);
}