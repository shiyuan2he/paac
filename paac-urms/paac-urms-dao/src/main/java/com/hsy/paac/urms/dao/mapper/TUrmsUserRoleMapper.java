package com.hsy.paac.urms.dao.mapper;

import com.hsy.paac.urms.base.model.TUrmsUserRole;
import com.hsy.paac.urms.base.model.TUrmsUserRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUrmsUserRoleMapper {
    long countByExample(TUrmsUserRoleExample example);

    int deleteByExample(TUrmsUserRoleExample example);

    int deleteByPrimaryKey(Integer userRoleId);

    int insert(TUrmsUserRole record);

    int insertSelective(TUrmsUserRole record);

    List<TUrmsUserRole> selectByExample(TUrmsUserRoleExample example);

    TUrmsUserRole selectByPrimaryKey(Integer userRoleId);

    int updateByExampleSelective(@Param("record") TUrmsUserRole record, @Param("example") TUrmsUserRoleExample example);

    int updateByExample(@Param("record") TUrmsUserRole record, @Param("example") TUrmsUserRoleExample example);

    int updateByPrimaryKeySelective(TUrmsUserRole record);

    int updateByPrimaryKey(TUrmsUserRole record);
}