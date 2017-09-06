package com.hsy.paac.urms.dao.mapper;

import com.hsy.paac.urms.base.model.TUrmsRole;
import com.hsy.paac.urms.base.model.TUrmsRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUrmsRoleMapper {
    long countByExample(TUrmsRoleExample example);

    int deleteByExample(TUrmsRoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(TUrmsRole record);

    int insertSelective(TUrmsRole record);

    List<TUrmsRole> selectByExample(TUrmsRoleExample example);

    TUrmsRole selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") TUrmsRole record, @Param("example") TUrmsRoleExample example);

    int updateByExample(@Param("record") TUrmsRole record, @Param("example") TUrmsRoleExample example);

    int updateByPrimaryKeySelective(TUrmsRole record);

    int updateByPrimaryKey(TUrmsRole record);
}