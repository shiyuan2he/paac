package com.hsy.paac.urms.dao;

import com.hsy.paac.urms.base.model.TUrmsUser;
import com.hsy.paac.urms.base.model.TUrmsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUrmsUserMapper {
    long countByExample(TUrmsUserExample example);

    int deleteByExample(TUrmsUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(TUrmsUser record);

    int insertSelective(TUrmsUser record);

    List<TUrmsUser> selectByExample(TUrmsUserExample example);

    TUrmsUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") TUrmsUser record, @Param("example") TUrmsUserExample example);

    int updateByExample(@Param("record") TUrmsUser record, @Param("example") TUrmsUserExample example);

    int updateByPrimaryKeySelective(TUrmsUser record);

    int updateByPrimaryKey(TUrmsUser record);
}